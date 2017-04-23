package iot.interop.ecobeesim.data;

/**
 * User
 * This class is the data structure for the Ecobee Thermostat user
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class User {
	private String userName;
	private String displayName;
	private String firstName;
	private String lastName;
	private String honerific;
	private String registerDate;
	private String registerTime;
	private String defaultThermostatIdentifier;
	private String managementRef;
	private String utilityRef;
	private String supportRef;
	private String phoneNumber;
	private boolean isResidential;
	private boolean isDeveloper;
	private boolean isManagement;
	private boolean isUtility;
	private boolean isContractor;
	
	public User () {}
	
	public String getUserName () {
		return this.userName;
	}

	public String getDisplayName () {
		return this.displayName;
	}

	public String getFirstName () {
		return this.firstName;
	}

	public String getLastName () {
		return this.lastName;
	}

	public String getHonerific () {
		return this.honerific;
	}

	public String getRegisterDate () {
		return this.registerDate;
	}

	public String getRegisterTime () {
		return this.registerTime;
	}

	public String getDefaultThermostatIdentifier () {
		return this.defaultThermostatIdentifier;
	}

	public String getManagementRef () {
		return this.managementRef;
	}

	public String getUtilityRef () {
		return this.utilityRef;
	}

	public String getSupportRef () {
		return this.supportRef;
	}

	public String getPhoneNumber () {
		return this.phoneNumber;
	}

	public boolean getIsResidential () {
		return this.isResidential;
	}

	public boolean getIsDeveloper () {
		return this.isDeveloper;
	}

	public boolean getIsManagement () {
		return this.isManagement;
	}

	public boolean getIsUtility () {
		return this.isUtility;
	}

	public boolean getIsContractor () {
		return this.isContractor;
	}
	
	public void setUserName (String userName) {
		this.userName = userName;
	}

	public void setDisplayName (String displayName) {
		this.displayName = displayName;
	}

	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}

	public void setLastName (String lastName) {
		this.lastName = lastName;
	}

	public void setHonerific (String honerific) {
		this.honerific = honerific;
	}

	public void setRegisterDate (String registerDate) {
		this.registerDate = registerDate;
	}

	public void setRegisterTime (String registerTime) {
		this.registerTime = registerTime;
	}

	public void setDefaultThermostatIdentifier (String defaultThermostatIdentifier) {
		this.defaultThermostatIdentifier = defaultThermostatIdentifier;
	}

	public void setManagementRef (String managementRef) {
		this.managementRef = managementRef;
	}

	public void setUtilityRef (String utilityRef) {
		this.utilityRef = utilityRef;
	}

	public void setSupportRef (String supportRef) {
		this.supportRef = supportRef;
	}

	public void setPhoneNumber (String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setIsResidential (boolean isResidential) {
		this.isResidential = isResidential;
	}

	public void setIsDeveloper (boolean isDeveloper) {
		this.isDeveloper = isDeveloper;
	}

	public void setIsManagement (boolean isManagement) {
		this.isManagement = isManagement;
	}

	public void setIsUtility (boolean isUtility) {
		this.isUtility = isUtility;
	}

	public void setIsContractor (boolean isContractor) {
		this.isContractor = isContractor;
	}
}
