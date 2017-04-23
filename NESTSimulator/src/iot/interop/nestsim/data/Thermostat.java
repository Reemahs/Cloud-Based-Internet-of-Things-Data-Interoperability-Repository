package iot.interop.nestsim.data;

/**
 * Thermostat
 * This class is the data structure for the NEST Thermostat
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class Thermostat {
	private String device_id;
	private String locale;
	private String software_version;
	private String structure_id;
	private String name;
	private String name_long;
	private String last_connection;
	private String fan_timer_timeout;
	private String temperature_scale;
	private String hvac_mode;
	private String hvac_state;
	private String where_id;
	private String locked_temp_min_f;
	private String locked_temp_min_c;
	private String locked_temp_max_f;
	private String locked_temp_max_c;
	private String label;
	private String where_name;
	private String time_to_target;
	private String time_to_target_training;
	private String previous_hvac_mode;
	private boolean is_online;
	private boolean can_cool;
	private boolean can_heat;
	private boolean is_using_emergency_heat;
	private boolean has_fan;
	private boolean fan_timer_active;
	private boolean has_leaf;
	private boolean is_locked;
	private boolean sunlight_correction_enabled;
	private boolean sunlight_correction_active;
	private int fan_timer_duration;
	private int target_temperature_f;
	private double target_temperature_c;
	private int target_temperature_high_f;
	private double target_temperature_high_c;
	private int target_temperature_low_f;
	private double target_temperature_low_c;
	private int eco_temperature_high_f;
	private double eco_temperature_high_c;
	private int eco_temperature_low_f;
	private double eco_temperature_low_c;
	private int ambient_temperature_f;
	private double ambient_temperature_c;
	private int humidity;
	
	public Thermostat (){
		this.device_id = null;
		this.locale = null;
		this.software_version = null;
		this.structure_id = null;
		this.name = null;
		this.name_long = null;
		this.last_connection = null;
		this.fan_timer_timeout = null;
		this.temperature_scale = null;
		this.hvac_mode = null;
		this.hvac_state = null;
		this.where_id = null;
		this.locked_temp_min_f = null;
		this.locked_temp_min_c = null;
		this.locked_temp_max_f = null;
		this.locked_temp_max_c = null;
		this.label = null;
		this.where_name = null;
		this.time_to_target = null;
		this.time_to_target_training = null;
		this.previous_hvac_mode = null;
	}
	
	public void setDeviceID (String deviceID){
		this.device_id = deviceID;
	}
	
	public void setLocale (String locale){
		this.locale = locale;
	}
	
	public void setSoftwareVersion (String softwareVersion){
		this.software_version = softwareVersion;
	}
	
	public void setStructureID (String structureID){
		this.structure_id = structureID;
	}
	
	public void setName (String name){
		this.name = name;
	}
	
	public void setNameLong (String nameLong){
		this.name_long = nameLong;
	}
	
	public void setLastConnection (String lastConnection){
		this.last_connection = lastConnection;
	}
	
	public void setFanTimerTimeout (String fanTimerTimeout){
		this.fan_timer_timeout = fanTimerTimeout;
	}
	
	public void setTemperatureScale (String tempScale){
		this.temperature_scale = tempScale;
	}
	
	public void setHVACMode (String HVACMode){
		this.hvac_mode = HVACMode;
	}
	
	public void setHVACState (String HVACState){
		this.hvac_state = HVACState;
	}
	
	public void setWhereID (String whereID){
		this.where_id = whereID;
	}
	
	public void setMinLockedTempF (String minLockedTempF){
		this.locked_temp_min_f = minLockedTempF;
	}
	
	public void setMinLockedTempC (String minLockedTempC){
		this.locked_temp_min_c = minLockedTempC;
	}
	
	public void setMaxLockedTempF (String maxLockedTempF){
		this.locked_temp_max_f = maxLockedTempF;
	}	
	
	public void setMaxLockedTempC (String maxLockedTempC){
		this.locked_temp_max_c = maxLockedTempC;
	}

	public void setLabel (String label){
		this.label = label;
	}

	public void setWhereName (String whereName){
		this.where_name = whereName;
	}
	
	public void setTimeToTarget (String timeToTarget){
		this.time_to_target = timeToTarget;
	}
	
	public void setTimeToTargetTraining (String timeToTargetTraining){
		this.time_to_target_training = timeToTargetTraining;
	}
	
	public void setPreviousHVACModes (String previousVHACMode){
		this.previous_hvac_mode = previousVHACMode;
	}

	public void setOnlineStatus (boolean onlineStatus){
		this.is_online = onlineStatus;
	}
	
	public void setCoolingAvailablity (boolean coolingAvailable){
		this.can_cool = coolingAvailable;
	}
	
	public void setHeatingAvailability (boolean heatingAvailable){
		this.can_heat = heatingAvailable;
	}
	
	public void setEmergencyHeatStatus (boolean emergencyHeatStatus){
		this.is_using_emergency_heat = emergencyHeatStatus;
	}
	
	public void setFanAvailabilty (boolean fanAvailable){
		this.has_fan = fanAvailable;
	}
	
	public void setFanActivityState (boolean fanActive){
		this.fan_timer_active = fanActive;
	}
	
	public void setLeaf (boolean leaf){
		this.has_leaf = leaf;
	}
	
	public void setLockStatus (boolean lockStatus){
		this.is_locked = lockStatus;
	}
	
	public void setSunlightEnabled (boolean sunLightEnabled){
		this.sunlight_correction_enabled = sunLightEnabled;
	}
	
	public void setSunlightActive (boolean sunLightActive){
		this.sunlight_correction_active = sunLightActive;
	}
	
	public void setFanTimerDuration (int fanTimer){
		this.fan_timer_duration =  fanTimer;
	}
	
	public void setTargetTemperatureF (int targetTempF){
		this.target_temperature_f = targetTempF;
	}
	
	public void setTargetTemperatureC (double targetTempC){
		this.target_temperature_c = targetTempC; 
	}
	
	public void setHighTargetTemperatureF (int highTargetTempF) {
		this.target_temperature_high_f = highTargetTempF;
	}
	
	public void setHighTargetTemperatureC (double highTargetTempC) {
		this.target_temperature_high_c = highTargetTempC;
	}
	
	public void setLowTargetTemperatureF (int lowTargetTempF){
		this.target_temperature_low_f = lowTargetTempF;
	}
	
	public void setLowTargetTemperatureC (double lowTargetTempC){
		this.target_temperature_low_c = lowTargetTempC;
	}
	
	public void setEcoHighTemperatureF (int ecoHighTempF){
		this.eco_temperature_high_f = ecoHighTempF;
	}
	
	public void setEcoHighTemperatureC (double ecoHighTempC){
		this.eco_temperature_high_c = ecoHighTempC;
	}
	
	public void setEcoLowTemperatureF (int ecoLowTempF){
		this.eco_temperature_low_f = ecoLowTempF;
	}
	
	public void setEcoLowTemperatureC (double ecoLowTempC){
		this.eco_temperature_low_c = ecoLowTempC;
	}
	
	public void setAmbientTemperatureF (int ambientTempF){
		this.ambient_temperature_f = ambientTempF;
	}
	
	public void setAmbientTemperatureC (double ambientTempC){
		this.ambient_temperature_c = ambientTempC;
	}
	
	public void setHumidity(int humidity){
		this.humidity = humidity;
	}
	
	public String getDeviceID (){
		return this.device_id;
	}
	
	public String getLocale (){
		return this.locale;
	}
	
	public String getSoftwareVersion (){
		return this.software_version;
	}
	
	public String getStructureID (){
		return this.structure_id;
	}
	
	public String getName (){
		return this.name;
	}
	
	public String getNameLong (){
		return this.name_long;
	}
	
	public String getLastConnection (){
		return this.last_connection;
	}
	
	public String getFanTimerTimeout (){
		return this.fan_timer_timeout;
	}
	
	public String getTemperatureScale (){
		return this.temperature_scale;
	}
	
	public String getHVACMode (){
		return this.hvac_mode;
	}
	
	public String getHVACState (){
		return this.hvac_state;
	}
	
	public String getWhereID (){
		return this.where_id;
	}
	
	public String getMinLockedTempF (){
		return this.locked_temp_min_f;
	}
	
	public String getMinLockedTempC (){
		return locked_temp_min_c;
	}
	
	public String getMaxLockedTempF (){
		return locked_temp_max_f;
	}	
	
	public String getMaxLockedTempC (){
		return this.locked_temp_max_c;
	}

	public String getLabel (){
		return this.label;
	}

	public String getWhereName (){
		return this.where_name;
	}
	
	public String getTimeToTarget (){
		return this.time_to_target;
	}
	
	public String getTimeToTargetTraining (){
		return this.time_to_target_training;
	}
	
	public String getPreviousHVACModes (){
		return this.previous_hvac_mode;
	}

	public boolean getOnlineStatus (){
		return this.is_online;
	}
	
	public boolean getCoolingAvailablity (){
		return this.can_cool;
	}
	
	public boolean getHeatingAvailability (){
		return this.can_heat;
	}
	
	public boolean getEmergencyHeatStatus (){
		return this.is_using_emergency_heat;
	}
	
	public boolean getFanAvailabilty (){
		return this.has_fan;
	}
	
	public boolean getFanActivityState (){
		return this.fan_timer_active;
	}
	
	public boolean getLeaf (){
		return this.has_leaf;
	}
	
	public boolean getLockStatus (){
		return this.is_locked;
	}
	
	public boolean getSunlightEnabled (){
		return this.sunlight_correction_enabled;
	}
	
	public boolean getSunlightActive (){
		return this.sunlight_correction_active;
	}
	
	public int getFanTimerDuration (){
		return this.fan_timer_duration;
	}
	
	public int getTargetTemperatureF (){
		return this.target_temperature_f;
	}
	
	public double getTargetTemperatureC (){
		return this.target_temperature_c;
	}
	
	public int getHighTargetTemperatureF () {
		return this.target_temperature_high_f;
	}
	
	public double getHighTargetTemperatureC () {
		return this.target_temperature_high_c;
	}
	
	public int getLowTargetTemperatureF (){
		return this.target_temperature_low_f;
	}
	
	public double getLowTargetTemperatureC (){
		return this.target_temperature_low_c;
	}
	
	public int getEcoHighTemperatureF (){
		return this.eco_temperature_high_f;
	}
	
	public double getEcoHighTemperatureC (){
		return this.eco_temperature_high_c;
	}
	
	public int getEcoLowTemperatureF (){
		return this.eco_temperature_low_f;
	}
	
	public double getEcoLowTemperatureC (){
		return this.eco_temperature_low_c;
	}
	
	public int getAmbientTemperatureF (){
		return this.ambient_temperature_f;
	}
	
	public double getAmbientTemperatureC (){
		return this.ambient_temperature_c;
	}
	
	public int getHumidity(){
		return this.humidity;
	}	
}
