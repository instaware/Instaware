package org.instaware.core;

import org.instaware.core.service.Worker;

/**
 * Encapsulates global (environment) attributes.
 * @author Thomas Nappo
 */
public final class Global {
	
	/**
	 * Performs logic working for the environment.
	 */
	private static Worker worker = new Worker();
	
	/**
	 * Gets the global logic worker.
	 * @return The global logic worker.
	 */
	public static Worker getWorker() {
		return worker;
	}

}