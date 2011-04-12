package org.instaware.core.society.model.players;

import java.util.ArrayDeque;
import java.util.Deque;

import org.instaware.core.society.model.*;
import org.instaware.network.nexus.input.Packet;
import org.instaware.network.nexus.output.PacketSender;

/**
 * Represents a player character.
 * @see {@link Mob}
 * @author Thomas Nappo
 */
public class Player extends Mob {
	
	/**
	 * Sends game packets towards the player's client.
	 */
	private PacketSender packetSender = new PacketSender(this);
	
	/**
	 * Retrieves the player's {@link PacketSender}.
	 * @return The player's <tt>PacketSender</tt>.
	 */
	public PacketSender getPacketSender() {
		return packetSender;
	}
	
	/**
	 * Queues {@link Packet} process requests.
	 */
	private Deque<Packet> networkQueue = new ArrayDeque<Packet>();
	
	/**
	 * Retrieves the player's {@link Packet} request queue.
	 * @return A {@link Deque} that packet process requests are held.
	 */
	public Deque<Packet> getNetQueue() {
		return networkQueue;
	}

	/**
	 * Constructs a new player.
	 * @param index The index identification.
	 */
	public Player(int index) {
		super(index);
	}

	@Override
	public int getFormattedIndex() {
		return index + 32768;
	}

}