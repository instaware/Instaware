package org.instaware.core.society.model;

/**
 * Provides interfacing for various game entities.
 * @author Thomas Nappo
 */
public abstract class Entity {
	
	/**
	 * Index identification.
	 */
	protected int index;
	
	/**
	 * Constructs a new entity.
	 * @param index The index identification.
	 */
	public Entity(int index) {
		this.index = index;
	}

}