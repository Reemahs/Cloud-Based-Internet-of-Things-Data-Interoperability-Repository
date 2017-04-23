package iot.interop.ecobeesim.data;

/**
 * Version
 * This class is the data structure for the Ecobee Thermostat version
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class Version {
	private String thermostatFirmwareVersion;
	
	public Version () {}
	
	public String getThermostatFirmwareVersion () {
		return this.thermostatFirmwareVersion;
	}
	
	public void setThermostatFirmwareVersion (String thermostatFirmwareVersion) {
		this.thermostatFirmwareVersion = thermostatFirmwareVersion;
	}
}
