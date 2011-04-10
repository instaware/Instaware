package org.instaware.core.society.model.players;

import java.util.ArrayDeque;
import java.util.Deque;

import org.instaware.core.society.model.Mob;
import org.instaware.network.nexus.input.Packet;

/**
 * Represents a player character.
 * @see {@link Mob}
 * @author Thomas Nappo
 */
public class Player extends Mob {
	
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