package org.instaware.network.codec;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.logging.Logger;

import org.instaware.Constants;
import org.instaware.core.Global;
import org.instaware.network.codec.LoginDecoder.LoginState;
import org.instaware.network.nexus.*;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;

/**
 * Decodes RS2 login requests.
 * @see {@link ReplayingDecoder }
 * @author Thomas Nappo
 */
@SuppressWarnings("unused")
public class LoginDecoder extends ReplayingDecoder<LoginState> {

	/**
	 * Represents a state of login request.
	 * @author Thomas Nappo
	 */
	public enum LoginState {

		/**
		 * Represents a login stage where the handshake between server & client is done.
		 */
		HANDSHAKE,

		/**
		 * Represents a login stage where the client requests keys to
		 * update on demand or an update which streams cache from the server
		 * module to the client.
		 */
		ON_DEMAND,

		/**
		 * Represents a login stage where the client is processed to
		 * the game interface and completes the login.
		 */
		FINISH;

	}
	
	/**
	 * Constructs a new <tt>LoginDecoder</tt>.
	 */
	public LoginDecoder() {
		super(false);
		checkpoint(LoginState.HANDSHAKE);
	}

	/**
	 * The server revision.
	 */
	private static final int REVISION = Global.getProperties().getIntProperty("revision");
	
	/**
	 * Handshake op codes.
	 */
	public static final int JS5_OPCODE = 15, LOGIN_OPCODE = 14;
	
	/**
	 * Secure random generator.
	 */
	private static final SecureRandom RANDOM = new SecureRandom();

	/**
	 * Name hash of the decoder.
	 */
	private int nameHash;

	/**
	 * Server key of the decoder.
	 */
	private long serverKey;
	
	private String readRS2String(ChannelBuffer buffer) {
		StringBuilder sb = new StringBuilder();
		byte b;
		while ((b = buffer.readByte()) != 0) {
			sb.append((char) b);
		}
		return sb.toString();
	}

	private String longToPlayerName(long l) {
		if (l <= 0L || l >= 0x5b5b57f8a98a5dd1L) {
			return null;
		}
		if (l % 37L == 0L) {
			return null;
		}
		int i = 0;
		char ac[] = new char[12];
		while (l != 0L) {
			long l1 = l;
			l /= 37L;
			ac[11 - i++] = VALID_CHARS[(int)(l1 - l * 37L)];
		}
		return new String(ac, 12 - i, i);
	}
	
    /**
     * Valid character literals.
     */
    public static final char[] VALID_CHARS = {
    	'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
    	'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
    	't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2',
    	'3', '4', '5', '6', '7', '8', '9'
    };
    
    /**
     * Used to display information.
     */
    private static final Logger logger = Logger.getLogger(LoginDecoder.class.getName());

	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer, LoginState state) throws Exception {
		switch (state) {
		case HANDSHAKE:
			int opCode = buffer.readUnsignedByte();
			switch (opCode) {
			case LOGIN_OPCODE: // Login
				nameHash = buffer.readUnsignedByte();
				channel.write(new OutBuffer().addByte((byte) 0).addLong(serverKey = RANDOM.nextLong()).asInput());
				checkpoint(LoginState.FINISH);
				break;
			case JS5_OPCODE: // Update
				int revision = buffer.readInt();
				if (revision != REVISION) throw new IOException("Revision mismatch: expected=" + REVISION + " received=" + revision);
				channel.write(new OutBuffer().addByte((byte) 0).asInput());
				checkpoint(LoginState.ON_DEMAND);
			}
			break;
		case ON_DEMAND:
			if (buffer.readableBytes() >= 4) {
				buffer.skipBytes(4); //this is request bytes
				OutBuffer response = new OutBuffer();
				for (int key : Constants.UPDATE_KEYS) response.addByte((byte) key);
				channel.write(response.asInput()).addListener(ChannelFutureListener.CLOSE);
				System.out.println("WRITTEN");
				return true;
			}
			break;
		case FINISH:
			if (buffer.readableBytes() >= 3) {
				int connectionType = buffer.readByte() & 0xff;
				if (connectionType != 16 && connectionType != 18) // 16 = new connection, 18 = reconnection
					throw new IOException("Unexpected connection type!");
				int payloadLength = buffer.readByte() & 0xff;
				if (payloadLength <= buffer.readableBytes()) {
					int revision = buffer.readInt();
					if (revision != REVISION) throw new IOException("Revision mismatch: expected=" + REVISION + " received=" + revision);
					boolean lowMemoryVersion = buffer.readByte() == 1;
					buffer.skipBytes(24);
					for (int n = 0; n < 16; n++) buffer.readInt();
					int rsaHeader = buffer.readByte();
					if (rsaHeader != 10) {
						int rsaHeaderEnc = buffer.readByte() & 0xff; // Now hopefully we get 10.
						if (rsaHeaderEnc != 10) throw new IOException("Invalid RSA header! received(encoded)=" + rsaHeaderEnc);
						long clientSessionKey = buffer.readLong();
						long serverSessionKey = buffer.readLong();
						if (serverKey != serverSessionKey) throw new IOException("Server key mismatch, received=" + serverSessionKey + " expected=" + serverKey);
						
						String username = longToPlayerName(buffer.readLong());
						String password = readRS2String(buffer);
						
						logger.info("Login request: " + username + ", " + password);
					}
				}
				return true;
			}
			break;
		}
		return null;
	}

}