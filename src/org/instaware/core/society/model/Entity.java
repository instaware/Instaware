package org.instaware.core.society.model;

import org.instaware.core.society.Location;

/**
 * Provides interfacing for various game entities.
 * @author Thomas Nappo
 */
public abstract class Entity {
	
	/**
	 * The position this <tt>Entity</tt> lies on the tile grid.
	 */
	protected Location location = Location.create(3222, 3222);
	
	/**
	 * Gets this <tt>Entity</tt>'s tile position.
	 * @return  The position the <tt>Entity</tt> lies on the tile grid.
	 */
	public Location getLocation() {
		return location;
	}
	
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