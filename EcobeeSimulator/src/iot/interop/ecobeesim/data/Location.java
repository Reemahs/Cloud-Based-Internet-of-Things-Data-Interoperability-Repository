package iot.interop.ecobeesim.data;

/**
 * Location
 * This class is the data structure for the Ecobee Thermostat location
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class Location {
	private int timeZoneOffsetMinutes;
	private String timeZone;
	private boolean isDaylightSaving;
	private String streetAddress;
	private String city;
	private String provinceState;
	private String country;
	private String postalCode;
	private String phoneNumber;
	
	public Location () {}

	public int getTimeZoneOffsetMinutes () {
		return this.timeZoneOffsetMinutes;
	}

	public String getTimeZone () {
		return this.timeZone;
	}

	public boolean getIsDaylightSaving () {
		return this.isDaylightSaving;
	}

	public String getStreetAddress () {
		return this.streetAddress;
	}

	public String getCity () {
		return this.city;
	}

	public String getProvinceState () {
		return this.provinceState;
	}

	public String getCountry () {
		return this.country;
	}

	public String getPostalCode () {
		return this.postalCode;
	}

	public String getPhoneNumber () {
		return this.phoneNumber;
	}

	public void setTimeZoneOffsetMinutes (int timeZoneOffsetMinutes) {
		this.timeZoneOffsetMinutes = timeZoneOffsetMinutes;
	}

	public void setTimeZone (String timeZone) {
		this.timeZone = timeZone;
	}

	public void setIsDaylightSaving (boolean isDaylightSaving) {
		this.isDaylightSaving = isDaylightSaving;
	}

	public void setStreetAddress (String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public void setCity (String city) {
		this.city = city;
	}

	public void setProvinceState (String provinceState) {
		this.provinceState = provinceState;
	}

	public void setCountry (String country) {
		this.country = country;
	}

	public void setPostalCode (String postalCode) {
		this.postalCode = postalCode;
	}

	public void setPhoneNumber (String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
