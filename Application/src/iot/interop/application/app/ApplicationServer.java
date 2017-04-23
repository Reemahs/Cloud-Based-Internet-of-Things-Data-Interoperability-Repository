package iot.interop.application.app;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import iot.interop.logger.SystemLog;
import iot.interop.safeshutdown.Stopable;
/**
 * Application Server
 * This class handles the main server requests for the Application. 
 * 
 * For this current version it receives transformed messages, via the POST request type, from the Hub and logs them for the user to evaluate. The messages sent from the hub are in a JSON format and are sent as strings.
 * 
 * Future versions of the server application can implement user interaction to control IoT nodes at either an individual or group level. 
 * 
 * @author Shameer Omar (13014595)
 * @version 1.0
 */
public class ApplicationServer extends AbstractHandler implements Stopable {
	private SystemLog appServerLog;
	
	/**
	 * Constructor for Application Server. 
	 */
	public ApplicationServer ()  {
		appServerLog = new SystemLog(ApplicationServer.class);	
	};

	/**
	 * Main handle method for Application Server. Currently only handles POST messages. 
	 */
	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		String requestType = request.getMethod().toUpperCase();
		
		switch(requestType){
		case "POST":
			appServerLog.logInfo("Recieved POST Message from Hub");
			
			StringBuilder messageBuilder = new StringBuilder();
			BufferedReader postReader = request.getReader();
			String bufferLine;
			
			//Loops to collect all incoming messages in a buffer
			while ((bufferLine = postReader.readLine()) != null){
				appServerLog.logDebug("Message Line " +  bufferLine);
				messageBuilder.append(bufferLine);
			}
			
			//Concatenation of buffer into a single String representing the original incoming message
			String rawMessage = messageBuilder.toString();
			appServerLog.logDebug("Complete Message: " + rawMessage);
			
			//Sending OK response to Hub to inform that its request has been handled correctly
			appServerLog.logInfo("Sending Response: " + HttpServletResponse.SC_OK + " OK");
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().printf("Parsed Message: " + rawMessage);
			baseRequest.setHandled(true);
			break;
		default:
			//This section of code is only active if the requestType anything other than POST
			appServerLog.logInfo("Invalid Message Recieved");
			
			//Sending METHOD NOT ALLOWED response to Hub to inform that its request can not be processed by the Application
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			appServerLog.logInfo("Sending Response: " + HttpServletResponse.SC_METHOD_NOT_ALLOWED + " METHOD NOT ALLOWED");
			response.getWriter().printf(requestType + " is not accepted by Application");
			baseRequest.setHandled(true);
			break;
		}
	}

	/**
	 * This method logs the date and time that the application is shutdown
	 */
	@Override
	public void stopService() {
		appServerLog.logInfo("Shutting Down Application");		
	}
}
