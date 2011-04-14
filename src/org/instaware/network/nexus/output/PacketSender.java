package org.instaware.network.nexus.output;

import org.instaware.core.Global;
import org.instaware.core.society.model.players.Player;
import org.instaware.network.nexus.OutBuffer;

/**
 * An {@link OutBuffer} that constructs game packets and sends them out toward clients.
 * 
 * @see {@link OutBuffer}
 * @author Thomas Nappo
 */
public class PacketSender extends OutBuffer {
	
	/**
	 * {@link Player} whom's client requests the packet.
	 */
	protected Player player;
	
	/**
	 * Constructs a new <tt>PacketSender</tt>.
	 * @param player The {@link Player} 
	 */
	public PacketSender(Player player) {
		this.player = player;
	}
	
	/**
	 * Converts the {@link #player} from the login screen
	 * to the game interface.
	 */
	public void sendLogin() {
		sendMapRegion();
		sendWindowPane(548);
		sendTabs();
		sendMessage("Welcome to " + Global.getProperties().getProperty("game_name"));
	}
	
	/**
	 * Sends the player's map region.
	 */
	public void sendMapRegion() {
		// Send map region changed update flag here.

		OutBuffer buffer = new OutBuffer().setOpCode(31).setType(Type.VAR_SHORT);
		buffer.addLEShortA(player.getLocation().getRegionY());
		boolean forceSend = true;
		if ((((player.getLocation().getRegionX() / 8) == 48) || ((player.getLocation().getRegionX() / 8) == 49)) && ((player.getLocation().getRegionY() / 8) == 48))
			forceSend = false;
		if (((player.getLocation().getRegionX() / 8) == 48) && ((player.getLocation().getRegionY() / 8) == 148))
			forceSend = false;
		for (int xCalc = (player.getLocation().getRegionX() - 6) / 8; xCalc <= ((player.getLocation().getRegionX() + 6) / 8); xCalc++)
			for (int yCalc = (player.getLocation().getRegionY() - 6) / 8; yCalc <= ((player.getLocation().getRegionY() + 6) / 8); yCalc++)
				if (forceSend || ((yCalc != 49) && (yCalc != 149) && (yCalc != 147) && (xCalc != 50) && ((xCalc != 49) || (yCalc != 47))))
					for (byte b = 0; b < 4; b++) buffer.addInt(0);
		buffer.addLEShortA(player.getLocation().getRegionX());
		buffer.addByteC((byte) player.getLocation().getZ());
		buffer.addShort(player.getLocation().getLocalX());
		buffer.addLEShortA(player.getLocation().getLocalY());
		
		player.getChannel().write(buffer.asInput());
	}
	
	/**
	 * Sends a window pane.
	 * @param pane The window pane identification number.
	 */
	public void sendWindowPane(int pane) {
		OutBuffer buffer = new OutBuffer().setOpCode(207);
		buffer.addLEShortA(pane);
		player.getChannel().write(buffer.asInput());
	}
	
	/**
	 * Sends the player's default tabs.
	 */
	public void sendTabs() {
		sendTab(137, 121); // Chatbox
		sendTab(92, 128); // Attack
		sendTab(320, 129); // Levels
		sendTab(274, 130); // Quest
		sendTab(149, 131); // Inventory
		sendTab(387, 132); // Equipment
		sendTab(271, 133); // Prayer
		sendTab(192, 134); // Magic
		sendTab(662, 135); // Summoning
		sendTab(550, 136); // Friends
		sendTab(551, 137); // Ignore
		sendTab(589, 138); // Clan chat
		sendTab(261, 139); // Options
		sendTab(464, 140); // Emotes
		sendTab(239, 141); // Music
		sendTab(182, 142); // Music
	}
	
	/**
	 * Sends a game frame tab.
	 * @param tabId The tab's id.
	 * @param childId The interface to show in that tab.
	 */
	public void sendTab(int tabId, int childId) {
    	sendInterface(1, 548, tabId, childId);
    }
	
	/**
	 * Sends an interface.
	 */
	public void sendInterface(int showId, int windowId, int interfaceId, int childId) {
		OutBuffer buffer = new OutBuffer().setOpCode(0)
		.addLEShort(interfaceId)
		.addLEInt(windowId << 16 | childId)
		.addByteA(showId);
		player.getChannel().write(buffer.asInput());
	}
	
	/**
	 * Sends a message towards the {@link #player}.
	 * @param message The message {@link String} literal to send.
	 */
	public void sendMessage(String message) {
		OutBuffer buffer = new OutBuffer().setOpCode(27).setType(Type.VAR_BYTE).addString(message);
		player.getChannel().write(buffer.asInput());
	}

}