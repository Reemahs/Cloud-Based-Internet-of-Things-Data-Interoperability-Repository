package iot.interop.ecobeesim.data;

/**
 * Climate
 * This class is the data structure for the Ecobee Thermostat climate
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class Climate {
	private String 	name;
	private String 	climateRef;
	private boolean isOccupied;
	private boolean	isOptimized;
	private String	coolFan;
	private String	heatFan;
	private String	vent;
	private int		ventilatorMinOnTime;
	private String	owner;
	private String 	type;
	private int		colour;
	private int		coolTemp;
	private int		heatTemp;

	public Climate () {}
	
	public String getName (){
		return this.name;
	}
	
	public String getClimateRef (){
		return this.climateRef;
	}
	
	public boolean getIsOccupied (){
		return this.isOccupied;
	}

	public boolean getIsOptimized (){
		return this.isOptimized;
	}
	
	public String getCoolFan (){
		return this.coolFan;
	}

	public String getHeatFan (){
		return this.heatFan;
	}
	
	public String getVent (){
		return this.vent;
	}

	public int getVentilatorMinOnTime (){
		return this.ventilatorMinOnTime;
	}

	public String getOwner (){
		return this.owner;
	}

	public String getType (){
		return this.type;
	}

	public int getColour (){
		return this.colour;
	}

	public int getCoolTemp (){
		return this.coolTemp;
	}

	public int getHeatTemp (){
		return this.heatTemp;
	}

	public void setName (String name){
		 this.name = name;
	}

	public void setClimateRef (String climateRef){
		 this.climateRef = climateRef;
	}

	public void setIsOccupied (boolean isOccupied){
		 this.isOccupied = isOccupied;
	}

	public void setIsOptimized (boolean isOptimized){
		 this.isOptimized = isOptimized;
	}

	public void setCoolFan (String coolFan){
		 this.coolFan = coolFan;
	}

	public void setHeatFan (String heatFan){
		 this.heatFan = heatFan;
	}
	
	public void setVent (String vent){
		 this.vent = vent;
	}
	
	public void setVentilatorMinOnTime (int ventilatorMinOnTime){
		 this.ventilatorMinOnTime = ventilatorMinOnTime;
	}

	public void setOwner (String owner){
		 this.owner = owner;
	}

	public void setType (String type){
		this.type = type;
	}

	public void setColour (int colour){
		 this.colour = colour;
	}

	public void setCoolTemp (int coolTemp){
		this.coolTemp = coolTemp;
	}

	public void setHeatTemp (int heatTemp){
		this.heatTemp = heatTemp;
	}
	
}


