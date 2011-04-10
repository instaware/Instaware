package org.instaware.network.nexus.input.process;

import org.instaware.core.society.model.players.Player;
import org.instaware.network.nexus.InBuffer;
import org.instaware.network.nexus.input.PacketProcessor;

/**
 * <p>Any {@link Packet} that is designated towards
 * this {@link PacketProcessor} is never interpreted.</p>
 * 
 * <p>By default packets are not sent to this processor
 * but instead {@link DefaultPacketProcessor}</p>
 * 
 * @see {@link PacketProcessor}
 * @author Thomas Nappo
 */
public class QuietPacketProcessor implements PacketProcessor {

	@Override
	public void process(InBuffer buffer, Player player) {
		// Just eat up any data.
	}

}