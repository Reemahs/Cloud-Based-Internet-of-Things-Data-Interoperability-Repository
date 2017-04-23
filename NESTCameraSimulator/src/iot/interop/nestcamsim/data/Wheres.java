package iot.interop.nestcamsim.data;

/**
 * Wheres
 * This class is the data structure for the NEST Camera Wheres
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class Wheres {
	private String whereID;
	private String name;
	
	public Wheres () {
		this.whereID = null;
		this.name = null;
	}
	
	public String getWhereID (){
		return this.whereID;
	}
	
	public String getName () {
		return this.name;
	}
	
	public void setWhereID (String whereID){
		this.whereID = whereID;
	}
	
	public void setName (String name){
		this.name = name;
	}
}
