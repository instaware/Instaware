package org.instaware.network.codec;

import java.io.IOException;

import org.instaware.core.Global;
import org.instaware.network.codec.LoginDecoder.LoginState;
import org.instaware.network.nexus.*;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;

/**
 * Decodes RS2 login requests.
 * @see {@link ReplayingDecoder }
 * @author Thomas Nappo
 */
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
	 * The server revision.
	 */
	private static final int REVISION = Global.getProperties().getIntProperty("revision");

	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer, LoginState state) throws Exception {
		switch(state) {
		case HANDSHAKE:
			int opCode = buffer.readUnsignedByte();
			switch(opCode) {
			case 14: // Login
				checkpoint(LoginState.FINISH);
				break;
			case 15: // Update
				int revision = buffer.readInt();
				if(revision != REVISION) throw new IOException("Revision mismatch: expected=" + REVISION + " received=" + revision);
				channel.write(new OutBuffer().addByte((byte) 0).asInput());
				checkpoint(LoginState.ON_DEMAND);
				break;
			}
			break;
		case ON_DEMAND:
			break;
		case FINISH:
			break;
		}
		return null;
	}

}