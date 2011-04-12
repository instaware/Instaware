package org.instaware.core.society;

/**
 * <p>A position on the tile grid.</p>
 * 
 * <p>Each position of the world is marked by a <tt>Location</tt>
 * which contains the position's X, Y, and Z coordinates. The
 * <a href=http://runescape.com>RuneScape</a> grid uses the
 * <a href=http://en.wikipedia.org/wiki/Cartesian_coordinate_system>
 * Cartesian coordinate system</a>, however <i>Z</i> is the grid level.</p>
 * 
 * <b>More information about grid level:</b>
 * <p>A system of tiles, originated for use in multiple floors. When a
 * player climbs a ladder, they are (usually) brought up by one <i>Z</i>
 * coordinate.</p>
 * 
 * <p>While the previous example is easily understood, the height system
 * also has another, very useful attribute. When <a href=http://jagex.com>Jagex</a>
 * coveted an <a href=http://runescape.wikia.com/wiki/Activities>activity</a> which could take place in one world, two separate games, asynchronously,
 * they took advantage of the height system's replication.</p>
 * 
 * <p>The height system only expands 3 height levels (up). After the 3rd height,
 * the system returns a clone of height 0, making it's markway back up to 3 more heights.
 * The system also works with negative heights, however going down a level from height 0 (a clone included)
 * brings you to a height level 3 clone.</p>
 * 
 * <p><a href=http://runescape.wikia.com/wiki/TzHaar_Fight_Cave>Tzhaar Fight Caves</a> is an activity which
 * incorporates this system.</p>
 * 
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