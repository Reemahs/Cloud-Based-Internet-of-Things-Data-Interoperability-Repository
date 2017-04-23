package iot.interop.nestcamsim.data;

/**
 * ETA
 * This class is the data structure for the NEST Camera ETA
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class ETA {
	private String tripID;
	private String estimatedArrivalWindowBegin;
	private String estimatedArrivalWindowEnd;
	
	public ETA (){
		this.tripID = null;
		this.estimatedArrivalWindowBegin = null;
		this.estimatedArrivalWindowEnd = null;
	}
	
	public String getTripID (){
		return this.tripID;
	}
	
	public String getEstimatedArrivalWindowBegin () {
		return this.estimatedArrivalWindowBegin;
	}
	
	public String getEstimatedArrivalWindowEnd () {
		return this.estimatedArrivalWindowEnd;
	}
	
	public void setTripID (String tripID){
		this.tripID = tripID;
	}
	
	public void setEstimatedArrivalWindowBegin (String estimatedArrivalWindowBegin) {
		this.estimatedArrivalWindowBegin = estimatedArrivalWindowBegin;
	}
	
	public void setEstimatedArrivalWindowEnd (String estimatedArrivalWindowEnd) {
		this.estimatedArrivalWindowEnd = estimatedArrivalWindowEnd;
	}
}
