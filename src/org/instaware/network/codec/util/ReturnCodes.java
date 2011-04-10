package org.instaware.network.codec.util;

/**
 * Holds data of return code values.
 * @author Thomas Nappo
 */
public final class ReturnCodes {
	
	/**
	 * Return code indicating you're waiting for video advertisements.
	 */
	public static final int VIDEO_ADVERTS = 1;
	
	/**
	 * Return code indicating you passed and are logging in.
	 */
	public static final int LOGIN = 2;
	
	/**
	 * Return code indicating you entered the wrong account details.
	 */
	public static final int INVALID_DETAILS = 3;
	
	/**
	 * Return code indicating your account is disabled.
	 */
	public static final int BANNED = 4;
	
	/**
	 * Return code indicating your account is already logged in.
	 */
	public static final int ALREADY_LOGGED_IN = 5;
	
	/**
	 * Return code indicating that your client is outdated.
	 */
	public static final int OUTDATED_CLIENT = 6;
	
	/**
	 * Return code indicating that the world is full.
	 */
	public static final int WORLD_FULL = 7;
	
	/**
	 * Return code indicating that the login server is offline.
	 */
	public static final int LOGIN_SERVER_DOWN = 8;
	
	/**
	 * Return code indicating you already have another account from the same IP that is logged onto this world.
	 */
	public static final int LOGIN_LIMIT_MAXED = 9;
	
	/**
	 * Return code indicating that your session could not be created.
	 */
	public static final int INVALID_SESSION = 10;
	
	/**
	 * Return code indicating that we suspect somebody has hacked your account.
	 */
	public static final int SUSPICION = 11;
	
	/**
	 * Return code indicating that you are a non-member that tried to login onto a members world.
	 */
	public static final int WORLD_MEMBERS_ONLY = 12;
	
	/**
	 * Return code indicating that your login request was incomplete.
	 */
	public static final int INCOMPLETE_LOGIN = 13;
	
	/**
	 * Return code indicating that the world currently has an update appending.
	 */
	public static final int UPDATE_IN_PROGRESS = 14;
	
	/**
	 * Return code indicating that you have logged in too many times with incorrect details.
	 */
	public static final int MANY_INCORRECT_LOGINS = 16;
	
	/**
	 * Return code indicating that you are trying to log into a f2p world while in a member's area.
	 */
	public static final int PLACE_MEMBERS_ONLY = 17;
	
	/**
	 * Return code indicating that your account is locked for various reasons.
	 */
	public static final int LOCKED = 18;
	
	/**
	 * Return code indicating that fullscreen is for members only and you are f2p.
	 */
	public static final int FULLSCREEN_MEMBERS_ONLY = 19;
	
	/**
	 * Return code indicating that the login server you attempted to connect to is invalid.
	 */
	public static final int INVALID_LOGIN_SERVER = 20;
	
	/**
	 * Return code indicating that you have just left a world and you are transfering.
	 */
	public static final int JUST_LEFT_WORLD = 21;
	
	/**
	 * Return code indicating that you sent a malformed packet on login request.
	 */
	public static final int MALFORMED_PACKET = 22;
	
	/**
	 * Return code indicating there was no login server reply.
	 */
	public static final int NO_LOGIN_SERVER_REPLY = 23;
	
	/**
	 * Return code indicating that your character file is corrupted.
	 */
	public static final int CHAR_FILE_CURRUPTED = 24;
	
	/**
	 * Return code indicating that your IP address is banned from the server for high offenses.
	 */
	public static final int IP_BANNED = 26;
	
	/**
	 * Return code indicating any non-specific error.
	 */
	public static final int ERROR = 27;
	
}