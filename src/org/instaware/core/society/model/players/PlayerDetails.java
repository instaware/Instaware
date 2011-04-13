package org.instaware.core.society.model.players;

import org.jboss.netty.channel.Channel;

/**
 * Encapsulates a {@link Player}s connection details.
 * @author Thomas Nappo
 */
public class PlayerDetails {
	
	/**
	 * The connection channel the player
	 * is connected to the server with.
	 */
	private Channel channel;
	
	/**
	 * Gets the connection channel the player
	 * is connected to the server with.
	 * @return The connection channel the player
	 * is connected to the server with.
	 */
	public Channel getChannel() {
		return channel;
	}
	
	/**
	 * The username of the player.
	 */
	private String username;
	
	/**
	 * Retrieves the username of the player.
	 * @return The username of the player.
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * The password of the player.
	 */
	private String password;
	
	/**
	 * Retrieves the password of the player.
	 * @return The password of the player.
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Create a new set of details.
	 * @param channel The player's connection channel.
	 * @param username The username of the player.
	 * @param password The password of the player.
	 */
	public PlayerDetails(Channel channel, String username, String password) {
		this.channel = channel;
		this.username = username; this.password = password;
	}

}