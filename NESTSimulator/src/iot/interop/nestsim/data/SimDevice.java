package iot.interop.nestsim.data;

/**
 * SimDevice
 * This class is the data structure for the NEST Thermostat simulator Device
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class SimDevice {
	private Metadata metadata;
	private Thermostat thermostat;
	private Structure structure;
	
	public SimDevice (){
		this.metadata = new Metadata();
		this.thermostat = new Thermostat();
		this.structure = new Structure();
	}
	
	public Metadata getMetadata (){
		return this.metadata;
	}
	
	public Thermostat getThermostat (){
		return this.thermostat;
	}
	
	public Structure getStructure (){
		return this.structure;
	}
}
