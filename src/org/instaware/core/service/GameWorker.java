package org.instaware.core.service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Performs core logic working.
 * @author Graham Edgecombe
 * @author Thomas Nappo
 */
public final class GameWorker implements Runnable {
	
	/**
	 * A logger used to report error messages.
	 */
	private static final Logger logger = Logger.getLogger(GameWorker.class.getName());
	
	/**
	 * The amount of time (in milliseconds) per working cycle.
	 */
	private static final int TIME_PERIOD = 600;
	
	/**
	 * The {@link ScheduledExecutorService} which schedules calls to the
	 * {@link #run()} method.
	 */
	private ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
	
	/**
	 * Retrieves the worker's service executor.
	 * @return The worker's service executor.
	 */
	public ScheduledExecutorService getService() {
		return service;
	}
	
	/**
	 * Encapsulates active units which are periodically worked.
	 */
	private final List<GameLogic> logic = new ArrayList<GameLogic>();
	
	/**
	 * A queue of units that still need to be added.
	 */
	private final Queue<GameLogic> pendingLogic = new ArrayDeque<GameLogic>();
	
	/**
	 * Constructs the worker.
	 */
	public GameWorker() {
		service.scheduleAtFixedRate(this, 0, TIME_PERIOD, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * Schedules the specified unit. If this scheduler has been stopped with
	 * the {@link #terminate()} method the unit will not be executed or
	 * garbage-collected.
	 * @param unit The unit to schedule.
	 */
	public void schedule(final GameLogic unit) {
		if (unit.isImmediate()) {
			service.execute(new Runnable() {
				@Override
				public void run() {
					unit.execute();
				}
			});
		}

		synchronized (pendingLogic) {
			pendingLogic.add(unit);
		}
	}

	/**
	 * This method is automatically called every cycle by the
	 * {@link ScheduledExecutorService} and executes, adds and removes
	 * {@link GameLogic}s. It should not be called directly as this will lead to
	 * concurrency issues and inaccurate time-keeping.
	 */
	@Override
	public void run() {
		synchronized (pendingLogic) {
			GameLogic unit;
			while ((unit = pendingLogic.poll()) != null)
				logic.add(unit);
		}

		for (Iterator<GameLogic> it = logic.iterator(); it.hasNext(); ) {
			GameLogic unit = it.next();
			try {
				if (!unit.cycle())
					it.remove();
			} catch (Throwable t) {
				logger.log(Level.SEVERE, "Exception during unit execution.", t);
			}
		}
	}

}