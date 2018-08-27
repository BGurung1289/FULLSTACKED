package proj;

import org.json.JSONObject;

public class Video {
	private int videoID;
	private String videoTitle;
	private String videoURL;
	private DBC db = new DBC();
	private JSONObject jsonObj;
	
	public Video(String videoTitle, String videoURL){
		videoID = db.getNewestID("Video_ID", "video") + 1;
		this.videoTitle = videoTitle;
		this.videoURL = videoURL;
	}
	
	public int getID(){
		return videoID;
	}
	public String getVideoTitle(){
		return videoTitle;
	}
	
	public String videoURL(){
		return videoURL;
	}
	
	public JSONObject toJson() {
		jsonObj = new JSONObject();
		jsonObj.put("videoTitle", videoTitle);
		jsonObj.put("videoURL", videoURL);
		return jsonObj;
	}
}
