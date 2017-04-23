package iot.interop.transforms.nest;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;

import iot.interop.json.JsonOutput;
import iot.interop.logger.SystemLog;
import iot.interop.transforms.IoTTransform;
import iot.interop.transforms.uniform.UnifromCamera;

/**
 * NESTCameraV4
 * This class is responsible for converting the NEST Camera (Version 4) to the uniform camera data structure
 * 
 * @author Shameer Omar
 * @version 1.0
 */
public class NESTCameraV4 implements IoTTransform {
	private SystemLog nestTransformLog;
	private ArrayList<String> nestDeviceStrucutre;
	private JsonOutput jsonOutputProcessor;
	
	/**
	 * NEST Camera V4 constructor
	 */
	public NESTCameraV4 () {
		this.nestTransformLog = new SystemLog(NESTThermostatV4.class);
		this.nestDeviceStrucutre = new ArrayList<>();
		
		this.nestDeviceStrucutre.add("metadata");
		this.nestDeviceStrucutre.add("cameras");
		this.nestDeviceStrucutre.add("activityZones");
		this.nestDeviceStrucutre.add("lastEvent");
		this.nestDeviceStrucutre.add("structures");
		
		this.jsonOutputProcessor = new JsonOutput(null);
	}

	/**
	 * This method is implemented from the IoTTransform interface. 
	 * It is responsible for the primary data conversion from the NEST data structure into the uniform camera structure.
	 * The data structure is returned as a JSON object.
	 */
	@Override
	public JsonNode transformDevice(JsonNode deviceJson) throws Exception {
		nestTransformLog.logInfo("Parsing NEST Camera");
		JsonNode nestCamera = deviceJson.path(nestDeviceStrucutre.get(1));
		JsonNode nestActivityZone = nestCamera.path(nestDeviceStrucutre.get(2));
		JsonNode nestLastEvent = nestCamera.path(nestDeviceStrucutre.get(3));
		
		// Convert data structure
		String deviceID				= nestCamera.path("deviceID").asText();
		String deviceManufacturer 	= "NEST";
		String deviceVersion		= nestCamera.path("softwareVersion").asText();
		String deviceLocation		= nestActivityZone.path("name").asText();
		String isDeviceOnline		= Boolean.toString(nestCamera.path("online").asBoolean());
		String isActivityMeasured	= Boolean.toString(nestLastEvent.path("hasSound").asBoolean() || nestLastEvent.path("hasMotion").asBoolean() || nestLastEvent.path("hasPerson").asBoolean());
		
		// Create new transformed object and convert to JSON object
		nestTransformLog.logInfo("Creating Uniform Camera Object");
		UnifromCamera transformedDeviceObject = new UnifromCamera(deviceID, deviceManufacturer, deviceVersion, deviceLocation, isDeviceOnline, isActivityMeasured);
		JsonNode transformedDeviceJson = jsonOutputProcessor.toJson(transformedDeviceObject);
		
		nestTransformLog.logInfo("Returning New Uniform Camera Object");
		return transformedDeviceJson;
	}
}
