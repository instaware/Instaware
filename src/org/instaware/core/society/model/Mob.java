package org.instaware.core.society.model;

/**
 * An entity which has the ability to move.
 * @see {@link Entity}
 * @author Thomas Nappo
 */
public abstract class Mob extends Entity {

	/**
	 * Constructs a new mobile {@link Entity}.
	 * @param index The index identification.
	 */
	public Mob(int index) {
		super(index);
	}
	
	/**
	 * Retrieves the mob's index formatted for the game client.
	 * @return The mob's index formatted for the game client.
	 */
	public abstract int getFormattedIndex();
 
}