package iot.interop.nestcamsim.data;

/**
 * Metadata
 * This class is the data structure for the NEST Camera Metadata
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class Metadata {
	private String accessToken;
	private String clientVersion;
	
	public Metadata () {
		this.accessToken = null;
		this.clientVersion = null;
	}
	
	public String getAccessToken () {
		return this.accessToken;
	}
	
	public String getClientVersion () {
		return this.clientVersion;
	}
	
	public void setAccessToken (String accessToken) {
		this.accessToken = accessToken;
	}
	
	public void setClientVersion (String clientVersion) {
		this.clientVersion = clientVersion;
	}
}
