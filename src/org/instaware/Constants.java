package org.instaware;

public final class Constants {
	
	/**
	 * Lengths which match operation code.
	 */
	public static final int[] PACKET_LENGTHS = {
	   //0---1---2---3---4---5---6---7---8---9
		-3,	-3,	-3,	-3,	04,	-3,	-3,	00,	-3,	-3,	// 0   9
		-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	// 1   18
		00,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	// 2   27
		-3,	-3,	-3,	-3,	-3,	-3,	00,	-3,	-3,	-3,	// 3   36
		-3,	-3,	-3,	-3,	-3,	-3,	8,	-3,	-3, -3,	// 4   45
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
		-3,	-3,	-3,	-3,	-3,	-3,	8,	-3,	-3,	-3,	// 22  207
		04,	-3,	-3,	-3,	-3,	02,	-3,	-3,	-3,	-3,	// 23  216
		-3,	-3,	04,	-3,	-3,	-3,	-3,	-3,	-3,	-3,	// 24  225
		-3,	8,	-3,	-3,	-3, -3, -3, -3, -3,
		-3,	-3,	-3,	-3,	-3, -3, -3, -3, -3
	};
	
	/**
	 * Keys sent to notify the client we are in the update state.
	 */
	public static final int[] UPDATE_KEYS = {
		0xff, 0x00, 0xff, 0x00, 0x00, 0x00, 0x00, 0x80, 0xca, 0x55, 0xa6, 0x13, 0x00, 0x00, 0x00, 0x00,
		0xfa, 0xc8, 0x8e, 0xfb, 0x00, 0x00, 0x00, 0x00, 0x49, 0x64, 0x82, 0x37, 0x00, 0x00, 0x00, 0x00,
		0x53, 0x4d, 0x7c, 0x27, 0x00, 0x00, 0x00, 0x00, 0xa6, 0xfc, 0xcc, 0x2b, 0x00, 0x00, 0x00, 0x00,
		0x23, 0xd5, 0x3a, 0x55, 0x00, 0x00, 0x00, 0x00, 0xa2, 0xc4, 0x23, 0x06, 0x00, 0x00, 0x00, 0x00,
		0xef, 0x3f, 0xef, 0x2a, 0x00, 0x00, 0x00, 0x00, 0xe0, 0x88, 0x71, 0x7c, 0x00, 0x00, 0x00, 0x00,
		0xec, 0x28, 0x71, 0x7c, 0x00, 0x00, 0x00, 0x00, 0x14, 0x8f, 0x6f, 0x5e, 0x00, 0x00, 0x00, 0x00,
		0x74, 0x14, 0x8a, 0x05, 0x00, 0x00, 0x00, 0x00, 0x6e, 0x66, 0xfa, 0x6e, 0x00, 0x00, 0x00, 0x00,
		0x07, 0x8e, 0x6a, 0x3e, 0x00, 0x00, 0x00, 0x00, 0xa3, 0x8c, 0xf6, 0x94, 0x00, 0x00, 0x00, 0x00,
		0xb8, 0xf2, 0x4d, 0x21, 0x00, 0x00, 0x00, 0x00
	};

}