package org.instaware.network.nexus.output;

import org.instaware.core.society.model.players.Player;
import org.instaware.network.nexus.OutBuffer;

/**
 * An {@link OutBuffer} that constructs game packets and sends them out toward clients.
 * 
 * @see {@link OutBuffer}
 * @author Thomas Nappo
 */
public class PacketSender extends OutBuffer {
	
	/**
	 * {@link Player} whom's client requests the packet.
	 */
	protected Player player;
	
	/**
	 * Constructs a new <tt>PacketSender</tt>.
	 * @param player The {@link Player} 
	 */
	public PacketSender(Player player) {
		this.player = player;
	}

}