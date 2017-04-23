package iot.interop.safeshutdown;

import iot.interop.logger.SystemLog;

/**
 * ShutdownHook
 * This class is used to safely shutdown servers by creating shutdown hooks.
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class ShutdownHook extends Thread {
	private SystemLog shutdownLog = new SystemLog(ShutdownHook.class);
	private Stopable stopable;
	
	/**
	 * This method sets the stoppable for the given class
	 * @param stopable The stoppable created within the parent class
	 */
	public ShutdownHook(Stopable stopable){
		this.stopable = stopable;
		shutdownLog.logInfo("Shutdown Hook created for " + stopable.getClass().getName());
	}
	
	/**
	 * Called on shutdown
	 */
	@Override
	public void run () {
		shutdownLog.logInfo("Calling stop on " + stopable.getClass().getName());
		this.stopable.stopService();
	}
}
