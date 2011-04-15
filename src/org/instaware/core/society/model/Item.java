package org.instaware.core.society.model;

/**
 * Represents an item.
 * @author Thomas Nappo
 */
public class Item extends Entity {
	
	/**
	 * The item's id.
	 */
	private int id;
	
	/**
	 * The item's amount.
	 */
	private int amount;
	
	/**
	 * Retrieves the item's id.
	 * @return The item's id.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Retrieves the item's amount.
	 * @return The item's amount.
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Constructs a new {@link Item}.
	 * @param id The item's identification number.
	 * @param amount The item's amount.
	 * @param index The item's slot.
	 */
	public Item(int id, int amount, int index) {
		super(index);
		this.id = id; this.amount = amount;
	}
	
	/**
	 * Constructs a new {@link Item}.
	 * @param id The item's identification number.
	 * @param amount The item's amount.
	 */
	public Item(int id, int amount) {
		this(id, amount, -1);
	}
	
	/**
	 * Constructs a new {@link Item}.
	 * @param id The item's identification number.
	 */
	public Item(int id) {
		this(id, 1);
	}

}