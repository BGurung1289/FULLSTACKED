package proj;

import org.json.JSONObject;

public class Lesson {
	private int lessonID;
	private String lessonTitle;
	private int ruleID;
	private int playID;
	private int videoID;
	private int achievementID;
	private JSONObject jsonObj;
	private DBC db = new DBC();
	
	public Lesson(String lessonTitle, int rule, int play, int video){
		lessonID = db.getNewestID("LessonID", "lesson") + 1;
		this.lessonTitle = lessonTitle;
		this.ruleID = rule;
		this.playID = play;
		this.videoID = video;
	}
	
	public Lesson(String lessonID, String lessonTitle) {
		this.lessonID = Integer.parseInt(lessonID);
		this.lessonTitle = lessonTitle;
	}
	
	public int getID(){
		return lessonID;
	}
	public String getTitle(){
		return lessonTitle;
	}
	public int getRule(){
		return ruleID;
	}
	public int getPlay(){
		return playID;
	}
	public int getVideo(){
		return videoID;
	}
	public int getAchievementID() {
		return achievementID;
	}
	
	public JSONObject toJson() {
		jsonObj = new JSONObject();
		jsonObj.put("lessonID", lessonID);
		jsonObj.put("lessonTitle", lessonTitle);
		jsonObj.put("rule", ruleID);
		jsonObj.put("play", playID);
		jsonObj.put("video", videoID);
		return jsonObj;
	}
}
