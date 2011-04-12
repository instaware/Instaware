package org.instaware.core.society.update;

import org.instaware.core.society.model.Entity;

/**
 * Manages {@link UpdateFlag}s for an {@link Entity}.
 * @author Thomas Nappo
 */
public class UpdateFlags {
	
	/**
	 * A flag in which, when flagged appends
	 * an update towards an {@link Entity}.
	 * @author Thomas Nappo
	 */
	public static enum UpdateFlag {
		
	}
	
	/**
	 * Queries whether or not the managed {@link Entity} has acquired
	 * a certain {@link UpdateFlag}.
	 * @param flag The <tt>UpdateFlag</tt> to retrieve information for.
	 * @return <b>true</b> if the flag is active
	 * </br><b>false</b> if the flag is not active
	 */
	public boolean get(UpdateFlag flag) {
		// TODO: Create some system which can retrieve whether or not
		// an update is appending.
		return false;
	}

}