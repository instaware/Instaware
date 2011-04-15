package org.instaware.core.society.model;

/**
 * Represents a graphic.
 * @author Thomas Nappo
 */
public class Graphic {
	
	/**
	 * The graphic's id.
	 */
	private int id;
	
	/**
	 * Retrieves the graphic's id.
	 * @return The graphic's id.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * The graphic's delay.
	 */
	private int delay;
	
	/**
	 * Retrieves the graphic's delay.
	 * @return The graphic's delay.
	 */
	public int getDelay() {
		return delay;
	}
	
	/**
	 * The graphic's height.
	 */
	private int height;
	
	/**
	 * Retrieves the graphic's height.
	 * @return The graphic's height.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Constructs a new {@link Graphic}.
	 * @param id The identification number of the graphic.
	 * @param height The height of the graphic.
	 * @param delay The delay of the graphic.
	 */
	public Graphic(int id, int height, int delay) {
		this.id = id; this.height = height; this.delay = delay;
	}
	
	/**
	 * Constructs a new {@link Graphic}.
	 * @param id The identification number of the graphic.
	 * @param height The height of the graphic.
	 */
	public Graphic(int id, int height) {
		this(id, height, 0);
	}
	
	/**
	 * Constructs a new {@link Graphic}.
	 * @param id The identification number of the graphic.
	 */
	public Graphic(int id) {
		this(id, 0);
	}
	
	/**
	 * Createsa new {@link Graphic}.
	 * @param id The identification number of the graphic.
	 * @param height The height of the graphic.
	 * @param delay The delay of the graphic.
	 */
	public static Graphic create(int id, int height, int delay) {
		return new Graphic(id, height, delay);
	}
	
	/**
	 * Creates a new {@link Graphic}.
	 * @param id The identification number of the graphic.
	 * @param height The height of the graphic.
	 */
	public static Graphic create(int id, int height) {
		return new Graphic(id, height);
	}
	
	/**
	 * Creates a new {@link Graphic}.
	 * @param id The identification number of the graphic.
	 */
	public static Graphic create(int id) {
		return new Graphic(id);
	}
	
}