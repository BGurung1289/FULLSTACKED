package proj;

import org.json.JSONObject;

public class Play {
	private int playID;
	private String playName;
	private DBC db = new DBC();
	private JSONObject jsonObj;
	
	public Play(String ruleName){
		playID = db.getNewestID("PlayID", "play") + 1;
		this.playName = ruleName;
	}
	
	public int getID(){
		return playID;
	}
	
	public String getPlayName(){
		return playName;
	}
	
	public JSONObject toJson() {
		jsonObj.put("playID", playID);
		jsonObj.put("playName", playName);
		return jsonObj;
	}
}
