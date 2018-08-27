package proj;

import org.json.JSONObject;

public class Rule {
	
	private int ruleID;
	private String ruleName;
	private DBC db = new DBC();
	private JSONObject jsonObj;
	
	public Rule(String ruleName) {
		ruleID = db.getNewestID("RuleID", "rule")+1;
		this.ruleName = ruleName;
	}
	public int getID(){
		return ruleID;
	}
	
	public String ruleName(){
		return ruleName;
	}
	
	public JSONObject toJson() {
		jsonObj = new JSONObject();
		jsonObj.put("ruleID", ruleID);
		jsonObj.put("ruleName", ruleName);
		return jsonObj;
	}
	
}
