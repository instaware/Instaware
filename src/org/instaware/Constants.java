package org.instaware;

import org.instaware.core.Global;

public final class Constants {
	
	/**
	 * The <a href=http://runescape.com>RuneScape</a> revision of the server.
	 */
	public static final int REVISION = Global.getProperties().getIntProperty("revision");
	
	/**
	 * Lengths which match operation code.
	 */
	public static int[] PACKET_LENGTHS = null;
	
	/**
	 * Replaces incoming packet lengths.
	 * @author 'Mystic flow <Steven@rune-server.org>
	 */
	public static void repPacketLengths() {
		PACKET_LENGTHS =  new int[] {
				//0---1---2---3---4---5---6---7---8---9
				-3,	-3,	-3,	-3,	04,	-3,	-3,	00,	-3,	-3,	// 0   9
				-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	// 1   18
				00,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	// 2   27
				-3,	-3,	-3,	-3,	-3,	-3,	00,	-3,	-3,	-3,	// 3   36
				-3,	-3,	-3,	-3,	-3,	-3,	 8,	-3,	-3, -3,	// 4   45
				-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	// 5   54
				-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	// 6   63
				-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	// 7   72
				-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	// 8   81
				-3,	-3,	-3,	-3,	-3,	-3,	-1,	-3,	-3,	-3,	// 9   90
				-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	// 10  99
				-3,	-3, -3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	// 11  108
				-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	// 12  117
				-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	// 13  126
				-3,	-3,	-3,	01,	-3,	-3,	-1,	-3,	-3,	-3,	// 14  135
				-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	// 15  144
				-3,	-3,	-3,	-3,	-1,	-3,	-3,	-3,	-3,	-3,	// 16  153
				-3,	-3,	-3,	-3,	-3,	-1,	-3,	-3,	-1,	-3,	// 17  162
				-3,	06,	-3,	-3,	-3,	-3,	04,	-3,	-3,	-3,	// 18  171
				-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	// 19  180
				-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	// 20  189
				-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-1,	-3,	// 21  198
				-3,	-3,	-3,	-3,	-3,	-3,	 8,	-3,	-3,	-3,	// 22  207
				04,	-3,	-3,	-3,	-3,	02,	-3,	-3,	-3,	-3,	// 23  216
				-3,	-3,	04,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	// 24  225
				-3,	 8,	-3,	-3,	-3, -3, -3, -3, -3,
				-3,	-3,	-3,	-3,	-3, -3, -3, -3, -3};
		PACKET_LENGTHS[87] = 2;
		PACKET_LENGTHS[176] = 8;
		PACKET_LENGTHS[116] = 8;
		PACKET_LENGTHS[204] = 8;
		PACKET_LENGTHS[19] = 2;//
		PACKET_LENGTHS[155] = 8;
		PACKET_LENGTHS[169] = 8;
		PACKET_LENGTHS[173] = 8;
		PACKET_LENGTHS[171] = 4;
		PACKET_LENGTHS[123] = 2;
		PACKET_LENGTHS[24] = 5;
		PACKET_LENGTHS[121] = 2;
		PACKET_LENGTHS[88] = 12;
		PACKET_LENGTHS[191] = 6;
		PACKET_LENGTHS[61] = 16;
		PACKET_LENGTHS[2] = 2;
		PACKET_LENGTHS[12] = 2;
		PACKET_LENGTHS[180] = 6;
		PACKET_LENGTHS[144] = 9;
		PACKET_LENGTHS[10] = 9;
		PACKET_LENGTHS[122] = 7;
		PACKET_LENGTHS[25] = 2;
		PACKET_LENGTHS[238] = 8;
		PACKET_LENGTHS[147] = 8;
		PACKET_LENGTHS[241] = 14;
		PACKET_LENGTHS[100] = 8;
		PACKET_LENGTHS[110] = 6;
		PACKET_LENGTHS[235] = 2;//Npc attack...
		PACKET_LENGTHS[150] = 8;//String option
		PACKET_LENGTHS[188] = 8;//Clan chat
		PACKET_LENGTHS[198] = 6;//Option - 5
		PACKET_LENGTHS[158] = 6;//Option - 10
		PACKET_LENGTHS[84] = 6;//Option - all
		PACKET_LENGTHS[203] = 6;//Option - x
		PACKET_LENGTHS[21] = 6;//Value
		PACKET_LENGTHS[234] = 6;//Lend
		PACKET_LENGTHS[22] = 6;//Examine packet
	}
	
	/**
	 * Keys sent to notify the client we are in the update state.
	 * @author Leanbow12
	 */
	public static final int[] UPDATE_KEYS = {
		-1, 0, -1, 0, 0, 0, 0, -128, -54, 85,
		-90, 19, 0, 0, 0, 41, -6, -56, -114, -5,
		0, 0, 0, 25, 73, 100, -126, 55, 0, 0, 2,
		3, 83, 77, 124, 39, 0, 0, 0, -58, -90, -4,
		-52, 43, 0, 0, 0, 51, 35, -43, 58, 85, 0, 0,
		0, -109, -94, -60, 35, 6, 0, 0, 0, 0, -17, 63,
		-17, 42, 0, 0, 0, -43, -32, -120, 113, 124, 0,
		0, 0, 48, -20, 40, 113, 124, 0, 0, 0, 41, 20, -113,
		111, 94, 0, 0, 0, 1, 116, 20, -118, 5, 0, 0, 0, 0, 110,
		102, -6, 110, 0, 0, 0, -121, 7, -114, 106, 62, 0, 0, 0, 1,
		-93, -116, -10, -108, 0, 0, 0, 1, -72, -14, 77, 33, 0, 0, 0, 0
	};

}