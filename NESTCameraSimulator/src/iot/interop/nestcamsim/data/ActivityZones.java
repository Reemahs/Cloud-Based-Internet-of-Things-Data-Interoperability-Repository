package iot.interop.nestcamsim.data;

/**
 * ActivityZones
 * This class is the data structure for the NEST Camera ActivityZones
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class ActivityZones {
	private String name;
	private String id;
	
	public ActivityZones (){
		this.name = null;
		this.id = null;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getID(){
		return this.id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setID(String id){
		this.id = id;
	}
}
