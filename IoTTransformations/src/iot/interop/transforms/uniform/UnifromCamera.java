package iot.interop.transforms.uniform;

import java.text.SimpleDateFormat;

import iot.interop.logger.SystemLog;

/**
 * UniformCamera
 * This class is the uniform data structure for all IoT enabled cameras
 * 
 * @author Shameer Omar
 * @version 1.0
 */
public class UnifromCamera {
	private SystemLog unifiedThermostatLog;
	private SimpleDateFormat receivedTime;
	
	private String deviceID;
	private String deviceManufacturer;
	private String deviceVersion;
	private String deviceLocation;
	private String deviceOnLine;
	private String activityMeasured;
	private String lastUpdated;
	
	/**
	 * The constructor for the IoT camera UniformCamera. This method sets all the fields for the IoT camera. 
	 * 
	 * @param deviceID Camera device identifier (Set by OEM)
	 * @param deviceManufacturer Camera device manufacturer (Set by OEM)
	 * @param deviceVersion Camera device version. Can be firmware or software (Set by OEM)
	 * @param deviceLocation Camera device location (Set by user)
	 * @param isDeviceOnLine Camera device online status (Set by Camera)
	 * @param isActivityMeasured Camera activity measurement. Set to true if any type of activity audio or visual is detected by camera. (Set by camera)
	 */
	public UnifromCamera (String deviceID, String deviceManufacturer, String deviceVersion, String deviceLocation, String isDeviceOnLine, String isActivityMeasured) {
		unifiedThermostatLog = new SystemLog(UniformThermostat.class);
		unifiedThermostatLog.logInfo("Creating New Unified Thermostat Object");
		
		this.deviceID = deviceID;
		this.deviceManufacturer = deviceManufacturer;
		this.deviceVersion = deviceVersion;
		this.deviceLocation = deviceLocation;
		this.deviceOnLine = isDeviceOnLine;
		this.activityMeasured = isActivityMeasured;
		this.receivedTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		this.lastUpdated = updateReceivedTime();
	}
	
	/**
	 * Update the time a new transform occurred
	 * @return Date and time as a string
	 */
	private String updateReceivedTime (){
		return receivedTime.format(new java.util.Date());
	}
	
	/**
	 * @return IoT camera identifier
	 */
	public String getDeviceID (){
		return this.deviceID;
	}
	
	/**
	 * @return IoT camera manufacturer
	 */
	public String getDeviceManufacturer (){
		return this.deviceManufacturer;
	}
	
	/**
	 * @return IoT camera version
	 */
	public String getDeviceVersion (){
		return this.deviceVersion;
	}
	
	/**
	 * @return IoT camera location
	 */
	public String getDeviceLocation (){
		return this.deviceLocation;
	}
	
	/**
	 * @return IoT camera online status
	 */
	public String getDeviceOnLine (){
		return this.deviceOnLine;
	}
	
	/**
	 * @return IoT camera activity status
	 */
	public String getActivityMeasured (){
		return this.activityMeasured;
	}
	
	/**
	 * @return Last data and time of message update
	 */
	public String getLastUpdated (){
		return this.lastUpdated;
	}
}
