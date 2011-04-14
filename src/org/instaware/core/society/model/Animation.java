package org.instaware.core.society.model;

/**
 * Represents an animation.
 * @author Thomas Nappo
 */
public class Animation {
	
	private int id;
	
	public int getId() {
		return id;
	}
	
	private int delay;
	
	public int getDelay() {
		return delay;
	}
	
	public Animation(int id, int delay) {
		this.id = id; this.delay = delay;
	}
	
	public Animation(int id) {
		this(id, 0);
	}
	
	public static Animation create(int id, int delay) {
		return new Animation(id, delay);
	}
	
	public static Animation create(int id) {
		return new Animation(id);
	}

}