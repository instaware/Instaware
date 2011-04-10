package org.instaware.network.nexus.input.process;

import java.util.logging.Logger;

import org.instaware.core.society.model.players.Player;
import org.instaware.network.nexus.InBuffer;
import org.instaware.network.nexus.input.PacketProcessor;

/**
 * Interprets a packet processing request by
 * displaying the request's information towards the
 * console.
 * 
 * @see {@link PacketProcessor}
 * @author Thomas Nappo
 */
public class DefaultPacketProcessor implements PacketProcessor {
	
	/**
	 * Used for displaying received packet information.
	 */
	private static final Logger logger = Logger.getLogger(DefaultPacketProcessor.class.getName());

	@Override
	public void process(InBuffer buffer, Player player) {
		logger.info("Unhandled packet: " + buffer);
	}

}