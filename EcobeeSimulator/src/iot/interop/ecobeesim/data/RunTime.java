package iot.interop.ecobeesim.data;

/**
 * Runtime
 * This class is the data structure for the Ecobee Thermostat Runtime
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class RunTime {
	private String runtimeRev;
	private boolean connected;
	private String firstConnected;
	private String disconnectDateTime; 
	private String lastModified;
	private String runtimeDate;
	private int runtimeInterval;
	private int actualTemperature;
	private int actualHumidity;
	private int desiredHeat;
	private int desiredCool;
	private int desiredHumidity;
	private int desiredDehumidity;
	private String desiredFanMode;
	
	public RunTime () {}
	
	public String getRuntimeRev (){
		return this.runtimeRev;
	}

	public boolean getConnected (){
		return this.connected;
	}

	public String getFirstConnected (){
		return this.firstConnected;
	}

	public String getDiscounnectedDateTime (){
		return this.disconnectDateTime;
	}

	public String getLastModified (){
		return this.lastModified;
	}

	public String getRuntimeDate (){
		return this.runtimeDate;
	}

	public int getRuntimeInterval (){
		return this.runtimeInterval;
	}

	public int getActualTemperature (){
		return this.actualTemperature;
	}

	public int getActualHumidity (){
		return this.actualHumidity;
	}

	public int getDesiredHeat (){
		return this.desiredHeat;
	}

	public int getDesiredCool (){
		return this.desiredCool;
	}

	public int getDesiredHumidity (){
		return this.desiredHumidity;
	}

	public int getDesiredDehumidity (){
		return this.desiredDehumidity;
	}

	public String getDesiredFanMode (){
		return this.desiredFanMode;
	}

	public void setRuntimeRev (String runtimeRev){
		this.runtimeRev = runtimeRev;
	}

	public void setConnected (boolean connected){
		this.connected = connected;
	}

	public void setFirstConnected (String firstConnected){
		this.firstConnected = firstConnected;
	}

	public void setDiscounnectedDateTime (String disconnectedDatTime){
		this.disconnectDateTime = disconnectedDatTime;
	}

	/**
	 * @param lastModified New last modified date and time
	 */
	public void setLastModified (String lastModified){
		this.lastModified = lastModified;
	}
	
	public void setRuntimeDate (String runtimeDate){
		this.runtimeDate = runtimeDate;
	}

	public void setRuntimeInterval (int runtimeInterval){
		this.runtimeInterval = runtimeInterval;
	}

	public void setActualTemperature (int actualTemperature){
		this.actualTemperature = actualTemperature;
	}

	public void setActualHumidity (int actualHumidity){
		this.actualHumidity = actualHumidity;
	}

	public void setDesiredHeat (int desiredHeat){
		this.desiredHeat = desiredHeat;
	}

	public void setDesiredCool (int desiredCool){
		this.desiredCool = desiredCool;
	}

	public void setDesiredHumidity (int desiredHumidity){
		this.desiredHumidity = desiredHumidity;
	}

	public void setDesiredDehumidity (int desiredDehumidity){
		this.desiredDehumidity = desiredDehumidity;
	}

	public void setDesiredFanMode (String desiredFanMode){
		this.desiredFanMode = desiredFanMode;
	}
}
