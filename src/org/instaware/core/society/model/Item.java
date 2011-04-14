package org.instaware.core.society.model;

/**
 * Represents an item.
 * @author Thomas Nappo
 */
public class Item extends Entity {
	
	private int id;
	
	private int amount;
	
	public int getId() {
		return id;
	}
	
	public int getAmount() {
		return amount;
	}

	public Item(int id, int amount, int index) {
		super(index);
		this.id = id; this.amount = amount;
	}

}