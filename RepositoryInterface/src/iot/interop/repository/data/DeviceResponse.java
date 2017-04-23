package iot.interop.repository.data;

/**
 * DeviceResponse
 * This class is the data structure used to contain the response from the MySQL database
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class DeviceResponse {
	String deviceID;
	String transformationClass;
	
	/**
	 * DeviceResponse constructor
	 * @param deviceID The querying device identifier
	 * @param queryResponse The reponse frm the MySQL database
	 */
	public DeviceResponse (String deviceID, String queryResponse){
		this.deviceID = deviceID;
		this.transformationClass = queryResponse;
	}
	
	/**
	 * @return The transformation class name from the MySQL database
	 */
	public String getTransformationClass (){
		return this.transformationClass;
	}
	
	/**
	 * @return The querying device identifier
	 */
	public String getDeviceID (){
		return this.deviceID;
	}
}
