package iot.interop.nestsim.data;

/**
 * Structure
 * This class is the data structure for the NEST Thermostat Structure
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class Structure {
	private String structure_id;
	private String away;
	private String name;
	private String country_code;
	private String postal_code;
	private String peak_period_start_time;
	private String peak_period_end_time;
	private String time_zone;
	private boolean rhr_enrollment;
	private ETA eta;
	private Where wheres;
	
	public Structure (){
		structure_id = null;
		away = null;
		country_code = null;
		postal_code = null;
		peak_period_start_time = null;
		peak_period_end_time = null;
		time_zone = null;
		eta = new ETA();
		wheres = new Where();
	}

	public void setStructureID(String structureID){
		this.structure_id = structureID;
	}
	
	public void setAway(String away){
		this.away = away;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setCountryCode(String countryCode){
		this.country_code = countryCode;
	}
	
	public void setPostalCode(String postalCode){
		this.postal_code = postalCode;
	}

	public void setPeakPeriodStartTime(String peakPeriodStartTime){
		this.peak_period_start_time = peakPeriodStartTime;
	}

	public void setPeakPeriodEndTime(String peakPeriodEndTime){
		this.peak_period_end_time = peakPeriodEndTime;
	}

	public void setTimeZone(String timeZone){
		this.time_zone = timeZone;
	}
	
	public void setRHREnrollment(boolean RHREnrollment){
		this.rhr_enrollment = RHREnrollment;
	}

	public String getStructureID(){
		return this.structure_id;
	}
	
	public String getAway(){
		return this.away;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getCountryCode(){
		return this.country_code;
	}
	
	public String getPostalCode(){
		return this.postal_code;
	}

	public String getPeakPeriodStartTime(){
		return this.peak_period_start_time;
	}

	public String getPeakPeriodEndTime(){
		return this.peak_period_end_time;
	}

	public String getTimeZone(){
		return this.time_zone;
	}
	
	public boolean getRHREnrollment(){
		return this.rhr_enrollment;
	}

	public ETA getETA(){
		return this.eta;
	}
	
	public Where getWheres(){
		return this.wheres;
	}
}
