package proj;

import org.json.JSONObject;

public class User {
	private int userID;
	private String userName;
	private String first_name;
	private String last_name;
	private String password;
	private JSONObject jsonObj;
	
	DBC db = new DBC();
	
	public  User() {
		
	}
	// Constructer
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
		userID = db.getNewestUserID() + 1;
	}
	
	public void setName(String first_name, String last_name) {
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	public boolean addable() {
		if(first_name!=null && last_name!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void  storeDetails(int id,  String fname, String lname, String pass, String uname) {
		userID = id;
		userName = uname;
		first_name = fname;
		last_name = lname;
		password = pass;
	}
	
	public int getID() {
		return userID;
	}
	public String getUserName() {
		return userName;
	}
	public String getfName() {
		return first_name;
	}
	public String getlname() {
		return last_name;
	}
	public String getPass() {
		return password;
	}
	public JSONObject toJson() {
		jsonObj = new JSONObject();
		jsonObj.put("userName", userName);
		jsonObj.put("password", password);
		return jsonObj;
	}
	
}
