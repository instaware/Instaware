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
	 * Manages the player's on screen {@link Mob}s.
	 */
	private OnScreenManager osManager = new OnScreenManager();
	
	/**
	 * Retrieves the player's on screen manager.
	 * @return The player's {@link OnScreenManager}.
	 */
	public OnScreenManager getOSManager() {
		return osManager;
	}
	
	/**
	 * Represents the appearance of the player.
	 */
	private Appearance appearance = new Appearance();
	
	/**
	 * Retrieves the player's appearance.
	 * @return The player's appearance.
	 */
	public Appearance getAppearance() {
		return appearance;
	}
	
	/**
	 * The player's connection details.
	 */
	private PlayerDetails details = null;
	
	/**
	 * Retrieves the player's connection details.
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
	 * Checks whether or not the player's channel is connected.
	 * @return <tt>true</tt> if the player's channel is connected.
	 */
	public boolean isConnected() {
		return getChannel().isConnected();
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
	 * The player's {@link Right} level.
	 */
	private Right right = Right.STANDARD;
	
	/**
	 * Retrieves the player's right level.
	 * @return The player's {@link Right} level.
	 */
	public Right getRight() {
		return right;
	}
	
	/**
	 * Represents a user's player rights.
	 * @author Thomas Nappo
	 */
	public static enum Right {
		
		/**
		 * Right in which the user cannot connect
		 * to the server.
		 */
		BANNED(-2),
		
		/**
		 * Right in which the user cannot use any
		 * chat channels.
		 */
		MUTED(-1),
		
		/**
		 * Standard user rights.
		 */
		STANDARD(0),
		
		/**
		 * Standard user rights, with some varying
		 * exceptions.
		 */
		MODERATOR(1),
		
		/**
		 * Administrative user rights, which includes
		 * powerful access.
		 */
		ADMINISTRATOR(2);
		
		/**
		 * Power value.
		 */
		private int val;
		
		/**
		 * Converts the right to it's power value.
		 * @return The right to it's power value.
		 */
		public int toInteger() {
			return val;
		}
		
		/**
		 * Retrieves the right's representative
		 * crown code id.
		 * @return The right's crown id.
		 */
		public int getCrown() {
			if (val < 1) return 0;
			if (val > 2) return 2;
			return val;
		}
		
		/**
		 * Constructs a new right.
		 * @param val The power value of the right.
		 */
		Right(int val) {
			this.val = val;
		}
		
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