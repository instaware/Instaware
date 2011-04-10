package org.instaware;

import org.instaware.deploy.DeployFactory;

/**
 * Loads the project.
 * @author Thomas Nappo
 */
public final class Loader {
	
	/**
	 * First executed method of the program.
	 * @param args The program arguments.
	 */
	public static void main(String[] args) {
		new DeployFactory().start(args);
	}

}