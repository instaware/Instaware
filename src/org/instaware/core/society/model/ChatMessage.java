package org.instaware.core.society.model;

/**
 * A game chat message.
 * @author Thomas Nappo
 */
public class ChatMessage {
	
	/**
	 * Literal text makeup of the message.
	 */
	private String text;
	
	/**
	 * Retrieves the literal text makeup of the message.
	 * @return {@link #text}
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * The message's applied effects.
	 */
	private int effects;
	
	/**
	 * Retrieves the message's applied effects.
	 * @return {@link #effects}
	 */
	public int getEffects() {
		return effects;
	}
	
	/**
	 * Constructs a new {@link ChatMessage}.
	 * @param text The literal text makeup of the message.
	 * @param effects The message's applied effects.
	 */
	public ChatMessage(String text, int effects) {
		this.text = text; this.effects = effects;
	}

}