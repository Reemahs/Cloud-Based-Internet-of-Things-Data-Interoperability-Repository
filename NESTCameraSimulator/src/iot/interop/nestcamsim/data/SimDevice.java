package iot.interop.nestcamsim.data;

/**
 * SimDevice
 * This class is the data structure for the NEST Camera simulator Device
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class SimDevice {
	private Metadata metadata;
	private Cameras cameras;
	private Structures structures;
	
	public SimDevice (){
		this.metadata = new Metadata();
		this.cameras = new Cameras();
		this.structures = new Structures();
	}
	
	public Metadata getMetadata (){
		return this.metadata;
	}
	
	public Cameras getCameras () {
		return this.cameras;
	}
	
	public Structures getStructures () {
		return this.structures;
	}
}
