package iot.interop.repository.app;

import org.eclipse.jetty.server.Server;

import iot.interop.logger.SystemLog;
import iot.interop.safeshutdown.ShutdownHook;

/**
 * This class launches the repository server.
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class RepositoryLauncher {
	
	/**
	 * @param args 0) Server port number, 1) MySQL URL, 2) MySQL username, 3) MySQL password
	 */
	public static void main(String[] args) {
		SystemLog sysLogger = new SystemLog(RepositoryLauncher.class);
		
		// Create the server
		Server jettyServer = new Server(Integer.parseInt(args[0]));
		RepositoryServer repositoryService = new RepositoryServer(args[1], args[2], args[3]);
		
		// Add a shutdown hook
		ShutdownHook shutdownRepository = new ShutdownHook(repositoryService);
		Runtime.getRuntime().addShutdownHook(shutdownRepository);	
		
		jettyServer.setHandler(repositoryService);
		
		sysLogger.logInfo("Starting Repository Server");
		try {
			jettyServer.start();
			jettyServer.join();
			shutdownRepository.join();
		} catch (Exception e) {
			sysLogger.logError(e.toString());
		}
	}
}
