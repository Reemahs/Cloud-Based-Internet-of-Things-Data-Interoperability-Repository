package iot.interop.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import iot.interop.logger.SystemLog;

/**
 * HTTPRequest
 * This class creates the HTTP requests for clients.
 * Currently only GET requests only handle single query and POST requests
 * only send JSON payload. 
 * 
 * @author Shameer Omar
 * @version 1.0
 */
public class HTTPRequest {
	private SystemLog httpRequestLogger;
	private final String USER_AGENT = "Mozilla/5.0";
	private final String JSON_CONTENT_TYPE = "application/json; charset=UTF-8";
	
	/**
	 * HTTP Request constructor
	 */
	public HTTPRequest () {
		httpRequestLogger = new SystemLog(HTTPRequest.class);
	}
	
	/**
	 * The GET request method
	 * @param server The Server URL
	 * @param requestKey The request query key
	 * @param requestValue The request query value
	 * @return Returns the response from the server as a String
	 * @throws Exception Throws exception for any errors encountered
	 */
	public String sendGet(String server, String requestKey, String requestValue) throws Exception {
		// Creates Get Request URL
		String url = server + "/?" + requestKey + "=" + requestValue;
		
		// Opens connection to server
		httpRequestLogger.logInfo("Openning Connection to " + url);
		URL targetServer = new URL(url);
		HttpURLConnection httpConnection = (HttpURLConnection) targetServer.openConnection();
		
		// Send get request to server
		httpRequestLogger.logInfo("Sending GET Request for " + requestKey + ": " + requestValue);
		httpConnection.setRequestMethod("GET");
		httpConnection.setRequestProperty("User-Agent", USER_AGENT);
		
		// Get server response code
		httpRequestLogger.logInfo("Getting Response from Server");
		int responseCode = httpConnection.getResponseCode();
		
		// Fields for building server response
		String lineBuffer;
		StringBuffer serverResponse = new StringBuffer();
		
		try{
			// Only build server response message if server response status is 200/OK
			BufferedReader serverResponseReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
			if (responseCode == HttpURLConnection.HTTP_OK){
				httpRequestLogger.logInfo("HTTP Response Code: " + responseCode + " OK");
				if ((lineBuffer = serverResponseReader.readLine()) != null){
					serverResponse.append(lineBuffer);
				}
			}
		} catch (Exception e){
			// Log error response form server
			if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
				httpRequestLogger.logInfo("HTTP Response Code: " + responseCode + " NOT FOUND");
			} else if (responseCode == HttpURLConnection.HTTP_BAD_METHOD){
				httpRequestLogger.logInfo("HTTP Response Code: " + responseCode + " METHOD NOT ALLOWED");
			} else {
				httpRequestLogger.logInfo("HTTP Response Code: " + responseCode + " Unrecognised Response");
			}
			httpRequestLogger.logError(e.toString());
		}
		
		// Recreate server response message into a single string
		String responseMessage = serverResponse.toString();
		return responseMessage;
	}
	
	/**
	 * This method is used to send JSON payloads in a POST request
	 * @param server Server URL
	 * @param jsonString JSON string to be sent to server
	 * @return Returns the response from the server as a String
	 * @throws Exception Throws exception for any errors encountered
	 */
	public String sendJSONPost(String server, String jsonString) throws Exception {
		//Open connection to the server
		httpRequestLogger.logInfo("Openning Connection to " + server);
		URL targetServer = new URL (server);
		HttpURLConnection httpConnection = (HttpURLConnection) targetServer.openConnection();
		
		// Create POST message for server
		httpRequestLogger.logInfo("Setting POST Request for JSON String");
		httpConnection.setRequestMethod("POST");
		httpConnection.setRequestProperty("User-Agent", USER_AGENT);
		httpConnection.setRequestProperty("Content-Type", JSON_CONTENT_TYPE);
		
		// Send POST message to server
		httpRequestLogger.logInfo("Sending POST Request with Payload: " + jsonString);
		httpConnection.setDoOutput(true);
		DataOutputStream requestDataOut = new DataOutputStream(httpConnection.getOutputStream());
		requestDataOut.writeBytes(jsonString);
		
		// Flush and close output connection
		requestDataOut.flush();
		requestDataOut.close();
		
		// Get the server response code
		httpRequestLogger.logInfo("Getting Response from Server");
		int responseCode = httpConnection.getResponseCode();
		
		// Fields for building server response message
		String lineBuffer;
		StringBuffer serverResponse = new StringBuffer();
		

		try{
			// Only build server response message if server response status is 200/OK
			BufferedReader serverResponseReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
			if (responseCode == HttpURLConnection.HTTP_OK){
				httpRequestLogger.logInfo("HTTP Response Code: " + responseCode + " OK");
				while ((lineBuffer = serverResponseReader.readLine()) != null){
					serverResponse.append(lineBuffer);
				}
			}
		} catch (Exception e){
			// Log error response form server
			if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
				httpRequestLogger.logInfo("HTTP Response Code: " + responseCode + " NOT FOUND");
			} else if (responseCode == HttpURLConnection.HTTP_BAD_METHOD){
				httpRequestLogger.logInfo("HTTP Response Code: " + responseCode + " METHOD NOT ALLOWED");
			} else {
				httpRequestLogger.logInfo("HTTP Response Code: " + responseCode + " Unrecognised Response");
			}
			httpRequestLogger.logError(e.toString());
		}
		
		// Recreate server response message into a single string
		String responseMessage = serverResponse.toString();
		return responseMessage;
	}	
}
