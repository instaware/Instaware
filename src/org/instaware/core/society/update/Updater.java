package org.instaware.core.society.update;

import org.instaware.core.society.model.Entity;

/**
 * Provides the blueprints for an {@link Entity} updater.
 * @author Thomas Nappo
 */
public abstract class Updater<T extends Entity> {

	/**
	 * Updates all entities of the type.
	 */
	public abstract void updateAll();
	
	/**
	 * Updates one {@link Entity}.
	 * @param t The <tt>Entity</code> to update.
	 */
	public abstract void update(T t);
	
}