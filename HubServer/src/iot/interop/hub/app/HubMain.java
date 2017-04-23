package iot.interop.hub.app;

import iot.interop.hub.server.HubLauncher;
import iot.interop.logger.SystemLog;

/**
 * HubMain
 * This is the main class for the Hub
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class HubMain {
	
	/**
	 * This this the Main method for the Hub
	 * @param args 1)Server Port 2)Repository URL 3)Application URL 
	 */
	public static void main(String[] args) {
		SystemLog hubMainLog = new SystemLog(HubMain.class);
		
		HubLauncher hubMain = new HubLauncher(args[0], args[1], args[2]);
		
		hubMainLog.logInfo("Starting Hub");
		hubMain.launchHub();
	}

}
