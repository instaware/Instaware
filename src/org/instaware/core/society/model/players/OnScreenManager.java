package org.instaware.core.society.model.players;

import org.instaware.core.society.model.Mob;
import org.instaware.core.society.model.npcs.Npc;

/**
 * Manages other {@link Mob}'s on a {@link Player}'s screen.
 * @author Thomas Nappo
 */
public class OnScreenManager {
	
	/**
	 * Encapsulated players on screen.
	 */
	private Player[] players = new Player[255];
	
	public Player[] getPlayers() {
		return players;
	}
	
	public void set(Player[] p) {
		players = p;
	}
	
	public void put(int index, Player player) {
		players[index] = player;
	}
	
	private int pSize = 0;
	
	public int getSizeP() {
		return pSize;
	}
	
	public void resetPSize() {
		pSize = 0;
	}
	
	public void pIncrease() {
		pSize++;
	}
	
	/**
	 * Encapsulated npcs on screen.
	 */
	private Npc[] npcs = new Npc[255];
	
	public Npc[] getNpcs() {
		return npcs;
	}
	
	public void set(Npc[] n) {
		npcs = n;
	}
	
	public void put(int index, Npc npc) {
		npcs[index] = npc;
	}
	
	private int nSize = 0;
	
	public int getSizeN() {
		return nSize;
	}
	
	public void resetNSize() {
		nSize = 0;
	}
	
	public void nIncrease() {
		nSize++;
	}

}