package org.instaware.core.service.extensions;

import org.instaware.core.Global;
import org.instaware.core.service.GameLogic;
import org.instaware.core.society.model.Entity;

/**
 * <p>Appends updating for world {@link Entity}s.</p>
 * 
 * <p>This {@link GameLogic} is completed every 
 * <a href=http://runescape.wikia.com/wiki/RuneScape_clock>game cycle</a> for
 * all active <tt>Entity</tt>s of the world.</p>
 * 
 * @author Thomas Nappo
 */
public class UpdateLogic extends GameLogic {

	@Override
	public void execute() {
		Global.getWorld().getPlayerUpdater().updateAll();
		Global.getWorld().getNpcUpdater().updateAll();
	}

}