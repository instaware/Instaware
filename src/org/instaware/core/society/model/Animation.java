package org.instaware.core.society.model;

/**
 * Represents an animation.
 * @author Thomas Nappo
 */
public class Animation {
	
	/**
	 * The animation's id.
	 */
	private int id;
	
	/**
	 * Retrieves the animation's id.
	 * @return The animation's id.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * The animation's delay.
	 */
	private int delay;
	
	/**
	 * Retrieves the animation's delay.
	 * @return The animation's delay.
	 */
	public int getDelay() {
		return delay;
	}
	
	/**
	 * Constructs a new {@link Animation}.
	 * @param id The identification number of the animation.
	 * @param delay The delay of the animation.
	 */
	public Animation(int id, int delay) {
		this.id = id; this.delay = delay;
	}
	
	/**
	 * Constructs a new {@link Animation}.
	 * @param id The identification number of the animation.
	 */
	public Animation(int id) {
		this(id, 0);
	}
	
	/**
	 * Creates a new {@link Animation}.
	 * @param id The identification number of the animation.
	 * @param delay The delay of the animation.
	 */
	public static Animation create(int id, int delay) {
		return new Animation(id, delay);
	}
	
	/**
	 * Creates a new {@link Animation}.
	 * @param id The identification number of the animation.
	 */
	public static Animation create(int id) {
		return new Animation(id);
	}

}