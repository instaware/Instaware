package org.instaware.core.society.model;

import java.util.LinkedList;

/**
 * Encapsulates and manages {@link Entity} units.
 * 
 * @author Thomas Nappo
 * 
 * @param T The type of {@link Entity} which this list holds.
 */
@SuppressWarnings("serial")
public class EntityList<T extends Entity> extends LinkedList<T> {
	
	/**
	 * Appends an update which removes
	 * inactive slots.
	 */
	public void update() {
		for (int i = 0; i < size(); i++) 
			if (get(i) == null) remove(i);
	}
	
}