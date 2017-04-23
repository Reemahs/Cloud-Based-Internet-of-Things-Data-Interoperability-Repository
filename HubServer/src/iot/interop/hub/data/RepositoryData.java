package iot.interop.hub.data;

import com.fasterxml.jackson.databind.JsonNode;

import iot.interop.json.JsonInput;
import iot.interop.logger.SystemLog;

/**
 * RepositoryData 
 * This class is the data structure for handling repository requests (deviceID) and results (deviceTransform)
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class RepositoryData {
	private SystemLog respositoryDataLog;
	private JsonInput jsonStringParser;
	
	// Repository query
	private String deviceID;
	
	// Repository result
	private String deviceTransform;
	
	public RepositoryData (){
		this.respositoryDataLog = new SystemLog(RepositoryData.class);
		this.jsonStringParser = new JsonInput(null);
	}
	
	/**
	 * @return IoT device identifier as String
	 */
	public String getDeviceID (){
		return this.deviceID;
	}
	
	/**
	 * @return Class name for particular IoT device
	 */
	public String getDeviceTransform (){
		return this.deviceTransform;
	}
	
	/**
	 * This method parses the raw JSON response from the repository and sets them to the class fields.
	 * @param repositoryResponseString The raw JSON String response from the repository
	 * @throws Exception Throws exception at error for JSON parsing
	 */
	public void parseRepositoryResponse(String repositoryResponseString) throws Exception{
		respositoryDataLog.logInfo("Converting Repository Response: " + repositoryResponseString +  " to JSON");
		JsonNode repositoryResponseJSON = jsonStringParser.parseString(repositoryResponseString);
		
		this.deviceID = repositoryResponseJSON.path("deviceID").asText();
		this.deviceTransform = repositoryResponseJSON.path("transformationClass").asText();
	}
	
}
