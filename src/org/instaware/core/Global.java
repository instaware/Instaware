package org.instaware.core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import org.instaware.core.service.GameWorker;

/**
 * Encapsulates global (environment) attributes.
 * @author Thomas Nappo
 */
public final class Global {
	
	/**
	 * Used to display data.
	 */
	private static final Logger logger = Logger.getLogger(Global.class.getName());
	
	/**
	 * Performs logic working for the environment.
	 */
	private static GameWorker worker = new GameWorker();
	
	/**
	 * Gets the global logic worker.
	 * @return The global logic worker.
	 */
	public static GameWorker getWorker() {
		return worker;
	}
	
	/**
	 * Extension of {@link java.util.Properties} to allow
	 * easier use.
	 * @see {@link java.util.Properties}
	 * @author Thomas Nappo
	 */
	@SuppressWarnings("serial")
	public static class Properties extends java.util.Properties {
		
	    /**
	     * Retrieves an {@link Integer} property for it's
	     * associated key.
	     * @param key The property key.
	     * @see {@link #getProperty(String)}
	     */
		public int getIntProperty(String key) {
			return Integer.parseInt(getProperty(key));
		}
		
	}
	
	/**
	 * Global properties of the environment.
	 */
	private static Properties properties = new Properties();
	
	/**
	 * Retrieves properties of the environment.
	 * @return The global environment properties.
	 */
	public static Properties getProperties() {
		return properties;
	}
	
	/**
	 * Applys global properties.
	 */
	public static void loadProperties() {
		try {
			properties.load(new FileReader("server.properties"));
		} catch (FileNotFoundException e) {
			logger.severe("Could not find properties file: server.properties");
		} catch (IOException e) {
			logger.severe(e.getMessage());
		}
	}

}