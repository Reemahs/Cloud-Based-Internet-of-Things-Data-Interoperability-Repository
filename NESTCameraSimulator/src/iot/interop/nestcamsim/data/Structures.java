package iot.interop.nestcamsim.data;

/**
 * Structures
 * This class is the data structure for the NEST Thermostat Structures
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class Structures {
	private String structuresID;
	private String away;
	private String name;
	private String countryCode;
	private String postalCode;
	private String peakPeriodStartTime;
	private String peakPeriodEndTime;
	private String timeZone;
	private String rhrEnrollment;
	private ETA eta;
	private Wheres wheres;
	
	public Structures (){
		this.structuresID = null;
		this.away = null;
		this.name = null;
		this.countryCode = null;
		this.postalCode = null;
		this.peakPeriodStartTime = null;
		this.peakPeriodEndTime = null;
		this.timeZone = null;
		this.rhrEnrollment = null;
		this.eta = new ETA();
		this.wheres = new Wheres();
	}
	
	public String getStructuresID () {
		return this.structuresID;
	}

	public String getAway () {
		return this.away;
	}

	public String getName () {
		return this.name;
	}

	public String getCountryCode () {
		return this.countryCode;
	}

	public String getPostalCode () {
		return this.postalCode;
	}

	public String getPeakPeriodStartTime () {
		return this.peakPeriodStartTime;
	}

	public String getPeakPeriodEndTime () {
		return this.peakPeriodEndTime;
	}

	public String geTimeZone () {
		return this.timeZone;
	}

	public String getRHREnrollment () {
		return this.rhrEnrollment;
	}

	public ETA getETA () {
		return this.eta;
	}

	public Wheres getWheres () {
		return this.wheres;
	}
	
	public void setStructuresID (String structuresID) {
		this.structuresID = structuresID;
	}

	public void setAway (String away) {
		this.away = away;
	}

	public void setName (String name) {
		this.name = away;
	}

	public void setCountryCode (String countryCode) {
		this.countryCode = countryCode;
	}

	public void setPostalCode (String postalCode) {
		this.postalCode = postalCode;
	}

	public void setPeakPeriodStartTime (String peakPeriodStartTime) {
		this.peakPeriodStartTime = peakPeriodStartTime;
	}

	public void setPeakPeriodEndTime (String peakPeriodEndTime) {
		this.peakPeriodEndTime = peakPeriodEndTime;
	}

	public void setTimeZone (String timeZone) {
		this.timeZone = timeZone;
	}

	public void setRHREnrollment (String rhrEnrollment) {
		this.rhrEnrollment = rhrEnrollment;
	}

	public void setETA (ETA eta) {
		this.eta = eta;
	}

	public void  setWheres (Wheres where) {
		this.wheres = where;
	}

}
