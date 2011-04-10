package org.instaware.core.service;

/**
 * An encapsulation of logic which is proprieted by
 * a {@link GameWorker}.
 * @author Graham Edgecombe
 * @author Thomas Nappo
 */
public abstract class GameLogic {
	
	/**
	 * The number of cycles between consecutive executions of this logic.
	 */
	private final int delay;

	/**
	 * A flag which indicates if this logic should be executed once immediately.
	 */
	private final boolean immediate;

	/**
	 * The current 'count down' value. When this reaches zero the logic will be
	 * executed.
	 */
	private int countdown;

	/**
	 * A flag which indicates if this logic is still running.
	 */
	private boolean running = true;

	/**
	 * Creates a new logic with a delay of 1 cycle.
	 */
	public GameLogic() {
		this(1);
	}

	/**
	 * Creates a new logic with a delay of 1 cycle and immediate flag.
	 * @param immediate A flag that indicates if for the first execution there
	 * should be no delay.
	 */
	public GameLogic(boolean immediate) {
		this(1, immediate);
	}

	/**
	 * Creates a new logic with the specified delay.
	 * @param delay The number of cycles between consecutive executions of this
	 * logic.
	 * @throws IllegalArgumentException if the {@code delay} is not positive.
	 */
	public GameLogic(int delay) {
		this(delay, false);
	}

	/**
	 * Creates a new logic with the specified delay and immediate flag.
	 * @param delay The number of cycles between consecutive executions of this
	 * logic.
	 * @param immediate A flag which indicates if for the first execution there
	 * should be no delay. 
	 * @throws IllegalArgumentException if the {@code delay} is not positive.
	 */
	public GameLogic(int delay, boolean immediate) {
		checkDelay(delay);
		this.delay = delay;
		this.countdown = delay;
		this.immediate = immediate;
	}

	/**
	 * Checks if this logic is an immediate logic.
	 * @return {@code true} if so, {@code false} if not.
	 */
	public boolean isImmediate() {
		return immediate;
	}

	/**
	 * Checks if the logic is running.
	 * @return {@code true} if so, {@code false} if not.
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * Checks if the logic is stopped.
	 * @return {@code true} if so, {@code false} if not.
	 */
	public boolean isStopped() {
		return !running;
	}
	
	/**
	 * This method should be called by the scheduling class every cycle. It
	 * updates the {@link #countdown} and calls the {@link #execute()} method
	 * if necessary.
	 * @return A flag indicating if the task is running.
	 */
	public boolean cycle() {
		if (running && --countdown == 0) {
			execute();
			countdown = delay;
		}
		return running;
	}
	
	/**
	 * Performs desired logic.
	 */
	public abstract void execute();
	
	/**
	 * Changes the delay of this logic.
	 * @param delay The number of cycles between consecutive executions of this
	 * logic.
	 * @throws IllegalArgumentException if the {@code delay} is not positive.
	 */
	public void setDelay(int delay) {
		checkDelay(delay);
		delay = 0;
	}

	/**
	 * Stops this logic.
	 * @throws IllegalStateException if the logic has already been stopped.
	 */
	public void stop() {
		checkStopped();
		running = false;
	}

	/**
	 * Checks if the delay is negative and throws an exception if so.
	 * @param delay The delay.
	 * @throws IllegalArgumentException if the delay is not positive.
	 */
	private void checkDelay(int delay) {
		if (delay <= 0)
			throw new IllegalArgumentException("Delay must be positive.");
	}

	/**
	 * Checks if this logic has been stopped and throws an exception if so.
	 * @throws IllegalStateException if the logic has been stopped.
	 */
	private void checkStopped() {
		if (!running)
			throw new IllegalStateException();
	}

}