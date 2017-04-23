package iot.interop.nestcamsim.data;

/**
 * Thermostat
 * This class is the data structure for the NEST Cameras
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class Cameras {
	private String deviceID;
	private String softwareVersion;
	private String name;
	private String nameLong;
	private boolean online;
	private boolean streaming;
	private boolean audioInputEnabled;
	private String lastIsOnlineChanged;
	private boolean videoHistoryEnabled;
	private String webURL;
	private String appURL;
	private boolean publicShareEnabled;
	private String publicShareURL;
	private String snapshortURL;
	private ActivityZones activityZones;
	private LastEvent lastEvent;
	
	public Cameras (){
		this.deviceID = null;
		this.softwareVersion = null;
		this.name = null;
		this.nameLong = null;
		this.online = false;
		this.streaming = false;
		this.audioInputEnabled = false;
		this.lastIsOnlineChanged = null;
		this.videoHistoryEnabled = false;
		this.webURL = null;
		this.appURL = null;
		this.publicShareEnabled = false;
		this.publicShareURL = null;
		this.snapshortURL = null;
		this.activityZones = new ActivityZones();
		this.lastEvent = new LastEvent();
	}
	
	public String getDeviceID (){
		return this.deviceID;
	}

	public String getSoftwareVersion (){
		return this.softwareVersion;
	}

	public String getName (){
		return this.name;
	}

	public String getNameLong (){
		return this.nameLong;
	}

	public boolean getOnline (){
		return this.online;
	}

	public boolean getStreaming (){
		return this.streaming;
	}

	public boolean getAudioInputEnabled (){
		return this.audioInputEnabled;
	}

	public String getLastIsOnlineChanged (){
		return this.lastIsOnlineChanged;
	}

	public boolean getVideoHistoryEnabled (){
		return this.videoHistoryEnabled;
	}

	public String getWebURL (){
		return this.webURL;
	}

	public String getAppURL (){
		return this.appURL;
	}

	public boolean getPublicShareEnabled (){
		return this.publicShareEnabled;
	}

	public String getPublicShareURL (){
		return this.publicShareURL;
	}

	public String getSnapshortURL (){
		return this.snapshortURL;
	}

	public ActivityZones getActivityZones (){
		return this.activityZones;
	}

	public LastEvent getLastEvent (){
		return this.lastEvent;
	}
	
	public void setDeviceID (String deviceID){
		this.deviceID = deviceID;
	}

	public void setSoftwareVersion (String softwareVersion){
		this.softwareVersion = softwareVersion;
	}

	public void setName (String name){
		this.name = name;
	}

	public void setNameLong (String nameLong){
		this.nameLong = nameLong;
	}

	public void setOnline (boolean isOnline){
		this.online = isOnline;
	}

	public void setStreaming (boolean isStreaming){
		this.streaming = isStreaming;
	}

	public void setAudioInputEnabled (boolean isAudioInputEnabled){
		this.audioInputEnabled = isAudioInputEnabled;
	}

	public void setLastOnlineChanged (String lastIsOnlineChanged){
		this.lastIsOnlineChanged = lastIsOnlineChanged;
	}

	public void setVideoHistoryEnabled (boolean isVideoHistoryEnabled){
		this.videoHistoryEnabled = isVideoHistoryEnabled;
	}

	public void setWebURL (String webURL){
		this.webURL = webURL;
	}

	public void setAppURL (String appURL){
		this.appURL = appURL;
	}

	public void setPublicShareEnabled (boolean isPublicShareEnabled){
		this.publicShareEnabled = isPublicShareEnabled;
	}

	public void setPublicShareURL (String publicShareURL){
		this.publicShareURL = publicShareURL;
	}

	public void setSnapshortURL (String snapshortURL){
		this.snapshortURL = snapshortURL;
	}
}
