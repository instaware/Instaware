package org.instaware.deploy;

/**
 * State of a deployment factory.
 * @author Thomas Nappo
 */
public enum DeployState {
	
	/**
	 * State in which the deployment factory
	 * attains no state and is waiting or inactive.
	 */
	STAND_BY,
	
	/**
	 * State in which the factory is deploying
	 * network infrastructure and related networking units.
	 */
	NETWORK_INITIALIZATION,
	
	/**
	 * State in which the factory is deploying
	 * core infrastructure and related core units.
	 */
	CORE_INITIALIZATION,
	
	/**
	 * State in which the factory has finished deployment.
	 */
	COMPLETED;

}