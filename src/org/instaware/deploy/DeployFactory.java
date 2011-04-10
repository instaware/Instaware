package org.instaware.deploy;

import java.util.logging.Logger;

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
	 * Acquired deployment arguments.
	 */
	private String[] args = new String[1];
	
	/**
	 * Creates and launches new deployment.
	 * @param args The deployment arguments.
	 * @return The finished <tt>DeployFactory</tt>.
	 */
	public DeployFactory start(String[] args) {
		this.args = args;
		next();
		return this;
	}
	
	/**
	 * Processes the next action according to the state.
	 */
	public void next() {
		switch(state) {
		case STAND_BY:
			logger.info("Initializing deployment...");
			checkpoint(DeployState.CORE_INITIALIZATION);
			break;
		case CORE_INITIALIZATION:
			new Global();
			logger.info("Completed core initialization.");
			checkpoint(DeployState.NETWORK_INITIALIZATION);
			break;
		case NETWORK_INITIALIZATION:
			int port = 43594;
			if(args.length >= 1) if(args[0] != null) port = Integer.parseInt(args[0]);
			new Server().bind(port);
			logger.info("Completed network initialization.");
			checkpoint(DeployState.COMPLETED);
			break;
		case COMPLETED:
			//logger.info("Factory has completed deployment.");
			logger.info("The Enlightment Project is now ready.");
			return;
		default:
			checkpoint(DeployState.STAND_BY);
			break;
		}
		next();
	}

}