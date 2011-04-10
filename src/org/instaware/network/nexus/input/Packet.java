package org.instaware.network.nexus.input;

import org.instaware.core.society.model.players.Player;
import org.instaware.network.nexus.InBuffer;

/**
 * <p>A nexus between raw and formatted data.</p>
 * 
 * <p>Each <tt>Packet</tt> encapsulates a payload
 * of raw data which a developer can read to form
 * data which has been formatted to a specific
 * <a href=http://download.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html>DataType</a>.</p>
 * 
 * <p>A <tt>Packet</tt> also holds within a player
 * whom the signal to process was sent from.</p>
 * 
 * @see {@link InBuffer}
 * @see <a href=http://en.wikipedia.org/wiki/Network_packet>Network packet</a>
 * @author Thomas Nappo
 */
public class Packet extends InBuffer {

	/**
	 * Constructs a new <tt>Packet</tt>.
	 * @param player The sender of the packet.
	 * @param opCode The <a href=http://en.wikipedia.org/wiki/Opcode>operation code</a> of the data buffer.
	 * @param payload Control information data which is contained.
	 * @param bare Whether or not this buffer contains the standard header.
	 * @param type The type-size of the <tt>Packet</tt>.
	 */
	public Packet(Player player, int opCode, byte[] payload, boolean bare, Type type) {
		super(opCode, payload, bare, type);
		this.player = player;
	}
	
	/**
	 * Constructs a new <tt>Packet</tt>.
	 * @param player The sender of the packet.
	 * @param opCode The <a href=http://en.wikipedia.org/wiki/Opcode>operation code</a> of the data buffer.
	 * @param payload Control information data which is contained.
	 * @param bare Whether or not this buffer contains the standard header.
	 */
	public Packet(Player player, int opCode, byte[] payload, boolean bare) {
		this(player, opCode, payload, bare, Type.FIXED);
	}
	
	/**
	 * Constructs a new <tt>Packet</tt>.
	 * @param player The sender of the packet.
	 * @param opCode The <a href=http://en.wikipedia.org/wiki/Opcode>operation code</a> of the data buffer.
	 * @param payload Control information data which is contained.
	 * @param bare Whether or not this buffer contains the standard header.
	 */
	public Packet(Player player, int opCode, byte[] payload) {
		this(player, opCode, payload, false);
	}
	
	/**
	 * The sender of the packet.
	 */
	private Player player;
	
	/**
	 * Gets the sender of the packet.
	 * @return The sender of the packet.
	 */
	public Player getPlayer() {
		return player;
	}

}