package iot.interop.ecobeesim.data;

/**
 * House Details
 * This class is the data structute for the Ecobee Thermostat house model
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class HouseDetails {
	private String style;
	private int size;
	private int numberOfFloors;
	private int numberOfRooms;
	private int numberOfOccupants;
	private int age;
	private int windowEfficiency;
	
	public HouseDetails () {}
	
	public String getStyle () {
		return this.style;
	}

	public int getSize () {
		return this.size;
	}

	public int getNumberOfFloors () {
		return this.numberOfFloors;
	}

	public int getNumberOfRooms () {
		return this.numberOfRooms;
	}

	public int getNumberOfOccupants () {
		return this.numberOfOccupants;
	}

	public int getAge () {
		return this.age;
	}

	public int getWindowEfficiency () {
		return this.windowEfficiency;
	}

	public void setStyle (String style) {
		this.style = style;
	}

	public void setSize (int size) {
		this.size = size;
	}

	public void setNumberOfFloors (int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	public void setNumberOfRooms (int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public void setNumberOfOccupants (int numberOfOccupants) {
		this.numberOfOccupants = numberOfOccupants;
	}

	public void setAge (int age) {
		this.age = age;
	}

	public void setWindowEfficiency (int windowEfficiency) {
		this.windowEfficiency = windowEfficiency;
	}
}