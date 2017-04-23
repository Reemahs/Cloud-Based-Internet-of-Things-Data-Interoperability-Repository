package iot.interop.nestsim.data;

/**
 * ETA
 * This class is the data structure for the NEST Thermostat ETA
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class ETA {
	private String trip_id;
	private String estimated_arrival_window_begin;
	private String estimated_arrival_window_end;
	
	public ETA (){
		trip_id = null;
		estimated_arrival_window_begin = null;
		estimated_arrival_window_end = null;
	}
	
	public void setTripID (String tripID){
		this.trip_id = tripID;
	}
	
	public void setEstimatedArrivalWindowBegin (String estimatedArrivalBegin){
		this.estimated_arrival_window_begin = estimatedArrivalBegin;
	}
	
	public void setEstimatedArricalWindowEnd (String estimatedArrivalEnd){
		this.estimated_arrival_window_end = estimatedArrivalEnd;
	}
	
	public String getTripID (){
		return this.trip_id;
	}
	
	public String getEstimatedArrivalWindowBegin (){
		return this.estimated_arrival_window_begin;
	}
	
	public String getEstimatedArricalWindowEnd (){
		return this.estimated_arrival_window_end;
	}
}
