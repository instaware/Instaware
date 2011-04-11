package org.instaware.network.nexus.input;

/**
 * Distributes {@link Packet}s towards their appropriate {@link PacketProcessor}.
 * @author Thomas Nappo
 */
public final class PacketDispatcher {
	
	/**
	 * Holds packet handlers, proprieted to their identification
	 * number in which they handle. Identifiers may point to same handlers.
	 */
	private static PacketProcessor[] cells = new PacketProcessor[256];
	
	/**
	 * Gets the packet handler cell data.
	 * @return The packet handler cell data, as a <tt>PacketProcessor</tt> array.
	 */
	public static PacketProcessor[] getCells() {
		return cells;
	}
	
	/**
	 * Associates a <tt>PacketProcessor</tt> with an identification number.
	 * @param id The identification number which the <tt>PacketProcessor</tt> will be associated with. (<tt>Packet</tt> op code)
	 * @param handler The <tt>PacketProcessor</tt> which will be used for handling message packets with the specific id.
	 */
	public static void put(int id, PacketProcessor handler) {
		cells[id] = handler;
	}
	
	/**
	 * Associates default <code>PacketProcessor</code>s with their default
	 * identification op-codes.
	 */
	public static void feed() {
		// Fill in op-codes (ids) for the handlers.
		// example: cells[176] = walking;
		
		// Have only one instance of handlers
		// Which we can repeatedly use.
	}

}