package iot.interop.hub.server;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import iot.interop.hub.transform.NodeTransformerManager;
import iot.interop.logger.SystemLog;
import iot.interop.safeshutdown.Stopable;

/**
 * HubServer
 * This is the main class for the Hub. It handles all the HTTP requests from external clients.
 * 
 * It's main aim is to receive the HTTP request from the simulated IoT device, extract the device properties, 
 * apply the transformation for the particular IoT device and send the transformed device to the application for logging.
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class HubServer extends AbstractHandler implements Stopable{
	private SystemLog hubServerLog;
	private String repositoryURL;
	private String applicationURL;
	
	/**
	 * Constructor for the hub server
	 * @param repositoryURL The URL for the repository
	 * @param applicationURL The URL for the application
	 */
	public HubServer (String repositoryURL, String applicationURL){
		this.hubServerLog = new SystemLog(HubServer.class);
		this.repositoryURL = repositoryURL;
		this.applicationURL = applicationURL;
	};
	
	/**
	 * This method handles the HTTP requests from the simulated IoT devices. It currently only handles POST requests as they contain the IoT device properties 
	 * as a JSON payload.
	 */
	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String requestType = request.getMethod().toUpperCase();
		
		switch(requestType){
		case "POST":
			hubServerLog.logInfo("Recived POST Message from IoT Node");
			
			String rawMessage = processIncommingMessage(request);
			hubServerLog.logDebug("Complete Message: " + rawMessage);
			
			hubServerLog.logInfo("Sending Response: " + HttpServletResponse.SC_OK + " OK");
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().printf("Parsed Message: " + rawMessage);
			baseRequest.setHandled(true);	
			
			hubServerLog.logInfo("Handing Over to Transformation Process");
			NodeTransformerManager nodeTransformer = new NodeTransformerManager(repositoryURL, applicationURL);
			try {
				nodeTransformer.applyTransformation(rawMessage);
			} catch (Exception e) {
				hubServerLog.logError(e.toString());
			}
		break;			
		default:
			hubServerLog.logInfo("Invalid Message Recieved");
			
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			hubServerLog.logInfo("Sending Response: " + HttpServletResponse.SC_METHOD_NOT_ALLOWED + " MESSAGE NOT ALLOWED");
			response.getWriter().printf(requestType + " is not accepted by Repository Server");
			baseRequest.setHandled(true);
			break;
		}
		
	}

	/**
	 * This method is only used when the hub is shut down.
	 */
	@Override
	public void stopService() {
		hubServerLog.logInfo("Shutting Down Hub");		
	}
	
	/**
	 * This method processes the 
	 * @param request The POST request from the client
	 * @return Concatenated string of all individual lines within the original POST request
	 * @throws IOException Throws exception if errors occur during the concatenation process.
	 */
	private String processIncommingMessage (HttpServletRequest request) throws IOException{
		StringBuilder messageBuilder = new StringBuilder();
		BufferedReader postReader = request.getReader();
		String bufferLine;
		
		while ((bufferLine = postReader.readLine()) != null) {
			hubServerLog.logDebug("Message Line: " + bufferLine);
			messageBuilder.append(bufferLine);
        }
   
		String rawMessage = messageBuilder.toString();
		return rawMessage;
	}
	
}
