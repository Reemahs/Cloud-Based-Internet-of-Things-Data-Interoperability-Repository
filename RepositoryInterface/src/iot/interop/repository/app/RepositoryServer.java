package iot.interop.repository.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import iot.interop.logger.SystemLog;
import iot.interop.repository.data.DeviceResponse;
import iot.interop.repository.data.ServerResponseCreator;
import iot.interop.repository.database.QueryDatabase;
import iot.interop.safeshutdown.Stopable;

/**
 * RepositoryServer
 * This is the main class for the repository server. It handles the HTTP requests from the clients.
 * Currently only HTTP get requests are processed by the server.
 * 
 * @author Shameer Omar
 * @version
 */
public class RepositoryServer extends AbstractHandler implements Stopable{
	private SystemLog sysLogger;
	private QueryDatabase query;
	
	/**
	 * Repository server constructor
	 * @param url MySQL database URL
	 * @param userName MySQL database username
	 * @param password MySQL database password
	 */
	public RepositoryServer (String url, String userName, String password){
		sysLogger = new SystemLog(RepositoryServer.class);
		query = new QueryDatabase(url, userName, password);
		
		sysLogger.logInfo("Database Connection Established");
	}
	
	/**
	 * This method handles the HTTP requests from the simulated IoT devices. It currently only handles GET requests with one query field.
	 */
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String requestType = request.getMethod().toUpperCase();
		
		switch(requestType){
		case "GET":
			String deviceID = request.getParameter("deviceID");
			
			sysLogger.logInfo("Querying Database for: " + deviceID);
			DeviceResponse deviceResponse;
			try {
				// Query the MySQL database for the given device identifier
				deviceResponse = query.getTransformationClass(deviceID);
					
				// Generate the repository server response
				ServerResponseCreator serverResponse = new ServerResponseCreator();
				serverResponse.createServerResponse(deviceResponse);
				
				// Send response message
				response.setStatus(serverResponse.getHTTPServletResponse());
				response.getWriter().printf(serverResponse.getDeviceTransformJSON());
				baseRequest.setHandled(true);
			} catch (Exception e) {
				// Upon any type of error while handling the get request, send error
				sysLogger.logError(e.toString());
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				response.getWriter().printf(e.getMessage());
				baseRequest.setHandled(true);
			}
			break;
		default:
			// If any other type of request is made, send error
			sysLogger.logDebug("Invalid Message Recieved");
			
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			response.getWriter().printf(requestType + " is not accepted by Repository Server");
			baseRequest.setHandled(true);
			break;
		}
	}
	
	/**
	 * This method is only used when the respository server is shut down.
	 */
	@Override
	public void stopService(){
		try {
			query.closeDatabseConnection();
			sysLogger.logInfo("Database Connection Closed");
		} catch (Exception e) {
			sysLogger.logError(e.toString());
		}
	}
}