package org.instaware.network.nexus;

/**
 * Provides interfacing for a network buffer.
 * @author Thomas Nappo
 */
public abstract class Buffer {
	
	/**
	 * The <a href=http://en.wikipedia.org/wiki/Opcode>operation code</a> of the data buffer.
	 */
	protected int opCode = -1;
	
	/**
	 * Retrieves the <a href=http://en.wikipedia.org/wiki/Opcode>operation code</a> of the data buffer.
	 * @return The operation code of the data buffer.
	 */
	public int getOpCode() {
		return opCode;
	}
	
	/**
	 * Current read index of the {@link #payload}.
	 */
	protected int caret;
	
	/**
	 * Retrieves the current read index of the {@link #payload}
	 * @return The current read index of the {@link #payload}.
	 */
	public int getCaret() {
		return caret;
	}
	
	/**
	 * Whether or not this buffer contains the standard header.
	 */
	protected boolean bare;
	
	/**
	 * Retrieves whether or not this buffer is without the standard header.
	 * @return <tt>true</tt> if the buffer is bare, <tt>false</tt> otherwise.
	 */
	public boolean isBare() {
		return bare;
	}
	
	/**
	 * The type of the <tt>Buffer</tt>.
	 */
	protected Type type;
	
	/**
	 * Retrieves the type of the <tt>Buffer</tt>.
	 * @return The type of the <tt>Buffer</tt>.
	 */
	public Type gettype() {
		return type;
	}
	
	/**
	 * The type of a <tt>Buffer</tt>.
	 * @author Thomas Nappo
	 */
	public static enum Type {
		
		/**
		 * Represents a fixed type.
		 */
		FIXED,
		
		/**
		 * Represents a varying byte type.
		 */
		VAR_BYTE,
		
		/**
		 * Represents a varying short type.
		 */
		VAR_SHORT;
	}
	
	/**
	 * Constructs a new <tt>Buffer</tt>.
	 * @param opCode The <a href=http://en.wikipedia.org/wiki/Opcode>operation code</a> of the data buffer.
	 * @param payload Control information data which is contained.
	 * @param bare Whether or not this buffer contains the standard header.
	 * @param type The type-size of the <tt>Buffer</tt>.
	 */
	public Buffer(int opCode, byte[] payload, boolean bare, Type type) {
		this.opCode = opCode; this.payload = payload;
		this.bare = bare; this.type = type;
	}
	
	/**
	 * Constructs a new <tt>Buffer</tt>.
	 * @param opCode The <a href=http://en.wikipedia.org/wiki/Opcode>operation code</a> of the data buffer.
	 * @param payload Control information data which is contained.
	 * @param bare Whether or not this buffer contains the standard header.
	 */
	public Buffer(int opCode, byte[] payload, boolean bare) {
		this(opCode, payload, bare, Type.FIXED);
	}
	
	/**
	 * Constructs a new <tt>Buffer</tt>.
	 * @param opCode The <a href=http://en.wikipedia.org/wiki/Opcode>operation code</a> of the data buffer.
	 * @param payload Control information data which is contained.
	 * @param bare Whether or not this buffer contains the standard header.
	 */
	public Buffer(int opCode, byte[] payload) {
		this(opCode, payload, false);
	}
	
	/**
	 * Control information which this <tt>Buffer</tt> contains.
	 */
	protected byte[] payload;
	
	/**
	 * Retrieves the <tt>Buffer</tt>'s containing data.
	 * @return The <tt>Buffer</tt>'s containing data.
	 */
	public byte[] getPayload() {
		return payload;
	}

}