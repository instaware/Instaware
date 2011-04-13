package org.instaware.core.society.model.players;

import java.util.ArrayDeque;
import java.util.Deque;

import org.instaware.core.society.model.*;
import org.instaware.network.nexus.input.Packet;
import org.instaware.network.nexus.output.PacketSender;
import org.jboss.netty.channel.Channel;

/**
 * Represents a player character.
 * @see {@link Mob}
 * @author Thomas Nappo
 */
public class Player extends Mob {
	
	/**
	 * The player's connection details.
	 */
	private PlayerDetails details = null;
	
	/**
	 * Gets the player's connection details.
	 * @return A {@link PlayerDetails} object, which encapsulates
	 * this player's connection attrbutes.
	 */
	public PlayerDetails getDetails() {
		return details;
	}
	
	/**
	 * Retrieves the player's connection {@link Channel}.
	 * @return The player's connection <tt>Channel</tt> for which
	 * they are connected to the server by.
	 */
	public Channel getChannel() {
		return details.getChannel();
	}
	
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
	 * @param details The connection details.
	 */
	public Player(int index, PlayerDetails details) {
		super(index); this.details = details;
	}
	
	/**
	 * Constructs a new player.
	 * @param details The connection details.
	 */
	public Player(PlayerDetails details) {
		this(-1, details);
	}
	
	@Override
	public String toString() {
		return "[index=" + index + ", name=" + details.getUsername() + "]";
	}

	@Override
	public int getFormattedIndex() {
		return index + 32768;
	}

}