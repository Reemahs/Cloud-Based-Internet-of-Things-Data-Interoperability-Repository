package iot.interop.nestcamsim.sim;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.JsonNode;

import iot.interop.http.HTTPRequest;
import iot.interop.json.JsonInput;
import iot.interop.json.JsonOutput;
import iot.interop.logger.SystemLog;
import iot.interop.nestcamsim.data.SimDevice;
import iot.interop.nestcamsim.json.JsonParser;

/**
 * NestCamSimulator
 * Main class for NEST Camera Simulator
 * 
 * This class handles the parsing of the JSON device files, HTTP communication to the hub and the simulation dynamics.
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class NestCamSimulator {
	//Nano-second constant used for simulator timing sequences
	final static long NANOSEC_PER_SEC =  1000l*1000*1000;
	
	static SystemLog nestSimLog = new SystemLog(NestCamSimulator.class);
	
	/**
	 * Main method NEST Camera Simulator
	 * @param args 0) Device File Path 1) Device File Name 2) Hub URL
	 */
	public static void main (String[] args){	
		SimDevice simulatedDevice = new SimDevice();
		
		String originalFile = args[0] + "/" + args[1];
		
		//Read in device file and convert to JsonNode
		JsonInput jsonInput = new JsonInput(originalFile);
		JsonParser jsonParser = new JsonParser();
		JsonNode rawJsonObject;
		
		nestSimLog.logInfo("Reading JSON file " + args[1]);
		try{
			rawJsonObject = jsonInput.readFile();
			
			nestSimLog.logInfo("Parsing Raw JSON Object into Simulator Object");
			
			nestSimLog.logInfo("Parsing metadata");
			jsonParser.parseMetadata(rawJsonObject, simulatedDevice.getMetadata());
			
			nestSimLog.logInfo("Parsing camera");
			jsonParser.parseCameras(rawJsonObject, simulatedDevice.getCameras());
			
			nestSimLog.logInfo("Parsing structure");
			jsonParser.parseStructure(rawJsonObject, simulatedDevice.getStructures());
			
			HTTPRequest jsonPOST = new HTTPRequest();
			
			nestSimLog.logInfo("Starting Simulation");
			nestSimLog.logInfo("First Transmission to Hub");
			toHub(simulatedDevice, jsonPOST, args[2]);
			
			//Simulator variables to be updated
			boolean hasSound = false;
			boolean hasMotion = false;
			boolean hasPerson = false;
			
			//Device simulator that will run for five minutes and send an updated device message to the hub every one minute
			long simulationStartTime = System.nanoTime();
			nestSimLog.logInfo("Starting Simulation");
			while ((System.nanoTime()-simulationStartTime) < 5*60*NANOSEC_PER_SEC){
				// Required for debugging
				hasSound = simulatedDevice.getCameras().getLastEvent().getHasSound();
				hasMotion = simulatedDevice.getCameras().getLastEvent().getHasMotion();
				hasPerson = simulatedDevice.getCameras().getLastEvent().getHasPerson();
				nestSimLog.logDebug(hasSound + " " + hasMotion + " " + hasPerson);
				
				//Wait one minute before sending
				Thread.sleep(60000);
				
				//Update device, create message and send to hub.
				nestSimLog.logInfo("Updating Simulation");
				simulatedDevice.getCameras().getLastEvent().setHasSound(!hasSound);
				simulatedDevice.getCameras().getLastEvent().setHasMotion(hasMotion);
				simulatedDevice.getCameras().getLastEvent().setHasPerson(!hasPerson);
				toHub(simulatedDevice, jsonPOST, args[2]);
				
				// Required for debugging
				hasSound = simulatedDevice.getCameras().getLastEvent().getHasSound();
				hasMotion = simulatedDevice.getCameras().getLastEvent().getHasMotion();
				hasPerson = simulatedDevice.getCameras().getLastEvent().getHasPerson();
				nestSimLog.logDebug(hasSound + " " + hasMotion + " " + hasPerson);
				
				//Wait one minute before sending
				Thread.sleep(60000);
				
				//Update device, create message and send to hub.
				nestSimLog.logInfo("Updating Simulation");
				simulatedDevice.getCameras().getLastEvent().setHasSound(hasSound);
				simulatedDevice.getCameras().getLastEvent().setHasMotion(!hasMotion);
				simulatedDevice.getCameras().getLastEvent().setHasPerson(hasPerson);
				toHub(simulatedDevice, jsonPOST, args[2]);
			}
			nestSimLog.logInfo("Simulation Over");
					
			// Save the new device to a file
			toFile(simulatedDevice, args[0], args[1]);
		}catch (Exception e){
			nestSimLog.logError(e.toString());
		}
	}
	
	/**
	 * This method handles the communication to the hub
	 * @param deviceObject The simulated device object to be sent to the hub
	 * @param postOutput The HTTP request type stating that a JSON message is being sent
	 * @param hubURL The URL for the Hub
	 * @throws Exception Throws exception for Object-to-JSONString conversion or HTTP connection error with hub
	 */
	private static void toHub (SimDevice deviceObject, HTTPRequest postOutput, String hubURL) throws Exception{
		JsonOutput jsonStringProcessor = new JsonOutput(null);
		
		nestSimLog.logInfo("Converting Simulated Device to String");
		String toHub = jsonStringProcessor.toString(deviceObject);
		nestSimLog.logDebug("String being sent to Hub" + toHub);
		
		nestSimLog.logInfo("Sending Simulated Device JSON String to Hub at: " + hubURL);
		String hubResponse = postOutput.sendJSONPost(hubURL, toHub);
		nestSimLog.logInfo("Response from Hub: " + hubResponse);		
	}
	
	/**
	 * This method handles saving the final simulated device object to a file
	 * @param deviceObject The simulated device object to be saved
	 * @param filePath The file path for the new file
	 * @param fileName The file name for the new file
	 * @throws IOException Throws exception for any error in creating or saving the file
	 */
	private static void toFile (SimDevice deviceObject, String filePath, String fileName) throws IOException{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		String newFileName = "_simulated_" + timeStamp + ".json";
		newFileName = fileName.replace(".json",  newFileName);
		nestSimLog.logInfo("Simulated Device Being Saved to: " + filePath + "/" + fileName);
		
		JsonOutput jsonOutput = new JsonOutput(filePath + "/" + newFileName);
		
		nestSimLog.logInfo("Saving Simulated Device to: " + newFileName);
		jsonOutput.saveToFile(deviceObject);
	}
}

