package org.instaware.core.society.update.extensions;

import org.instaware.core.Global;
import org.instaware.core.society.model.players.*;
import org.instaware.core.society.update.UpdateFlags.UpdateFlag;
import org.instaware.core.society.update.Updater;
import org.instaware.network.nexus.Buffer.Type;
import org.instaware.network.nexus.*;

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
		if (p.getUpdateFlags().get(UpdateFlag.MAP_REGION_CHANGED)) 
			p.getPacketSender().sendMapRegion();
		
		OutBuffer main = new OutBuffer().setOpCode(173).setType(Type.VAR_SHORT).initBitAccess();
		OutBuffer update = new OutBuffer().setBare(true);
		
		if (p.getUpdateFlags().isUpdateRequired())
			;// TODO: appendUpdateBlock
		
		int size = p.getOSManager().getSizeP();
		
		main.addBits(8, size);
		p.getOSManager().resetPSize();
		
		boolean[] nPlayer = new boolean[2000]; // World's capacity.
		
		for (int i = 0; i < size; i++) {
			
			// Create our array of players, which may be modified.
			// The player's original player build will be overridden by this.
			Player[] pBuild = p.getOSManager().getPlayers();
			
			final Player next = pBuild[i];
			if (next == null | !next.isConnected() | next.getUpdateFlags().get(UpdateFlag.TELEPORT) /* TODO: Distance from player */) {
				main.addBits(1, 1); main.addBits(2, 3);
			} else {
				// TODO: Update other's movement.
				pBuild[p.getOSManager().getSizeP()] = next;
				p.getOSManager().pIncrease();
			}
			
			p.getOSManager().set(pBuild);
			
		}
		
		for (Player oPlayer : p.getOSManager().getPlayers()) {
			if (oPlayer == null /* TODO: Check if their index=real player */) continue;
			
			// TODO: Check distance from oPlayer.
			
			// TODO: newPlayer
			
			// TODO: addNewPlayer
		}
		
	}

}