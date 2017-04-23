package iot.interop.transforms.uniform;

import java.text.SimpleDateFormat;

import iot.interop.logger.SystemLog;

/**
 * UniformThermostat
 * This class is the uniform data structure for all IoT enabled thermostats
 * 
 * @author Shameer Omar
 * @version 1.0
 */
public class UniformThermostat {
	private SystemLog unifiedThermostatLog;
	private SimpleDateFormat receivedTime;
	
	private String deviceID;
	private String deviceManufacturer;
	private String deviceVersion;
	private String deviceLocation;
	private String deviceMode;
	private double ambientTemp;
	private double targetTemp;
	private double ambientHumidity;
	private String lastUpdated;
	
	/**
	 * The constructor for the IoT thermostat UniformThermostat. This method sets all the fields for the IoT Thermostat. 
	 * 
	 * @param deviceID Camera device identifier (Set by OEM)
	 * @param deviceManufacturer Camera device manufacturer (Set by OEM)
	 * @param deviceVersion Camera device version. Can be firmware or software (Set by OEM)
	 * @param deviceLocation Camera device location (Set by user)
	 * @param ambientTempC
	 * @param targetTempC
	 * @param ambientHumidity
	 */
	public UniformThermostat (String deviceID, String deviceManufacturer, String deviceVersion, String deviceLocation, String deviceMode, double ambientTempC, double targetTempC, double ambientHumidity) {
		unifiedThermostatLog = new SystemLog(UniformThermostat.class);
		unifiedThermostatLog.logInfo("Creating New Unified Thermostat Object");
		
		this.receivedTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		
		this.deviceID = deviceID;
		this.deviceManufacturer = deviceManufacturer;
		this.deviceVersion = deviceVersion;
		this.deviceLocation = deviceLocation;
		this.deviceMode = deviceMode;
		this.ambientTemp = ambientTempC;
		this.targetTemp = targetTempC;
		this.ambientHumidity = ambientHumidity;
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
	 * @return Thermostat identifier
	 */
	public String getDeviceID (){
		return this.deviceID;
	}

	/**
	 * @return Thermostat manufacturer
	 */
	public String getDeviceManufacturer (){
		return this.deviceManufacturer;
	}
	
	/**
	 * @return Thermostat device version
	 */
	public String getDeviceVersion (){
		return this.deviceVersion;
	}
	
	/**
	 * @return Thermostat location
	 */
	public String getDeviceLocation (){
		return this.deviceLocation;
	}
	
	/**
	 * @return Current thermostat mode
	 */
	public String getDeviceMode (){
		return this.deviceMode;
	}
	
	/**
	 * @return Current temperature measured thermostat in celsius
	 */
	public double getAmbientTemp (){
		return this.ambientTemp;
	}
	
	/**
	 * @return Current target temperature for thermostat in celsius
	 */
	public double getTargetTemp (){
		return this.targetTemp;
	}
	
	/**
	 * @return Current humidity measured by thermostat
	 */
	public double getAmbientHumidity (){
		return this.ambientHumidity;
	}
	
	/**
	 * @return Last data and time of message update
	 */
	public String getLastUpdated (){
		return this.lastUpdated;
	}
}
