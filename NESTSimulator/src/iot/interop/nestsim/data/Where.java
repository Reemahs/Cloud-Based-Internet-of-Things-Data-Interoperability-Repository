package iot.interop.nestsim.data;

/**
 * Thermostat
 * This class is the data structure for the NEST Thermostat Wheres
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class Where {
	private String where_id;
	private String name;
	
	public Where (){
		where_id = null;
		name = null;
	}
	
	public void setWhereID (String whereID){
		this.where_id = whereID;
	}
	
	public void setName (String name){
		this.name = name;
	}
	
	public String getWhereID (){
		return this.where_id;
	}
	
	public String getName (){
		return this.name;
	}
}
