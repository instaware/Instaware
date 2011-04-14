package org.instaware.core.society.model.container;

import org.instaware.core.society.model.Item;

/**
 * Encapsulates and manages {@link Item} units.
 * @author Thomas Nappo
 */
public abstract class Container {
	
	/**
	 * Holds {@link Item} units for the container.
	 */
	private Item[] data;
	
	/**
	 * Converts this <tt>Container</tt> to an array of {@link Item}s.
	 * @return This <tt>Container</tt> as an array of <tt>Item</tt>s.
	 */
	public Item[] toArray() {
		return data;
	}
	
	public void put(int index, Item item) {
		data[index] = (Item) item.setIndex(index);
	}
	
	public void add(Item item) {
		put(nextOpenSlot(), item);
	}
	
	
	
	/**
	 * Retrieves the next open slot.
	 * @return The next open slot id.
	 */
	public int nextOpenSlot() {
		for (int i = 0; i < data.length; i++)
			if (data[i] == null) return i;
		return -1;
	}

}