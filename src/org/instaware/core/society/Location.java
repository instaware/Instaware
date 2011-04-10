package org.instaware.core.society;

/**
 * A position on the tile grid.
 * @author Thomas Nappo
 */
public class Location {
	
	private int x, y, z;
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}
	
	/**
	 * Constructs a new <tt>Location</tt>.
	 */
	public Location(int x, int y, int z) {
		this.x = x; this.y = y; this.z = z;
	}
	
	/**
	 * Constructs a new <tt>Location</tt>.
	 */
	public Location(int x, int y) {
		this(x, y, 0);
	}
	
	/**
	 * Creates a new <tt>Location</tt>.
	 * @return The builded <tt>Location</tt> object.
	 */
	public static Location create(int x, int y, int z) {
		return new Location(x, y, z);
	}
	
	/**
	 * Creates a new <tt>Location</tt>.
	 * @return The builded <tt>Location</tt> object.
	 */
	public static Location create(int x, int y) {
		return new Location(x, y);
	}

}