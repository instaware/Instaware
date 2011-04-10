package org.instaware.core.society.model.players;

import org.instaware.core.society.model.Mob;

/**
 * Represents a player character.
 * @see {@link Mob}
 * @author Thomas Nappo
 */
public class Player extends Mob {

	/**
	 * Constructs a new player.
	 * @param index The index identification.
	 */
	public Player(int index) {
		super(index);
	}

	@Override
	public int getFormattedIndex() {
		return index + 32667;
	}

}