package iot.interop.nestsim.data;

/**
 * Metadata
 * This class is the data structure for the NEST Thermostat Metadata
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class Metadata {
	private String access_token;
	private int client_version;
	
	public void setAccessToken(String accessToken){
		this.access_token = accessToken;
	}
	
	public void setClientVersion(int clientVersion){
		this.client_version = clientVersion;
	}
	
	public String getAccessToken(){
		return this.access_token;
	}
	
	public int getClientVerion(){
		return this.client_version;
	}
}
