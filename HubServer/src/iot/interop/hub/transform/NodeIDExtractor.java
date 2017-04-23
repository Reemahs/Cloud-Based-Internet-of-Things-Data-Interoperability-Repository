package iot.interop.hub.transform;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;

import iot.interop.logger.SystemLog;

/**
 * NodeIDExtractor
 * This class is responsible for locating the IoT device identifier by parsing the given JSON object for key words (deviceIdentifiers).
 * These keywords have been found at describing IoT device identifiers. The process stops with the first keyword match and returns
 * the resulting device identifier.
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class NodeIDExtractor {
	private SystemLog idExtractorLog;
	private ArrayList<String> deviceIdentifiers;
	
	public NodeIDExtractor (){
		this.idExtractorLog = new SystemLog(NodeIDExtractor.class);
		this.deviceIdentifiers = new ArrayList<>();
		
		// Keyword list
		this.deviceIdentifiers.add("deviceid");
		this.deviceIdentifiers.add("deviceID");
		this.deviceIdentifiers.add("device_id");
		this.deviceIdentifiers.add("device_ID");
		this.deviceIdentifiers.add("identifier");
		this.deviceIdentifiers.add("Identifier");
		this.deviceIdentifiers.add("identification");
		this.deviceIdentifiers.add("Identification");
	}
	
	/**
	 * This method parses the given JSON object against the deviceIdentifiers list.
	 * @param jsonDeviceStructure The IoT device JSON object 
	 * @return The found IoT device identifier as a String
	 */
	public String getDeviceID (JsonNode jsonDeviceStructure){
		String deviceID = null;
		
		idExtractorLog.logInfo("Searching for Device Identifier");
		for (String deviceIDType : this.deviceIdentifiers){
			idExtractorLog.logDebug(deviceIDType + " = " + deviceID);
			try{
				deviceID = jsonDeviceStructure.findValue(deviceIDType).toString();
			} catch (Exception e){
				idExtractorLog.logInfo("Invalid Keyword");
				idExtractorLog.logError(e.toString());
			}
			
			if (deviceID != null){
				deviceID = deviceID.replaceAll("\"", "");
				idExtractorLog.logInfo("Found Possible Valid ID");
				break;
			}
		}	
		
		idExtractorLog.logInfo("Returning: " + deviceID);
		return deviceID;
	}
}
