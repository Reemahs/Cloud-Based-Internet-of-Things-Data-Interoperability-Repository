package iot.interop.ecobeesim.json;

import com.fasterxml.jackson.databind.JsonNode;

import iot.interop.ecobeesim.data.Climate;
import iot.interop.ecobeesim.data.Event;
import iot.interop.ecobeesim.data.Thermostat;
import iot.interop.ecobeesim.data.User;

/**
 * JsonParser
 * This class parses the Ecobee thermostat from its raw JSON form into the SimDevice data structure so that it can be easily accessed and updated during the simulations.
 * 
 * All the methods in this class are responsible for parsing particular child objects of the SimDevice object.
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class JsonParser {
	public JsonParser () {};
	
	/**
	 * This method parses the raw JSON node for fields in the climate data structure
	 * @param rawJsonObject The raw JSON node as read in from the device file
	 * @param climate The climate child object of the SimDevice object
	 */
	public void parseClimate (JsonNode rawJsonObject, Climate climate){
		JsonNode jsonClimate = rawJsonObject.path("Climate");
		climate.setName					(jsonClimate.path("name").asText());
		climate.setClimateRef			(jsonClimate.path("climateRef").asText());
		climate.setIsOccupied			(jsonClimate.path("isOccupied").asBoolean());
		climate.setIsOptimized			(jsonClimate.path("isOptimized").asBoolean());
		climate.setCoolFan				(jsonClimate.path("coolFan").asText());
		climate.setHeatFan				(jsonClimate.path("heatFan").asText());
		climate.setVent					(jsonClimate.path("vent").asText());
		climate.setVentilatorMinOnTime	(jsonClimate.path("ventilatorMinOnTime").asInt());
		climate.setOwner				(jsonClimate.path("owner").asText());
		climate.setType					(jsonClimate.path("type").asText());
		climate.setColour				(jsonClimate.path("colour").asInt());
		climate.setCoolTemp				(jsonClimate.path("coolTemp").asInt());
		climate.setHeatTemp				(jsonClimate.path("heatTemp").asInt());
	}
	
	/**
	 * This method parses the raw JSON node for fields in the event data structure
	 * @param rawJsonObject The raw JSON node as read in from the device file
	 * @param event The event child object of the SimDevice object
	 */
	public void parseEvent (JsonNode rawJsonObject, Event event){
		JsonNode jsonEvent = rawJsonObject.path("Event");
		event.setType							(jsonEvent.path("type").asText());
		event.setName							(jsonEvent.path("name").asText());
		event.setIsOccupied						(jsonEvent.path("isOccupied").asBoolean());
		event.setCoolHoldTemp					(jsonEvent.path("coolHoldTemp").asInt());
		event.setHeatHoldTemp					(jsonEvent.path("heatHoldTemp").asInt());
		event.setVent							(jsonEvent.path("vent").asText());
		event.setVentilatorMinOnTime			(jsonEvent.path("ventilatorMinOnTime").asInt());
		event.setRunning						(jsonEvent.path("running").asBoolean());
		event.setStartDate						(jsonEvent.path("startDate").asText());
		event.setStartTime						(jsonEvent.path("startTime").asText());
		event.setEndDate						(jsonEvent.path("endDate").asText());
		event.setEndTime						(jsonEvent.path("endTime").asText());
		event.setIsCoolOff						(jsonEvent.path("isCoolOff").asBoolean());
		event.setIsHeatOff						(jsonEvent.path("isHeatOff").asBoolean());
		event.setFan							(jsonEvent.path("fan").asText());
		event.setIsOptional						(jsonEvent.path("isOptional").asBoolean());
		event.setIsTemperatureRelative			(jsonEvent.path("isTemperatureRelative").asBoolean());
		event.setCoolRelativeTemp				(jsonEvent.path("coolRelativeTemp").asInt());
		event.setHeatRelativeTemp				(jsonEvent.path("heatRelativeTemp").asInt());
		event.setIsTemperatureAbsolute			(jsonEvent.path("isTemperatureAbsolute").asBoolean());
		event.setDutyCyclePercentage			(jsonEvent.path("dutyCyclePercentage").asInt());
		event.setFanMinOnTime					(jsonEvent.path("fanMinOnTime").asInt());
		event.setOccupiedSensorActive			(jsonEvent.path("occupiedSensorActive").asBoolean());
		event.setUnoccupiedSensorActive			(jsonEvent.path("unoccupiedSensorActive").asBoolean());
	}
	
	/**
	 * This method parses the raw JSON node for fields in the climate data structure
	 * @param rawJsonObject The raw JSON node as read in from the device file
	 * @param thermostat The thermostat child object of the SimDevice object
	 */
	public void parseThermostat (JsonNode rawJsonObject, Thermostat thermostat){
		JsonNode jsonThermostat = rawJsonObject.path("Thermostat");
		thermostat.setIdentifier		(jsonThermostat.path("identifier").asText());
		thermostat.setName				(jsonThermostat.path("name").asText());
		thermostat.setThermostatRev		(jsonThermostat.path("thermostatRev").asText());
		thermostat.setIsRegistered		(jsonThermostat.path("isRegistered").asBoolean());
		thermostat.setModelNumber		(jsonThermostat.path("modelNumber").asText());
		thermostat.setBrand				(jsonThermostat.path("brand").asText());
		thermostat.setFeatures			(jsonThermostat.path("features").asText());
		thermostat.setLastModified		(jsonThermostat.path("lastModified").asText());
		thermostat.setUTCTime			(jsonThermostat.path("utcTime").asText());
		thermostat.setEquipmentStatus	(jsonThermostat.path("equipmentStatus").asText());
		
		JsonNode jsonRuntime = jsonThermostat.path("RunTime");		
		thermostat.getRunTime().setRuntimeRev			 (jsonRuntime.path("runTimeRev").asText());
		thermostat.getRunTime().setConnected			 (jsonRuntime.path("connected").asBoolean());
		thermostat.getRunTime().setFirstConnected		 (jsonRuntime.path("firstConnected").asText());
		thermostat.getRunTime().setDiscounnectedDateTime (jsonRuntime.path("disconnectDateTime").asText());
		thermostat.getRunTime().setLastModified			 (jsonRuntime.path("lastModified").asText());
		thermostat.getRunTime().setRuntimeDate			 (jsonRuntime.path("runTimeDate").asText());
		thermostat.getRunTime().setRuntimeInterval		 (jsonRuntime.path("runTimeInterval").asInt());
		thermostat.getRunTime().setActualTemperature	 (jsonRuntime.path("actualTemperature").asInt());
		thermostat.getRunTime().setActualHumidity		 (jsonRuntime.path("actualHumidity").asInt());
		thermostat.getRunTime().setDesiredHeat			 (jsonRuntime.path("desiredHeat").asInt());
		thermostat.getRunTime().setDesiredCool			 (jsonRuntime.path("desiredCool").asInt());
		thermostat.getRunTime().setDesiredHumidity		 (jsonRuntime.path("desiredHumidity").asInt());
		thermostat.getRunTime().setDesiredDehumidity	 (jsonRuntime.path("desiredDehumidity").asInt());
		thermostat.getRunTime().setDesiredFanMode		 (jsonRuntime.path("desiredFanMode").asText());
		
		JsonNode jsonDevice = jsonThermostat.path("Device");
		thermostat.getDevice().setDeviceID	(jsonDevice.path("deviceID").asInt());
		thermostat.getDevice().setName		(jsonDevice.path("name").asText());
		
		JsonNode jsonLocation = jsonThermostat.path("Location");
		thermostat.getLocation().setTimeZoneOffsetMinutes 	(jsonLocation.path("timeZoneOffsetMinutes").asInt());
		thermostat.getLocation().setTimeZone			   	(jsonLocation.path("timeZone").asText());
		thermostat.getLocation().setIsDaylightSaving	   	(jsonLocation.path("isDaylightSaving").asBoolean());
		thermostat.getLocation().setStreetAddress			(jsonLocation.path("streetAddress").asText());
		thermostat.getLocation().setCity					(jsonLocation.path("city").asText());
		thermostat.getLocation().setProvinceState			(jsonLocation.path("provinceState").asText());
		thermostat.getLocation().setCountry					(jsonLocation.path("country").asText());
		thermostat.getLocation().setPostalCode				(jsonLocation.path("postalCode").asText());
		thermostat.getLocation().setPhoneNumber				(jsonLocation.path("phoneNumber").asText());
	
		JsonNode jsonHouseDetails = jsonThermostat.path("HouseDetails");
		thermostat.getHouseDetails().setStyle				(jsonHouseDetails.path("style").asText());
		thermostat.getHouseDetails().setSize				(jsonHouseDetails.path("size").asInt());
		thermostat.getHouseDetails().setNumberOfFloors		(jsonHouseDetails.path("numberOfFloors").asInt());
		thermostat.getHouseDetails().setNumberOfRooms		(jsonHouseDetails.path("numberOfRooms").asInt());
		thermostat.getHouseDetails().setNumberOfOccupants	(jsonHouseDetails.path("numberOfOccupants").asInt());
		thermostat.getHouseDetails().setAge					(jsonHouseDetails.path("age").asInt());
		thermostat.getHouseDetails().setWindowEfficiency	(jsonHouseDetails.path("windowEfficiency").asInt());
		
		JsonNode jsonVersion = jsonThermostat.path("Version");
		thermostat.getVersion().setThermostatFirmwareVersion	(jsonVersion.path("thermostatFirmwareVerison").asText());
	}
	
	/**
	 * This method parses the raw JSON node for fields in the user data structure
	 * @param rawJsonObject The raw JSON node as read in from the device file
	 * @param user The user child object of the SimDevice object
	 */
	public void parseUser (JsonNode rawJsonObject, User user){
		JsonNode jsonUser = rawJsonObject.path("User");
		user.setUserName					(jsonUser.path("userName").asText());
		user.setDisplayName					(jsonUser.path("displayName").asText());
		user.setFirstName					(jsonUser.path("firstName").asText());
		user.setLastName					(jsonUser.path("lastName").asText());
		user.setHonerific					(jsonUser.path("honerific").asText());
		user.setRegisterDate				(jsonUser.path("registerDate").asText());
		user.setRegisterTime				(jsonUser.path("registerTime").asText());
		user.setDefaultThermostatIdentifier	(jsonUser.path("defaultThermostatIdentifier").asText());
		user.setManagementRef				(jsonUser.path("managementRef").asText());
		user.setUtilityRef					(jsonUser.path("utilityRef").asText());
		user.setSupportRef					(jsonUser.path("supportRef").asText());
		user.setPhoneNumber					(jsonUser.path("phoneNumber").asText());
		user.setIsResidential				(jsonUser.path("isResidential").asBoolean());
		user.setIsDeveloper					(jsonUser.path("isDeveloper").asBoolean());
		user.setIsManagement				(jsonUser.path("isManagement").asBoolean());
		user.setIsUtility					(jsonUser.path("isUtility").asBoolean());
		user.setIsContractor				(jsonUser.path("isContractor").asBoolean());
	}
}
