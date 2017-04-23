package iot.interop.nestcamsim.data;

/**
 * LastEvent
 * This class is the data structure for the NEST Camera LastEvent
 * 
 * This class only contains Get and Set methods for the class fields
 * 
 * Details and descriptions for class fields can be found in the appropriate appendix in the dissertation
 * 
 * @author Shameer Omar (130145965)
 * @version 1.0
 */
public class LastEvent {
	private boolean hasSound;
	private boolean hasMotion;
	private boolean hasPerson;
	private String startTime;
	private String endTime;
	private String urlsExpireTime;
	private String webURL;
	private String appURL;
	private String imageURL;
	private String animatedImageURL;
	private String activityZoneIDs;
	
	public LastEvent (){
		this.hasSound = false;
		this.hasMotion = false;
		this.hasPerson = false;
		this.startTime = null;
		this.endTime = null;
		this.urlsExpireTime = null;
		this.webURL = null;
		this.appURL = null;
		this.imageURL = null;
		this.animatedImageURL = null;
		this.activityZoneIDs = null;
	}
	
	public boolean getHasSound () {
		return this.hasSound;
	}

	public boolean getHasMotion () {
		return this.hasMotion;
	}

	public boolean getHasPerson () {
		return this.hasPerson;	
	}

	public String getStartTime () {
		return this.startTime;
	}

	public String getEndTime () {
		return this.endTime;
	}

	public String getUrlsExpireTime () {
		return this.urlsExpireTime;
	}

	public String getWebURL () {
		return this.webURL;
	}

	public String getAppURL () {
		return this.appURL;
	}

	public String getImageURL () {
		return this.imageURL;
	}

	public String getAnimatedImageURL () {
		return this.animatedImageURL;
	}

	public String getActivityZoneIDs () {
		return this.activityZoneIDs;
	}

	public void setHasSound (boolean hasSound) {
		this.hasSound = hasSound;
	}

	public void setHasMotion (boolean hasMotion) {
		this.hasMotion = hasMotion;
	}

	public void setHasPerson (boolean hasPerson) {
		this.hasPerson = hasPerson;	
	}

	public void setStartTime (String startTime) {
		this.startTime = startTime;
	}

	public void setEndTime (String endTime) {
		this.endTime = endTime;
	}

	public void setUrlsExpireTime (String urlsExpireTime) {
		this.urlsExpireTime = urlsExpireTime;
	}

	public void setWebURL (String webURL) {
		this.webURL = webURL;
	}

	public void setAppURL (String appURL) {
		this.appURL = appURL;
	}

	public void setImageURL (String imageURL) {
		this.imageURL = imageURL;
	}

	public void setAnimatedImageURL (String animatedImageURL) {
		this.animatedImageURL = animatedImageURL;
	}

	public void setActivityZoneIDs (String activityZoneIDs) {
		this.activityZoneIDs = activityZoneIDs;
	}
}
