package iot.interop.nestsim.json;

import com.fasterxml.jackson.databind.JsonNode;

import iot.interop.nestsim.data.Metadata;
import iot.interop.nestsim.data.Structure;
import iot.interop.nestsim.data.Thermostat;

/**
 * JsonParser
 * This class parses the NEST thermostat from its raw JSON form into the SimDevice data structure so that it can be easily accessed and updated during the simulations.
 * 
 * All the methods in this class are responsible for parsing particular child objects of the SimDevice object.
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class JsonParser {
	public JsonParser () {};
	
	/**
	 * This method parses the raw JSON node for fields in the metadata data structure
	 * @param rawJsonObject The raw JSON node as read in from the device file
	 * @param metadata The metadata child object of the SimDevice object
	 */
	public void parseMetadata (JsonNode rawJsonObject, Metadata metadata) throws Exception{
		JsonNode jsonMetadata = rawJsonObject.path("metadata");
		
		metadata.setAccessToken		(jsonMetadata.path("access_token").asText());
		metadata.setClientVersion	(jsonMetadata.path("client_version").asInt());
	}
	
	/**
	 * This method parses the raw JSON node for fields in the thermostat data structure
	 * @param rawJsonObject The raw JSON node as read in from the device file
	 * @param camera The camera child object of the SimDevice object
	 */
	public void parseThermostat (JsonNode rawJsonObject, Thermostat thermostat) throws Exception{
		JsonNode jsonThermostat = rawJsonObject.path("thermostats");
		
		thermostat.setDeviceID					(jsonThermostat.path("device_id").asText());
		thermostat.setLocale					(jsonThermostat.path("locale").asText());
		thermostat.setSoftwareVersion			(jsonThermostat.path("software_version").asText());
		thermostat.setStructureID				(jsonThermostat.path("structure_id").asText());
		thermostat.setName						(jsonThermostat.path("name").asText());
		thermostat.setNameLong					(jsonThermostat.path("name_long").asText());
		thermostat.setLastConnection			(jsonThermostat.path("last_connection").asText());
		thermostat.setFanTimerTimeout			(jsonThermostat.path("fan_timer_timeout").asText());
		thermostat.setTemperatureScale			(jsonThermostat.path("temperature_scale").asText());
		thermostat.setHVACMode					(jsonThermostat.path("hvac_mode").asText());
		thermostat.setHVACState					(jsonThermostat.path("hvac_state").asText());
		thermostat.setWhereID					(jsonThermostat.path("where_id").asText());
		thermostat.setMinLockedTempF			(jsonThermostat.path("locked_temp_min_f").asText());
		thermostat.setMinLockedTempC			(jsonThermostat.path("locked_temp_min_c").asText());
		thermostat.setMaxLockedTempF			(jsonThermostat.path("locked_temp_max_f").asText());
		thermostat.setMaxLockedTempC			(jsonThermostat.path("locked_temp_max_c").asText());
		thermostat.setLabel						(jsonThermostat.path("label").asText());
		thermostat.setWhereName					(jsonThermostat.path("where_name").asText());
		thermostat.setTimeToTarget				(jsonThermostat.path("time_to_target").asText());
		thermostat.setTimeToTargetTraining		(jsonThermostat.path("time_to_target_training").asText());
		thermostat.setPreviousHVACModes			(jsonThermostat.path("previous_hvac_mode").asText());
		thermostat.setOnlineStatus				(jsonThermostat.path("is_online").asBoolean());
		thermostat.setCoolingAvailablity		(jsonThermostat.path("can_cool").asBoolean());
		thermostat.setHeatingAvailability		(jsonThermostat.path("can_heat").asBoolean());
		thermostat.setEmergencyHeatStatus		(jsonThermostat.path("is_using_emergency_heat").asBoolean());
		thermostat.setFanAvailabilty			(jsonThermostat.path("has_fan").asBoolean());
		thermostat.setFanActivityState			(jsonThermostat.path("fan_timer_active").asBoolean());
		thermostat.setLeaf						(jsonThermostat.path("has_leaf").asBoolean());
		thermostat.setLockStatus				(jsonThermostat.path("is_locked").asBoolean());
		thermostat.setSunlightEnabled			(jsonThermostat.path("sunlight_correction_enabled").asBoolean());
		thermostat.setSunlightActive			(jsonThermostat.path("sunlight_correction_active").asBoolean());
		thermostat.setFanTimerDuration			(jsonThermostat.path("fan_timer_duration").asInt());
		thermostat.setTargetTemperatureF		(jsonThermostat.path("target_temperature_f").asInt());
		thermostat.setTargetTemperatureC		(jsonThermostat.path("target_temperature_c").asDouble());
		thermostat.setHighTargetTemperatureF	(jsonThermostat.path("target_temperature_high_f").asInt());
		thermostat.setHighTargetTemperatureC	(jsonThermostat.path("target_temperature_high_c").asDouble());
		thermostat.setLowTargetTemperatureF		(jsonThermostat.path("target_temperature_low_f").asInt());
		thermostat.setLowTargetTemperatureC		(jsonThermostat.path("target_temperature_low_c").asDouble());
		thermostat.setEcoHighTemperatureF		(jsonThermostat.path("eco_temperature_high_f").asInt());
		thermostat.setEcoHighTemperatureC		(jsonThermostat.path("eco_temperature_high_c").asDouble());
		thermostat.setEcoLowTemperatureF		(jsonThermostat.path("eco_temperature_low_f").asInt());
		thermostat.setEcoLowTemperatureC		(jsonThermostat.path("eco_temperature_low_c").asDouble());
		thermostat.setAmbientTemperatureF		(jsonThermostat.path("ambient_temperature_f").asInt());
		thermostat.setAmbientTemperatureC		(jsonThermostat.path("ambient_temperature_c").asDouble());
		thermostat.setHumidity					(jsonThermostat.path("humidity").asInt());
	}
	
	/**
	 * This method parses the raw JSON node for fields in the structure data structure
	 * @param rawJsonObject The raw JSON node as read in from the device file
	 * @param structure The structre child object of the SimDevice object
	 */
	public void parseStructure (JsonNode rawJsonObject, Structure structure) throws Exception{	
		JsonNode jsonStructure 	= rawJsonObject.path("structures");
		JsonNode jsonETA 		= jsonStructure.path("eta");
		JsonNode jsonWhere 		= jsonStructure.path("wheres");
		
		structure.setStructureID							(jsonStructure.path("structure_id").asText());
		structure.setAway									(jsonStructure.path("away").asText());
		structure.setName									(jsonStructure.path("name").asText());
		structure.setCountryCode							(jsonStructure.path("country_code").asText());
		structure.setPostalCode								(jsonStructure.path("postal_code").asText());
		structure.setPeakPeriodStartTime					(jsonStructure.path("peak_period_start_time").asText());
		structure.setPeakPeriodEndTime						(jsonStructure.path("peak_period_end_time").asText());
		structure.setTimeZone								(jsonStructure.path("time_zone").asText());
		structure.setRHREnrollment							(jsonStructure.path("rhr_enrollment").asBoolean());
		
		structure.getETA().setTripID						(jsonETA.path("trip_id").asText());
		structure.getETA().setEstimatedArrivalWindowBegin	(jsonETA.path("estimated_arrival_window_begin").asText());
		structure.getETA().setEstimatedArricalWindowEnd		(jsonETA.path("estimated_arrival_window_end").asText());
		
		structure.getWheres().setWhereID					(jsonWhere.path("where_id").asText());
		structure.getWheres().setName						(jsonWhere.path("name").asText());
	}
}
