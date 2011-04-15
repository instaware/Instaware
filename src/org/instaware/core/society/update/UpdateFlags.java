package org.instaware.core.society.update;

import java.util.BitSet;

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
	/**
	 * Represents an update flag.
	 * @author Thomas Nappo
	 */
	public static enum UpdateFlag {
		
		/**
		 * Update flag to append an animation update.
		 */
		ANIMATION,
		
		/**
		 * Update flag to append an appearance update.
		 * 
		 * Differences such as clothing and ect. are changed when
		 * this key is flagged.
		 */
		APPEARANCE,
		
		/**
		 * Update flag to append a chat update.
		 * 
		 * Public chat updating, which appends the queued chat text will
		 * appear for the global world.
		 */
		CHAT,
		
		/**
		 * Update flag to append a forced chat update.
		 */
		FORCE_CHAT,
		
		/**
		 * Update flag to append a entity face update.
		 * 
		 * Face entity updating, which will turn the entity constantly
		 * towards another.
		 */
		FACE_ENTITY,
		
		/**
		 * Update flag to append a coordinate face update.
		 * 
		 * Face point updating, which will turn the entity towards
		 * a coordinate point [once].
		 */
		FACE_COORDINATE,
		
		/**
		 * Update flag to append a graphic update.
		 */
		GRAPHIC,
		
		/**
		 * Update flag to append 1st hit update.
		 */
		HIT,
		
		/**
		 * Update flag to append 2nd hit update.
		 */
		HIT_2,
		
		/**
		 * Non-character entity transformation update.
		 */
		TRANSFORM,
		
		/**
		 * Update flag to notify the map region changed.
		 * 
		 * When this update is finished, it resends the map region.
		 */
		MAP_REGION_CHANGED,
		
		/**
		 * Update flag to notify teleportation.
		 */
		TELEPORT;
		
	}
	
	/**
	 * Set of appending update flags.
	 */
	private BitSet flags = new BitSet();
	
	/**
	 * Checks whether or not an update is required.
	 * @return <tt>true</tt> if an update is required, <tt>false</tt> otherwise.
	 */
	public boolean isUpdateRequired() {
		return !flags.isEmpty();
	}
	
	/**
	 * Queries whether or not the managed {@link Entity} has acquired
	 * a certain {@link UpdateFlag}.
	 * @param flag The <tt>UpdateFlag</tt> to retrieve information for.
	 * @return <b>true</b> if the flag is active
	 * </br><b>false</b> if the flag is not active
	 */
	public boolean get(UpdateFlag flag) {
		return flags.get(flag.ordinal());
	}
	
	/**
	 * Flags an update flag.
	 * @param flag The {@link UpdateFlag} to append.
	 */
	public void flag(UpdateFlag flag) {
		flags.set(flag.ordinal(), true);
	}
	
	/**
	 * Unflags an update flag.
	 * @param flag The {@link UpdateFlag} to depend.
	 */
	public void unflag(UpdateFlag flag) {
		flags.set(flag.ordinal(), false);
	}

}