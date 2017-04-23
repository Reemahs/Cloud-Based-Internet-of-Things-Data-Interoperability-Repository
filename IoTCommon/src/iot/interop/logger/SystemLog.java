package iot.interop.logger;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * SystemLog
 * This class is used for system logging and requires the Apache Log4j library.
 * 
 * This class requires a configuration file to be stored in the bin folder.
 * This configuration file has to be called 'log4j2' and saved as an XML format.
 * Configuration settings can be found from the Apache website. 
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class SystemLog {
	private Logger log;
	
	/**
	 * Log constructor
	 * @param target The parent class
	 */
	public SystemLog (Class<?> target){
		this.log = LogManager.getLogger(target);
	};
	
	/**
	 * This method should be called for logging information essential for debugging
	 * @param message The debug message to be logged
	 */
	public void logDebug(String message){
		log.debug(message);
	}
	
	/**
	 * This method should be called for logging general information
	 * @param message The message to be logged
	 */
	public void logInfo(String message){
		log.info(message);
	}
	
	/**
	 * This method should be called for logging warning messages if the system
	 * needs to warn the user of a non-error situation
	 * @param message Warning message to user
	 */
	public void logWarn(String message){
		log.warn(message);
	}
	
	/**
	 * This method should be called when the system encounters an error regardless
	 * of whether it was handled or causes a crash
	 * @param message Error message to be logged
	 */
	public void logError(String message){
		log.error(message);
	}
	
	/**
	 * This method should be called when tracing attributes or system properties
	 * @param message Attribute/System property being traced
	 */
	public void logTrace(String message){
		log.trace(message);
	}
}
