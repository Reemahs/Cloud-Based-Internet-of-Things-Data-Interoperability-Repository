package iot.interop.ecobeesim.data;

/**
 * SimDevice
 * This class is the data structure for the Ecobee Thermostat simulator Device
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class SimDevice {
	private Climate climate;
	private Event event;
	private Thermostat thermostat;
	private User user;
	
	public SimDevice () {
		this.climate = new Climate();
		this.event = new Event();
		this.thermostat = new Thermostat();
		this.user = new User();
	}
	
	public Climate getClimate (){
		return this.climate;
	}
	
	public Event getEvent (){
		return this.event;
	}

	public Thermostat getThermostat (){
		return this.thermostat;
	}

	public User getUser (){
		return this.user;
	}
}
