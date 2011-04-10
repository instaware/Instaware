package org.instaware.network.codec;

import java.io.IOException;

import org.instaware.Constants;
import org.instaware.core.society.model.players.Player;
import org.instaware.network.nexus.input.Packet;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

/**
 * Decodes packet process requests.
 * @see {@link FrameDecoder}
 * @author Thomas Nappo
 */
public class Decoder extends FrameDecoder {
	
	/**
	 * The sender of the request.
	 */
	private Player player;
	
	/**
	 * Constructs a new packet decoder.
	 * @param player The sender of the request.
	 */
	public Decoder(Player player) {
		this.player = player;
	}

	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer) throws Exception {
		if (!buffer.readable()) throw new IOException("Channel buffer unreadable while decoding.");
		int opCode = buffer.readUnsignedByte();
		int length = Constants.PACKET_LENGTHS[opCode];
		if (length < 0) length = buffer.readUnsignedByte();
		if (buffer.readableBytes() >= length & length > 0) {
			byte[] payload = new byte[length];
			buffer.readBytes(payload);
			
			Packet packet = new Packet(player, opCode, payload);
			player.getNetQueue().add(packet);
			
			return packet;
		}
		return null;
	}

}