package iot.interop.transforms.nest;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;

import iot.interop.json.JsonOutput;
import iot.interop.logger.SystemLog;
import iot.interop.transforms.IoTTransform;
import iot.interop.transforms.uniform.UniformThermostat;

/**
 * NESTThermostatV4
 * This class is responsible for converting the NEST Thermostat (Version 4) to the uniform thermostat data structure
 * 
 * @author Shameer Omar
 * @version 1.0
 */
public class NESTThermostatV4 implements IoTTransform {
	private SystemLog nestTransformLog;
	private ArrayList<String> nestDeviceStrucutre;
	private JsonOutput jsonOutputProcessor;
	
	/**
	 * NEST Thermostat V4 constructor
	 */
	public NESTThermostatV4 () {
		this.nestTransformLog = new SystemLog(NESTThermostatV4.class);
		this.nestDeviceStrucutre = new ArrayList<>();
		
		// Data structure for NEST Thermostat
		this.nestDeviceStrucutre.add("metadata");
		this.nestDeviceStrucutre.add("thermostat");
		this.nestDeviceStrucutre.add("structure");
		
		this.jsonOutputProcessor = new JsonOutput(null);
	}

	/**
	 * This method is implemented from the IoTTransform interface. 
	 * It is responsible for the primary data conversion from the NEST data structure into the uniform thermostat structure.
	 * The data structure is returned as a JSON object.
	 */
	@Override
	public JsonNode transformDevice(JsonNode deviceJson) throws Exception {
		nestTransformLog.logInfo("Parsing NEST Thermostat");
		JsonNode nestThermostat = deviceJson.path(nestDeviceStrucutre.get(1));
		JsonNode nestStructure  = deviceJson.path(nestDeviceStrucutre.get(2));
		
		// Convert data structure
		String deviceID				= nestThermostat.path("deviceID").asText();
		String deviceManufacturer 	= "NEST";
		String deviceVersion		= nestThermostat.path("softwareVersion").asText();
		String deviceLocation		= nestStructure.path("name").asText() + ", " + nestThermostat.path("nameLong").asText();
		String deviceMode			= nestThermostat.path("hvacmode").asText();
		double ambientTemp			= nestThermostat.path("ambientTemperatureC").asDouble();
		double targetTemp			= nestThermostat.path("targetTemperatureC").asDouble();
		double ambientHumidity		= nestThermostat.path("humidity").asDouble();
		
		// Create new transformed object and convert to JSON object
		nestTransformLog.logInfo("Creating Uniform Thermostat Object");
		UniformThermostat transformedDeviceObject = new UniformThermostat(deviceID, deviceManufacturer, deviceVersion, deviceLocation, deviceMode, ambientTemp, targetTemp, ambientHumidity);
		JsonNode transformedDeviceJson = jsonOutputProcessor.toJson(transformedDeviceObject);
		
		nestTransformLog.logInfo("Returning New Uniform Thermostat Object");
		return transformedDeviceJson;
	}
}
