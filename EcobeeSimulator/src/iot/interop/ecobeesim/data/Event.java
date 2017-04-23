package iot.interop.ecobeesim.data;

/**
 * Event
 * This class is the data structute for the Ecobee Thermostat event
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class Event {
	private String 	type;
	private String 	name;
	private boolean running;
	private String 	startDate;
	private String 	startTime;
	private String 	endDate;
	private String 	endTime;
	private boolean isOccupied;
	private boolean isCoolOff;
	private boolean isHeatOff;
	private int coolHoldTemp;
	private int heatHoldTemp;
	private String 	fan;
	private String 	vent;
	private int ventilatorMinOnTime;
	private boolean isOptional;
	private boolean isTemperatureRelative;
	private int coolRelativeTemp;
	private int heatRelativeTemp;
	private boolean isTemperatureAbsolute;
	private int dutyCyclePercentage;
	private int fanMinOnTime;
	private boolean occupiedSensorActive;
	private boolean unoccupiedSensorActive;

	public Event () {}

	public String getType(){
		return this.type;
	}

	public String getName(){
		return this.name;
	}

	public boolean getRunning(){
		return this.running;
	}

	public String getStartDate(){
		return this.startDate;
	}

	public String getStartTime(){
		return this.startTime;
	}

	public String getEndDate(){
		return this.endDate;
	}

	public String getEndTime(){
		return this.endTime;
	}

	public boolean getIsOccupied(){
		return this.isOccupied;
	}

	public boolean getIsCoolOff(){
		return this.isCoolOff;
	}

	public boolean getIsHeatOff(){
		return this.isHeatOff;
	}

	public int getCoolHoldTemp(){
		return this.coolHoldTemp;
	}

	public int getHeatHoldTemp(){
		return this.heatHoldTemp;
	}

	public String getFan(){
		return this.fan;
	}

	public String getVent(){
		return this.vent;
	}

	public int getVentilatorMinOnTime(){
		return this.ventilatorMinOnTime;
	}

	public boolean getIsOptional(){
		return this.isOptional;
	}

	public boolean getIsTemperatureRelative(){
		return this.isTemperatureRelative;
	}

	public int getCoolRelativeTemp(){
		return this.coolRelativeTemp;
	}

	public int getHeatRelativeTemp(){
		return this.heatRelativeTemp;
	}

	public boolean getIsTemperatureAbsolute(){
		return this.isTemperatureAbsolute;
	}

	public int getDutyCyclePercentage(){
		return this.dutyCyclePercentage;
	}

	public int getFanMinOnTime(){
		return this.fanMinOnTime;
	}

	public boolean getOccupiedSensorActive(){
		return this.occupiedSensorActive;
	}

	public boolean getUnoccupiedSensorActive(){
		return this.unoccupiedSensorActive;
	}

	public void setType(String type){
		this.type = type;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setRunning(boolean running){

		this.running = running;
	}

	public void setStartDate(String startDate){
		this.startDate = startDate;
	}

	public void setStartTime(String startTime){
		this.startTime = startTime;
	}

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	public void setEndTime(String endTime){
		this.endTime = endTime;
	}

	public void setIsOccupied(boolean isOccupied){
		this.isOccupied = isOccupied;
	}

	public void setIsCoolOff(boolean isCoolOff){
		this.isCoolOff = isCoolOff;
	}

	public void setIsHeatOff(boolean isHeatOff){
		this.isHeatOff = isHeatOff;
	}

	public void setCoolHoldTemp(int coldHoldTemp){
		this.coolHoldTemp = coldHoldTemp;
	}

	public void setHeatHoldTemp(int heatHoldTemp){
		this.heatHoldTemp = heatHoldTemp;
	}

	public void setFan(String fan){
		this.fan = fan;
	}

	public void setVent(String vent){
		this.vent = vent;
	}

	public void setVentilatorMinOnTime(int ventilatorMinOnTime){
		this.ventilatorMinOnTime = ventilatorMinOnTime;
	}

	public void setIsOptional(boolean isOptional){
		this.isOptional = isOptional;
	}

	public void setIsTemperatureRelative(boolean isTemperatureRelative){
		this.isTemperatureRelative = isTemperatureRelative;
	}

	public void setCoolRelativeTemp(int coolRelativeTemp){
		this.coolRelativeTemp = coolRelativeTemp;
	}

	public void setHeatRelativeTemp(int heatRelativeTemp){
		this.heatRelativeTemp = heatRelativeTemp;
	}

	public void setIsTemperatureAbsolute(boolean isTemperatureAbsolute){
		this.isTemperatureAbsolute = isTemperatureAbsolute;
	}

	public void setDutyCyclePercentage(int dutyCyclePercentage){
		this.dutyCyclePercentage = dutyCyclePercentage;
	}

	public void setFanMinOnTime(int fanMinOnTime){
		this.fanMinOnTime = fanMinOnTime;
	}

	public void setOccupiedSensorActive(boolean occupiedSensorActive){
		this.occupiedSensorActive = occupiedSensorActive;
	}

	public void setUnoccupiedSensorActive(boolean unoccupiedSensorActive){
		this.unoccupiedSensorActive = unoccupiedSensorActive;
	}

}
