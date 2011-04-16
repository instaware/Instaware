package org.instaware.core.society.update;

import org.instaware.core.society.model.*;

/**
 * Enlists {@link UpdateFlag}-fullfilling attributes.
 * @author Thomas Nappo
 */
public class UpdateAttributes {
	
	private Animation animation;
	
	public Animation getAnimation() {
		return animation;
	}
	
	private Graphic graphic;
	
	public Graphic getGraphic() {
		return graphic;
	}
	
	private ChatMessage message;
	
	public ChatMessage getMessage() {
		return message;
	}
	
	private ChatMessage forceMessage;
	
	public ChatMessage getForceMessage() {
		return forceMessage;
	}

}