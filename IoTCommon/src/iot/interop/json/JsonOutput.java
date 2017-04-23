package iot.interop.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import iot.interop.logger.SystemLog;

/**
 * JsonOutput
 * This class is responsible for handling given objects and converting them into
 * JSON objects, JSON strings or JSON files.
 * 
 * @author Shameer Omar
 * @version 1.0
 */
public class JsonOutput {
	private SystemLog jsonOutputLog;
	private ObjectMapper mapper;
	private File jsonOutputFile;

	JsonInput jsonInputProcessor;
	
	/**
	 * JsonOuput constructor
	 * @param filePath The file path for any JSON files to be saved
	 */
	public JsonOutput (String filePath){
		this.jsonOutputLog = new SystemLog(JsonOutput.class);
		this.jsonOutputFile = null;
		
		// Check if user given file path is valid
		if(filePath != null){
			// User wants to save a JSON file
			this.jsonOutputFile = new File(filePath);
		}else{
			// User does not want to save a JSON file
			jsonOutputLog.logInfo("No File Path Given");
		}
		
		this.jsonInputProcessor = new JsonInput(null);
		this.mapper = new ObjectMapper();
	}
	
	/**
	 * This method converts the given object as a JSON file to the given file path
	 * @param deviceObject Object to be saved
	 * @throws IOException Throws exception if an error is encountered either during the conversion process or while trying to save the file
	 */
	public void saveToFile(Object deviceObject) throws IOException{
		jsonOutputLog.logInfo("Saving POJO to JSON File: " + jsonOutputFile.toString());
		this.mapper.writeValue(this.jsonOutputFile, deviceObject);
		jsonOutputLog.logInfo("JSON File Created");
	}
	
	/**
	 * This method converts the given object into a JSON string
	 * @param deviceObject Object to be converted
	 * @return JSON string representing the given object
	 * @throws Exception Throws exception if error is encountered during conversion process
	 */
	public String toString(Object deviceObject) throws Exception{
		jsonOutputLog.logInfo("Converting POJO to JSON String");
		
		String jsonString = this.mapper.writeValueAsString(deviceObject);
		jsonOutputLog.logDebug("Generated Json String:" + jsonString);
		
		return jsonString;
	}
	
	/**
	 * This method converted the given object into a JSON object
	 * @param deviceObject Object to be converted
	 * @return JSON object representing the given object
	 * @throws Exception Throws an exception if an error is encountered during the conversion process
	 */
	public JsonNode toJson(Object deviceObject) throws Exception{
		String jsonString = toString(deviceObject);
		JsonNode deviceJson = this.jsonInputProcessor.parseString(jsonString);
		
		return deviceJson;
	}
}
