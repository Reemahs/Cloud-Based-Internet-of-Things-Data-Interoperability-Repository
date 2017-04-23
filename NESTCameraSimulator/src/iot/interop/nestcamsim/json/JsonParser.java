package iot.interop.nestcamsim.json;

import com.fasterxml.jackson.databind.JsonNode;

import iot.interop.nestcamsim.data.Cameras;
import iot.interop.nestcamsim.data.Metadata;
import iot.interop.nestcamsim.data.Structures;

/**
 * JsonParser
 * This class parses the NEST camera from its raw JSON form into the SimDevice data structure so that it can be easily accessed and updated during the simulations.
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
	public void parseMetadata (JsonNode rawJsonObject, Metadata metadata){
		JsonNode jsonMetadata = rawJsonObject.path("metadata");
		
		metadata.setAccessToken		(jsonMetadata.path("access_token").asText());
		metadata.setClientVersion	(jsonMetadata.path("client_version").asText());
	}
	
	/**
	 * This method parses the raw JSON node for fields in the camera data structure
	 * @param rawJsonObject The raw JSON node as read in from the device file
	 * @param camera The camera child object of the SimDevice object
	 */
	public void parseCameras(JsonNode rawJsonObject, Cameras camera){
		JsonNode jsonCamera = rawJsonObject.path("cameras");
		camera.setDeviceID				(jsonCamera.path("device_id").asText());
		camera.setSoftwareVersion		(jsonCamera.path("software_version").asText());
		camera.setName					(jsonCamera.path("name").asText());
		camera.setNameLong				(jsonCamera.path("name_long").asText());
		camera.setOnline				(jsonCamera.path("is_online").asBoolean());
		camera.setStreaming				(jsonCamera.path("is_streaming").asBoolean());
		camera.setAudioInputEnabled		(jsonCamera.path("is_audio_input_enabled").asBoolean());
		camera.setLastOnlineChanged		(jsonCamera.path("last_is_online_change").asText());
		camera.setVideoHistoryEnabled	(jsonCamera.path("is_video_history_enabled").asBoolean());
		camera.setWebURL				(jsonCamera.path("web_url").asText());
		camera.setAppURL				(jsonCamera.path("app_url").asText());
		camera.setPublicShareEnabled	(jsonCamera.path("is_public_share_enabled").asBoolean());
		camera.setPublicShareURL		(jsonCamera.path("public_share_url").asText());
		camera.setSnapshortURL			(jsonCamera.path("snapshot_url").asText());
		
		JsonNode jsonActivityZones = jsonCamera.path("activity_zones");
		camera.getActivityZones().setName	(jsonActivityZones.path("name").asText());
		camera.getActivityZones().setID		(jsonActivityZones.path("id").asText());
		
		JsonNode jsonLastEvent = jsonCamera.path("last_event");
		camera.getLastEvent().setHasSound			(jsonLastEvent.path("has_sound").asBoolean());
		camera.getLastEvent().setHasMotion			(jsonLastEvent.path("has_motion").asBoolean());
		camera.getLastEvent().setHasPerson			(jsonLastEvent.path("has_person").asBoolean());
		camera.getLastEvent().setStartTime			(jsonLastEvent.path("start_time").asText());
		camera.getLastEvent().setEndTime			(jsonLastEvent.path("end_time").asText());
		camera.getLastEvent().setUrlsExpireTime		(jsonLastEvent.path("urls_expire_time").asText());
		camera.getLastEvent().setWebURL				(jsonLastEvent.path("web_url").asText());
		camera.getLastEvent().setAppURL				(jsonLastEvent.path("app_url").asText());
		camera.getLastEvent().setImageURL			(jsonLastEvent.path("image_url").asText());
		camera.getLastEvent().setAnimatedImageURL	(jsonLastEvent.path("animated_image_url").asText());
		camera.getLastEvent().setActivityZoneIDs	(jsonLastEvent.path("activity_zone_ids").asText());
	}
	
	/**
	 * This method parses the raw JSON node for fields in the structure data structure
	 * @param rawJsonObject The raw JSON node as read in from the device file
	 * @param structure The structre child object of the SimDevice object
	 */
	public void parseStructure(JsonNode rawJsonObject, Structures structure){
		JsonNode jsonStructure = rawJsonObject.path("structures");
		structure.setStructuresID			(jsonStructure.path("structure_id").asText());
		structure.setAway					(jsonStructure.path("away").asText());
		structure.setName					(jsonStructure.path("name").asText());
		structure.setCountryCode			(jsonStructure.path("country_code").asText());
		structure.setPostalCode				(jsonStructure.path("postal_code").asText());
		structure.setPeakPeriodStartTime	(jsonStructure.path("peak_period_start_time").asText());
		structure.setPeakPeriodEndTime		(jsonStructure.path("peak_period_end_time").asText());
		structure.setTimeZone				(jsonStructure.path("time_zone").asText());
		
		JsonNode jsonETA = jsonStructure.path("eta");
		structure.getETA().setTripID						(jsonETA.path("trip_id").asText());
		structure.getETA().setEstimatedArrivalWindowBegin	(jsonETA.path("estimated_arrival_window_begin").asText());
		structure.getETA().setEstimatedArrivalWindowEnd		(jsonETA.path("estimated_arrival_window_end").asText());
		
		JsonNode jsonWheres = jsonStructure.path("wheres");
		structure.getWheres().setWhereID	(jsonWheres.path("where_id").asText());
		structure.getWheres().setName		(jsonWheres.path("name").asText());
	}	
}
