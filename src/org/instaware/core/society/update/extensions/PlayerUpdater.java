package org.instaware.core.society.update.extensions;

import org.instaware.core.Global;
import org.instaware.core.society.model.players.*;
import org.instaware.core.society.update.Updater;

/**
 * Performs updating for {@link Player}.
 * 
 * @see {@link Updater}
 * @author Thomas Nappo
 */
public class PlayerUpdater extends Updater<Player> {

	@Override
	public void updateAll() {
		for (Player p : Global.getWorld().getPlayers()) {
			if (!p.isConnected()) {
				Global.getWorld().unregister(p);
				continue;
			}
			update(p);
		}
	}

	@Override
	public void update(Player p) {
		System.out.println("Updated player: " + p);
	}

}