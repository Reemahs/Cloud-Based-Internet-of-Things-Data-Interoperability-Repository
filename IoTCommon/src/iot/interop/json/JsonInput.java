package iot.interop.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import iot.interop.logger.SystemLog;

/**
 * JsonInput
 * This class is responsible for handling the JSON input functions. 
 * This class creates JSON objects by from JSON files and from JSON strings.
 * 
 * @author Shameer Omar
 * @version 1.0
 */
public class JsonInput {
	private SystemLog jsonIOLog = new SystemLog(JsonInput.class);
	private ObjectMapper mapper = new ObjectMapper();
	private File jsonInputFile = null;
	private JsonNode jsonObject;
	
	/**
	 * JsonInput constructor
	 * @param filePath JSON file to be read
	 */
	public JsonInput (String filePath){
		if (filePath != null){
			// If user is reading input from a file
			jsonIOLog.logInfo("File Path Given: " + filePath.toString());
			this.jsonInputFile = new File(filePath);
		}else{
			// If the user is not reading from a file
			jsonIOLog.logInfo("No File Given");
		}
	}
	
	/**
	 * This method will read a JSON file and create the appropriate JSON object
	 * @return The JSON object from the file
	 * @throws IOException Throws exception for errors encountered from either reading the file or converting the file into a JSON object
	 */
	public JsonNode readFile () throws IOException{
		jsonIOLog.logInfo("Converting File Contents to JSON Object. File: " + jsonInputFile.toString());
		this.jsonObject = mapper.readTree(this.jsonInputFile);
		
		return jsonObject;
	}
	
	/**
	 * This method will parse a JSON string into a JSON object
	 * @param jsonString JSON string to be parsed
	 * @return The JSON object from the string
	 * @throws Exception Throws exception for errors encountered while converting the file into a JSON object
	 */
	public JsonNode parseString (String jsonString) throws Exception{
		jsonIOLog.logInfo("Converting Given String to JSON Object");
		this.jsonObject = mapper.readTree(jsonString);
		
		return this.jsonObject;
	}
}
