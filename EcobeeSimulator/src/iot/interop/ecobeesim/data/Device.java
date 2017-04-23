package iot.interop.ecobeesim.data;

/**
 * Device
 * This class is the data structute for the Ecobee Thermostat device
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class Device {
	private int deviceID;
	private String name;

	public Device () {}

	public int getDeviceID () {
		return this.deviceID;
	}

	public String getName () {
		return this.name;
	}

	public void setDeviceID (int deviceID){
		this.deviceID = deviceID;
	}

	public void setName (String name){
		this.name = name;
	}
}
