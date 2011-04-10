package org.instaware.network.nexus.output;

/**
 * A mutable sequence of bytes used to construct the immutable
 * <code>Packet</code> objects.
 * By default, methods use <tt>big endian byte</tt> ordering.
 * 
 * @see <a href=http://en.wikipedia.org/wiki/Network_packet>Network packet</a></br>{@link Packet}
 * @author Thomas Nappo
 */
public class PacketBuilder {
	
	/**
	 * The default data capacity.
	 */
	@SuppressWarnings("unused")
	private static final int DEFAULT_SIZE = 32;

}