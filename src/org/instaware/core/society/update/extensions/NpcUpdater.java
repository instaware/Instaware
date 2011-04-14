package org.instaware.core.society.update.extensions;

import org.instaware.core.Global;
import org.instaware.core.society.model.npcs.*;
import org.instaware.core.society.update.Updater;

/**
 * Performs updating for {@link Npc}.
 * 
 * @see {@link Updater}
 * @author Thomas Nappo
 */
public class NpcUpdater extends Updater<Npc> {

	@Override
	public void updateAll() {
		for (Npc n : Global.getWorld().getNpcs()) update(n);
	}

	@Override
	public void update(Npc n) {
		// TODO Auto-generated method stub
		
	}

}