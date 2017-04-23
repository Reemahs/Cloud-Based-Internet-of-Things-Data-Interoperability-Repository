package iot.interop.application.app;

import org.eclipse.jetty.server.Server;

import iot.interop.logger.SystemLog;
import iot.interop.safeshutdown.ShutdownHook;

/**
 * Application Launcher
 * Main class for application
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class ApplicationLauncher {
	/**
	 * Main method for the application
	 * @param args 1) Server port number
	 */
	public static void main (String[] args){
		SystemLog appLaunchLog = new SystemLog(ApplicationLauncher.class);
		
		//Instantiate application server attributes
		Server appServer = new Server(Integer.parseInt(args[0]));	//Set server port to input argument
		ApplicationServer application = new ApplicationServer();
		
		//Create shutdown hook to handle application shutdown
		ShutdownHook shutdownApplication = new ShutdownHook(application);
		Runtime.getRuntime().addShutdownHook(shutdownApplication);
		
		appServer.setHandler(application);
		
		//Launch the application Server
		appLaunchLog.logInfo("Starting Application");
		try{
			appServer.start();
			appServer.join();
			shutdownApplication.join();
		}catch (Exception e){
			appLaunchLog.logError(e.toString());
		}
	}
}