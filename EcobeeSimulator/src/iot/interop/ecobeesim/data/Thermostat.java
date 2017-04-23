package iot.interop.ecobeesim.data;

/**
 * Thermostat
 * This class is the data structure for the Ecobee thermostat
 * 
 * This class only contains Get and Set methods for the class fields. Objects instantiated within this class only have Get methods
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */

public class Thermostat {
	private String identifier;
	private String name;
	private String thermostatRev;
	private boolean isRegistered;
	private String modelNumber;
	private String brand;
	private String features;
	private String lastModified;
	private String thermostatTime;
	private String utcTime;
	private String equipmentStatus;
	private RunTime runTime;
	private Device device;
	private Location location;
	private HouseDetails houseDetails;
	private Version version;

	public Thermostat () {
		this.runTime = new RunTime();
		this.device = new Device();
		this.location = new Location();
		this.houseDetails = new HouseDetails();
		this.version = new Version();
	}

	public String getIdentifier (){
		return this.identifier;
	}

	public String getName (){
		return this.name;
	}

	public String getThermostatRev (){
		return this.thermostatRev; 
	}

	public boolean getIsRegistered (){
		return this.isRegistered; 
	}

	public String getModelNumber (){
		return this.modelNumber; 
	}

	public String getBrand (){
		return this.brand; 
	}

	public String getFeatures (){
		return this.features; 
	}

	public String getLastModified (){
		return this.lastModified; 
	}

	public String getThermostatTime (){
		return this.thermostatTime; 
	}

	public String getUTCTime (){
		return this.utcTime; 
	}

	public String getEquipmentStatus (){
		return this.equipmentStatus; 
	}

	public RunTime getRunTime (){
		return this.runTime; 
	}

	public Device getDevice (){
		return this.device; 
	}

	public Location getLocation (){
		return this.location; 
	}

	public HouseDetails getHouseDetails (){
		return this.houseDetails; 
	}

	public Version getVersion (){
		return this.version; 
	}

	public void setIdentifier (String identifier){
		this.identifier = identifier;
	}

	public void setName (String name){
		this.name = name;
	}

	public void setThermostatRev (String thermostatRev){
		this.thermostatRev = thermostatRev; 
	}

	public void setIsRegistered (boolean isRegistered){
		this.isRegistered = isRegistered; 
	}

	public void setModelNumber (String modelNumber){
		this.modelNumber = modelNumber; 
	}

	public void setBrand (String brand){
		this.brand = brand; 
	}

	public void setFeatures (String features){
		this.features = features; 
	}

	public void setLastModified (String lastModified){
		this.lastModified = lastModified; 
	}

	public void setThermostatTime (String thermostatTime){
		this.thermostatTime = thermostatTime; 
	}

	public void setUTCTime (String utcTime){
		this.utcTime = utcTime; 
	}

	public void setEquipmentStatus (String equipmentStatus){
		this.equipmentStatus = equipmentStatus; 
	}

}
