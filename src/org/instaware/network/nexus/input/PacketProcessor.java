package org.instaware.network.nexus.input;

import org.instaware.core.society.model.players.Player;
import org.instaware.network.nexus.InBuffer;

/**
 * <p>Provides interfacing for selective logic
 * performers.</p>
 * 
 * <p>A <tt>Packetprocessor</tt> has the ability
 * to interpret a {@link InBuffer} which encapsulates
 * with the {@link Player} whom sent a process request
 * for the server to handle.</p>
 * 
 * @author Thomas Nappo
 */
public interface PacketProcessor {
	
	/**
	 * Appends processing on a packet.
	 * @param packet The data containing {@link InBuffer} to process.
	 * @param player The {@link Player} whom sent the process request.
	 */
	public void process(InBuffer buffer, Player player);

}