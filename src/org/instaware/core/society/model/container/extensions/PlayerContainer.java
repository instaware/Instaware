package org.instaware.core.society.model.container.extensions;

import org.instaware.core.society.model.container.Container;
import org.instaware.core.society.model.players.Player;

/**
 * Encapsulates and contains {@link Item} units for a {@link Player}.
 * @author Thomas Nappo
 */
public abstract class PlayerContainer extends Container {

	/**
	 * The player whom has ownership of this container.
	 */
	private Player player;
	
	/**
	 * Retrieves the player whom has ownership of the container.
	 * @return The player whom has ownership of the container.
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Constructs a new <tt>PlayerContainer</tt>.
	 * @param player The player whom owns the container.
	 */
	public PlayerContainer(Player player) {
		this.player = player;
	}
	
}