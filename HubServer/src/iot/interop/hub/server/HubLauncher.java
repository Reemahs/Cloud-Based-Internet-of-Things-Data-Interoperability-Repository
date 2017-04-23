package iot.interop.hub.server;

import org.eclipse.jetty.server.Server;

import iot.interop.logger.SystemLog;
import iot.interop.safeshutdown.ShutdownHook;

/**
 * HubLauncher
 * This class is responsible for launching the hub.
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class HubLauncher {
	private SystemLog hubLauchLog;
	
	private Server hubServer;
	private HubServer hub;
	
	/**
	 * Constructor for the hub launcher
	 * @param serverPort The port number for the hub server
	 * @param respositoryURL URL for the repository server
	 * @param applicationURL URL for the application server
	 */
	public HubLauncher(String serverPort, String respositoryURL, String applicationURL){
		hubLauchLog= new SystemLog(HubLauncher.class);
		hubServer = new Server(Integer.parseInt(serverPort));
		hub = new HubServer(respositoryURL, applicationURL);
	}
	
	/**
	 * Launch the hub server
	 */
	public void launchHub (){	
		ShutdownHook shutdownHub = new ShutdownHook(hub);
		Runtime.getRuntime().addShutdownHook(shutdownHub);
		
		hubServer.setHandler(hub);
		
		hubLauchLog.logInfo("Starting Hub");
		try{
			hubServer.start();
			hubServer.join();
			shutdownHub.join();
		}catch (Exception e) {
			hubLauchLog.logError(e.toString());
		}
	}
}
