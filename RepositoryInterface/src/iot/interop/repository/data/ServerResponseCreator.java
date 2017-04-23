package iot.interop.repository.data;

import javax.servlet.http.HttpServletResponse;

import iot.interop.json.JsonOutput;
import iot.interop.logger.SystemLog;

/**
 * ServerResponseCreator
 * This class is responsible for creating the response message from the repository server to the client. 
 * The message will contain the querying device identifier, the device transformation class name and the server response code.
 * 
 * @author Shameer Omar
 * @version 1.0
 */
public class ServerResponseCreator {
	private SystemLog serverResponseCreatorLog;
	private int response;
	private String deviceTransformJSON;
	private JsonOutput jsonConvertor;
	
	/**
	 * The ServerResponseCreator constructor
	 */
	public ServerResponseCreator (){
		this.serverResponseCreatorLog = new SystemLog(ServerResponseCreator.class);
		
		this.response = Integer.MIN_VALUE;
		this.deviceTransformJSON = null;
		this.jsonConvertor = new JsonOutput(null);
	}
	
	/**
	 * This method creates the server response message for the client
	 * @param deviceResponse The raw response from the MySQL database
	 * @throws Exception Throws exception for any errors encountered during JSON conversion
	 */
	public void createServerResponse(DeviceResponse deviceResponse)throws Exception{
		if (deviceResponse.getTransformationClass() != null){
			// Valid response from MySQL database
			this.deviceTransformJSON = jsonConvertor.toString(deviceResponse);
			this.response = HttpServletResponse.SC_OK;
		} else {
			// Invalid response from MySQL database
			this.deviceTransformJSON = jsonConvertor.toString(deviceResponse);
			this.response = HttpServletResponse.SC_NOT_FOUND;
		}
		
		this.serverResponseCreatorLog.logInfo("Creating " + this.response + " Response with Message " + this.deviceTransformJSON);
	}	
	
	/**
	 * @return The HTTP server response code
	 */
	public int getHTTPServletResponse(){
		return this.response;
	}
	
	/**
	 * @return The DeviceResponse object as a JSON string
	 */
	public String getDeviceTransformJSON(){
		return this.deviceTransformJSON;
	}
}
