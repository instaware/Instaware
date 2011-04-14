package org.instaware.core.society.model;

/**
 * Represents a graphic.
 * @author Thomas Nappo
 */
public class Graphic {
	
	private int id;
	
	private int delay;
	
	private int height;
	
	public int getId() {
		return id;
	}
	
	public int getDelay() {
		return delay;
	}
	
	public int getHeight() {
		return height;
	}

	public Graphic(int id, int height, int delay) {
		this.id = id; this.height = height; this.delay = delay;
	}
	
	public Graphic(int id, int height) {
		this(id, height, 0);
	}
	
	public Graphic(int id) {
		this(id, 0);
	}
	
	public static Graphic create(int id, int height, int delay) {
		return new Graphic(id, height, delay);
	}
	
	public static Graphic create(int id, int height) {
		return new Graphic(id, height);
	}
	
	public static Graphic create(int id) {
		return new Graphic(id);
	}
	
}