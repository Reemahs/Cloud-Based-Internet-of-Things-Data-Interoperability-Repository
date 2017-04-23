package iot.interop.hub.transform;

import com.fasterxml.jackson.databind.JsonNode;

import iot.interop.http.HTTPRequest;
import iot.interop.hub.data.RepositoryData;
import iot.interop.json.JsonInput;
import iot.interop.json.JsonOutput;
import iot.interop.logger.SystemLog;
import iot.interop.transforms.IoTTransform;

/**
 * NodeTransformationManager
 * 
 * This class carries out the interoperbility transformation for IoT device. 
 * 
 * IoT device transformation requires querying the repository for the device identifier via a HTTP get request. 
 * The repository then returns the name for the particular device transformation class which is then instantiated and called.
 * The transformed device object is then converted into a JSON String which is sent to the application for logging. 
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class NodeTransformerManager {
	private SystemLog nodeTransformLog;
	private HTTPRequest httpRequests;
	private String repositoryURL;
	private String applicationURL;
	
	private RepositoryData repositoryDataObject;
	private NodeIDExtractor idExtractor;
	
	private JsonInput  jsonInputProcessor;
	private JsonOutput jsonOutputProcessor;
	
	public NodeTransformerManager (String repositoryURL, String applicationURL){
		this.nodeTransformLog = new SystemLog(NodeTransformerManager.class);
		
		this.httpRequests = new HTTPRequest();
		this.repositoryURL = repositoryURL;
		this.applicationURL = applicationURL;
		
		this.repositoryDataObject = new RepositoryData();
		
		this.idExtractor = new NodeIDExtractor();
		
		this.jsonInputProcessor = new JsonInput(null);
		this.jsonOutputProcessor = new JsonOutput(null);
	}
	
	/**
	 * This method is called by the hub server to begin the transformation process.
	 * @param rawDeviceMessage The raw JSON device message received by the hub server
	 * @throws Exception Throws an exception for any failure when dealing with JSON conversion, HTTP requests to the repository or application.
	 */
	public void applyTransformation (String rawDeviceMessage) throws Exception{
		this.nodeTransformLog.logInfo("Starting Transformation Process");
		
		this.nodeTransformLog.logInfo("Converting Message to Json Object");
		JsonNode jsonDevice = this.jsonInputProcessor.parseString(rawDeviceMessage);
		
		this.nodeTransformLog.logInfo("Getting Device ID");
		String deviceID = idExtractor.getDeviceID(jsonDevice);
		
		// Continue transformation process if a valid device identifier is found
		if (deviceID != null){
			this.nodeTransformLog.logInfo("Valid ID Found. Querying Repository for Transform.");
			getTransformClassName(deviceID);
			String tranformClassName = this.repositoryDataObject.getDeviceTransform();
			
			// Converts the device transformation class name from a string into a class and instantiates it
			this.nodeTransformLog.logInfo("Creating Object for Class: " + tranformClassName);
			Class<?> transformerClass = Class.forName(tranformClassName);
			IoTTransform transformerObject = (IoTTransform) transformerClass.newInstance();
			
			// Run the transformation method from the instantiated class and convert to JSON object
			this.nodeTransformLog.logInfo("Applying Transformation");
			JsonNode transformedDevice = transformerObject.transformDevice(jsonDevice);
			
			// Send the transformed JSON object to the application for logging
			toApplication(transformedDevice);
		} else {
			this.nodeTransformLog.logInfo("Invalid ID Found. Terminating Transformation Process.");
		}
	}
	
	/**
	 * This method queries the repository for a particular IoT device identifier and sets the returned class name to repository data object
	 * @param deviceID Requires the IoT device identifier as a String
	 * @throws Exception Throws exception for any connection errors with the repository
	 */
	private void getTransformClassName (String deviceID) throws Exception{
		this.nodeTransformLog.logInfo("Getting Transfomation Class Name for: " + deviceID);
		String queryResponseRaw = queryRepository(deviceID);
		this.repositoryDataObject.parseRepositoryResponse(queryResponseRaw);
	}
	
	/**
	 * This sends the HTTP get request to the repository
	 * @param queryID Requires the IoT device identifier as a String
	 * @return Returns the name of the transformation class for the particular IoT device
	 * @throws Exception Throws exception for any connection errors with the repository
	 */
	private String queryRepository(String queryID) throws Exception{
		this.nodeTransformLog.logInfo("Sending GET Request to Repository for: " + queryID);
		return httpRequests.sendGet(this.repositoryURL, "deviceID", queryID);
	}
	
	/**
	 * This method sends the transformed device object to the application for logging
	 * @param transformedDevice Requires the transformed device as a JSON object
	 * @throws Exception Throws exception for any connection errors with the application
	 */
	private void toApplication (JsonNode transformedDevice) throws Exception{
		this.nodeTransformLog.logInfo("Sending Transformed Message to Application");
		String outputMessage =  jsonOutputProcessor.toString(transformedDevice);
		httpRequests.sendJSONPost(this.applicationURL, outputMessage);
	}
	
}
