package org.instaware.core.society.model.npcs;

import org.instaware.core.society.model.Mob;

/**
 * A non-player character.
 * @see {@link Mob}
 * @author Thomas Nappo
 */
public class Npc extends Mob {

	/**
	 * Constructs a new NPC.
	 * @param index The index identification.
	 */
	public Npc(int index) {
		super(index);
	}

	@Override
	public int getFormattedIndex() {
		return index;
	}

}