package iot.interop.transforms.ecobee;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;

import iot.interop.json.JsonOutput;
import iot.interop.logger.SystemLog;
import iot.interop.transforms.IoTTransform;
import iot.interop.transforms.uniform.UniformThermostat;

/**
 * EcobeeThermostatV7
 * This class is responsible for converting the Ecobee Thermostat (Version 7) to the uniform thermostat data structure
 * 
 * @author Shameer Omar
 * @version 1.0
 */
public class EcoBeeThermostatV7 implements IoTTransform {
	private SystemLog ecoBeeTransformLog;
	private ArrayList<String> ecoBeeDeviceStrucutre;
	private JsonOutput jsonOutputProcessor;
	
	/**
	 * Ecobee Thermostat V7 constructor
	 */
	public EcoBeeThermostatV7 (){
		this.ecoBeeTransformLog = new SystemLog(EcoBeeThermostatV7.class);
		this.ecoBeeDeviceStrucutre = new ArrayList<>();
		
		this.ecoBeeDeviceStrucutre.add("climate");
		this.ecoBeeDeviceStrucutre.add("event");
		this.ecoBeeDeviceStrucutre.add("thermostat");
		this.ecoBeeDeviceStrucutre.add("runTime");
		this.ecoBeeDeviceStrucutre.add("device");
		this.ecoBeeDeviceStrucutre.add("houseDetails");
		this.ecoBeeDeviceStrucutre.add("version");
		this.ecoBeeDeviceStrucutre.add("user");
		
		this.jsonOutputProcessor = new JsonOutput(null);
	}

	/**
	 * This method is implemented from the IoTTransform interface. 
	 * It is responsible for the primary data conversion from the Ecobee data structure into the uniform thermostat structure.
	 * The data structure is returned as a JSON object.
	 */
	@Override
	public JsonNode transformDevice(JsonNode deviceJson) throws Exception {
		ecoBeeTransformLog.logInfo("Parsing NEST Thermostat");
		JsonNode ecoBeeThermostat = deviceJson.path(ecoBeeDeviceStrucutre.get(2));
		JsonNode ecoBeeRunTime    = ecoBeeThermostat.path(ecoBeeDeviceStrucutre.get(3));
		JsonNode ecoBeeVersion    = ecoBeeThermostat.path(ecoBeeDeviceStrucutre.get(6));
		
		// Convert data structure
		String deviceID				= ecoBeeThermostat.path("identifier").asText();
		String deviceManufacturer 	= ecoBeeThermostat.path("brand").asText();
		String deviceVersion		= ecoBeeVersion.path("thermostatFirmwareVersion").asText();
		String deviceLocation		= ecoBeeThermostat.path("name").asText();
		String deviceMode			= ecoBeeRunTime.path("desiredFanMode").asText();
		double ambientTemp			= ecoBeeRunTime.path("actualTemperature").asDouble();
		double targetTemp			= ecoBeeRunTime.path("desiredHeat").asDouble();
		double ambientHumidity		= ecoBeeRunTime.path("actualHumidity").asDouble();
		
		// Create new transformed object and convert to JSON object
		ecoBeeTransformLog.logInfo("Creating Uniform Thermostat Object");
		UniformThermostat transformedDeviceObject = new UniformThermostat(deviceID, deviceManufacturer, deviceVersion, deviceLocation, deviceMode, ambientTemp, targetTemp, ambientHumidity);
		JsonNode transformedDeviceJson = jsonOutputProcessor.toJson(transformedDeviceObject);
		
		ecoBeeTransformLog.logInfo("Returning New Uniform Thermostat Object");
		return transformedDeviceJson;
	}

}
