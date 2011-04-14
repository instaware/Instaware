package org.instaware.core.society.model;

import org.instaware.core.Global;
import org.instaware.core.service.extensions.*;
import org.instaware.core.society.model.npcs.*;
import org.instaware.core.society.model.players.*;
import org.instaware.core.society.update.extensions.*;

/**
 * Represents the game world.
 * @author Thomas Nappo
 */
public class World {
	
	/**
	 * Constructs a new world.
	 */
	public World() {
		registerGameLogic();
	}
	
	/**
	 * Registers default game logic pieces.
	 */
	public void registerGameLogic() {
		Global.getWorker().schedule(new UpdateLogic());
	}

	/**
	 * {@link Player} units of the world.
	 */
	private final EntityList<Player> players = new EntityList<Player>();
	
	/**
	 * Retrieves the world's list of {@link Player}s.
	 * @return An {@link EntityList} object, which encapsulates
	 * and manages all of the world's players.
	 */
	public EntityList<Player> getPlayers() {
		return players;
	}
	
	/**
	 * Attempts to register a {@link Player} to the world.
	 * @param player The player to register.
	 * @return <tt>true</tt> if the player was registered successfully.
	 */
	public boolean register(Player player) {
		players.update();
		if (players.add(player)) {
			player.index = players.indexOf(player);
			return true;
		}
		return false;
	}
	
	/**
	 * Attempts to unregister a {@link Player} from the world.
	 * @param player The player to unregister.
	 * @return <tt>true</tt> if the player was unregistered successfully.
	 */
	public boolean unregister(Player player) {
		if (players.remove(player)) {
			players.update();
			return true;
		}
		return false;
	}
	
	/**
	 * {@link Npc} units of the world.
	 */
	private final EntityList<Npc> npcs = new EntityList<Npc>();
	
	/**
	 * Retrieves the world's list of {@link Npc}s.
	 * @return An {@link EntityList} object, which encapsulates
	 * and manages all of the world's npcs.
	 */
	public EntityList<Npc> getNpcs() {
		return npcs;
	}
	
	/**
	 * Attempts to register an {@link Npc} to the world.
	 * @param npc The npc to register.
	 * @return <tt>true</tt> if the npc was registered successfully.
	 */
	public boolean register(Npc npc) {
		npcs.update();
		if (npcs.add(npc)) {
			npc.index = npcs.indexOf(npc);
			return true;
		}
		return false;
	}
	
	/**
	 * Attempts to unregister a {@link Npc} from the world.
	 * @param npc The npc to unregister.
	 * @return <tt>true</tt> if the npc was unregistered successfully.
	 */
	public boolean unregister(Npc npc) {
		if (npcs.remove(npc)) {
			npcs.update();
			return true;
		}
		return false;
	}
	
	/**
	 * Performs player updating.
	 */
	private final PlayerUpdater pUpdater = new PlayerUpdater();
	
	/**
	 * Retrieves this world's {@link PlayerUpdater}.
	 * @return This world's <tt>PlayerUpdater</tt>.
	 */
	public PlayerUpdater getPlayerUpdater() {
		return pUpdater;
	}
	
	/**
	 * Performs NPC updating.
	 */
	private final NpcUpdater nUpdater = new NpcUpdater();
	
	/**
	 * Retrieves this world's {@link NpcUpdater}.
	 * @return This world's <tt>NpcUpdater</tt>.
	 */
	public NpcUpdater getNpcUpdater() {
		return nUpdater;
	}
	
}