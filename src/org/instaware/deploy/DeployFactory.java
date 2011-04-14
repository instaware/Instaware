package org.instaware.deploy;

import java.util.logging.Logger;

import org.instaware.Constants;
import org.instaware.core.Global;
import org.instaware.network.Server;

/**
 * Initializes a new deployment.
 * @author Thomas Nappo
 */
public final class DeployFactory {
	
	/**
	 * The factory's logging instance.
	 */
	private final Logger logger = Logger.getLogger(DeployFactory.class.getName());
	
	/**
	 * The state of the factory.
	 */
	private DeployState state = DeployState.STAND_BY;
	
	/**
	 * Gets the state of the factory.
	 * @return The state of the factory.
	 */
	public DeployState getState() {
		return state;
	}
	
	/**
	 * Sets the acquired state of the factory.
	 * @param state The new state.
	 */
	private void checkpoint(DeployState state) {
		this.state = state;
	}
	
	/**
	 * Creates and launches new deployment.
	 * @return The finished <tt>DeployFactory</tt>.
	 */
	public DeployFactory start() {
		next();
		return this;
	}
	
	/**
	 * Processes the next action according to the state.
	 */
	public void next() {
		switch (state) {
		case STAND_BY:
			logger.info("Initializing deployment...");
			checkpoint(DeployState.CORE_INITIALIZATION);
			break;
		case CORE_INITIALIZATION:
			new Global();
			Global.loadProperties();
			logger.info("Completed core initialization.");
			checkpoint(DeployState.NETWORK_INITIALIZATION);
			break;
		case NETWORK_INITIALIZATION:
			Constants.repPacketLengths();
			new Server().bind(Global.getProperties().getIntProperty("port"));
			logger.info("Completed network initialization.");
			checkpoint(DeployState.COMPLETED);
			break;
		case COMPLETED:
			logger.info("Factory has completed deployment.");
			return;
		default:
			checkpoint(DeployState.STAND_BY);
			break;
		}
		next();
	}

}