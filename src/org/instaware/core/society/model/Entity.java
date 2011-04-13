package org.instaware.core.society.model;

import org.instaware.core.society.Location;
import org.instaware.core.society.update.UpdateFlags;
import org.instaware.core.society.update.UpdateFlags.UpdateFlag;

/**
 * Provides interfacing for various game entities.
 * @author Thomas Nappo
 */
public abstract class Entity {
	
	/**
	 * Manages {@link UpdateFlag}s for this <tt>Entity</tt>.
	 */
	protected UpdateFlags updateFlags = new UpdateFlags();
	
	/**
	 * Retrieves this <tt>Entity</tt>'s {@link UpdateFlags}.
	 * @return This <tt>Entity</tt>'s <tt>UpdateFlags</tt>.
	 */
	public UpdateFlags getUpdateFlags() {
		return updateFlags;
	}
	
	/**
	 * The position this <tt>Entity</tt> lies on the tile grid.
	 */
	protected Location location = Location.create(3222, 3222);
	
	/**
	 * Retrieves this <tt>Entity</tt>'s tile position.
	 * @return The position the <tt>Entity</tt> lies on the tile grid.
	 */
	public Location getLocation() {
		return location;
	}
	
	/**
	 * Index identification.
	 */
	protected int index = 0;
	
	/**
	 * Constructs a new entity.
	 * @param index The index identification.
	 */
	public Entity(int index) {
		this.index = index;
	}

}