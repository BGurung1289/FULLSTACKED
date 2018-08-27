package proj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONObject;

public class DBC {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/project_db";
	
	static final String USER = "root";
	static final String Pass = "password";
	
	public DBC() {
	}
	
	public void createLesson() {
		
	}
	
	public void getAllUsers(){
		try(
			Connection conn = DriverManager.getConnection(DB_URL, USER, Pass);
			Statement stmt = conn.createStatement();){
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Connecting to database ..");
			System.out.println("Creating statement ..");
			String sql;
			sql = "select * FROM user";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String first = rs.getString("UserID");
				String second = rs.getString("First_Name");
				String third = rs.getString("Last_Name");
				String fourth = rs.getString("Local_Court");
				String fifth = rs.getString("password");
				String sixth = rs.getString("userName");
				System.out.println(" UserID: " + first);
				System.out.println(" First Name: " + second);
				System.out.println(" Last Name: " + third);
				System.out.println(" Local Court ID: " + fourth);
				System.out.println(" password: " + fifth);
				System.out.println(" userName: " + sixth);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int getNewestUserID() {
		int result = 0;
		try(
			Connection conn = DriverManager.getConnection(DB_URL, USER, Pass);
			Statement stmt = conn.createStatement();){
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Connecting to database ..");
			System.out.println("Creating statement ..");
			String sql;
			sql = "select UserID FROM user";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int userID = rs.getInt("UserID");
				result = userID;
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int getNewestID(String colm ,String table) {
		int result = 0;
		if(table == "user") {
			System.out.println("NO USER ALLOWED");
			return 0;
		}
		try(
			Connection conn = DriverManager.getConnection(DB_URL, USER, Pass);
			Statement stmt = conn.createStatement();){
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Connecting to database ..");
			System.out.println("Creating statement ..");
			String sql;
			sql = "select "+colm+" FROM "+ table;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int userID = rs.getInt(colm);
				result = userID;
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public void addUser(User user, int cID) {
		if(user.addable() == true) {
			String name = user.getfName();
			String lname = user.getlname();
			String pass = user.getPass();
			String userN = user.getUserName();
			try(Connection conn = DriverManager.getConnection(DB_URL, USER, Pass);
				Statement stmt = conn.createStatement();){
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				System.out.println("Connecting to database ..");
				System.out.println("Inserting data");
				String sql; 
				sql = "INSERT INTO user(UserID, First_Name, Last_Name, Local_Court, password, userName)" + "VALUES("+"'"+user.getID()+"'"+","+"'"+name+"'"+","+"'"+lname+"'"+","+"(select CourtID from bballCourt where CourtID =" + cID +")" + "," +"'"+ pass +"'" + "," +"'" + userN+"'"+")";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("user does not have all details filled!");
		}
	}
	
	public User getUser(String username) {
		User requestedUser = new User();
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, Pass);
				Statement stmt = conn.createStatement();){
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				String sql; 
				sql = "SELECT * FROM user WHERE userName="+"'"+username+"'";
				ResultSet result = stmt.executeQuery(sql);
				
				/// /////
				if(result.next()) {
				String first = result.getString("UserID");
				String second = result.getString("First_Name");
				String third = result.getString("Last_Name");
				String fifth = result.getString("password");
				String sixth = result.getString("userName");
				requestedUser.storeDetails(Integer.parseInt(first), second, third,  fifth, sixth);
				}
				/// /////
				
				stmt.close();
				conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		return requestedUser;
	}
	
	public void addAddress(Address address) {
			//set values to add herE
			String postcode = address.getPostcode();
			String street = address.getStreet();
			String city = address.getCity();
			String country = address.getCountry();
			try(Connection conn = DriverManager.getConnection(DB_URL, USER, Pass);
				Statement stmt = conn.createStatement();){
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				System.out.println("Connecting to database ..");
				System.out.println("Inserting data");
				String sql; 
				sql = "INSERT INTO postcode(Postcode, Street, City, Country)" + "VALUES("+"'"+postcode+"',"+"'"+street+"',"+"'"+city+"',"+"'"+country+"'"+")";
				System.out.println(sql);
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public void addLocalCourt(BasketballCourt toAdd) {
		String postcode = toAdd.getPostcode();
		int courtID = toAdd.getCourtID();
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, Pass);
			Statement stmt = conn.createStatement();){
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Connecting to database ..");
			System.out.println("Inserting data");
			String sql; 
			sql = "INSERT INTO bballcourt(Postcode, CourtID) " + "VALUES("+"(select Postcode from postcode where Postcode ="+"'"+postcode+"'),"+"'"+ courtID+"'"+")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public BasketballCourt getLocalCourt(String postcode) {
		BasketballCourt local = null;
		Address localAddress = getLocalAddress(postcode);
		
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, Pass);
				Statement stmt = conn.createStatement();){
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				String sql; 
				sql = "SELECT * FROM bballcourt WHERE Postcode="+"'"+postcode+"'";
				ResultSet result = stmt.executeQuery(sql);
				
				/// /////
				if(result.next()) {
				String postCode = result.getString("Postcode");
				String courtID = result.getString("CourtID");
				
				local = new BasketballCourt(postcode, localAddress.getStreet(), localAddress.getCity(), localAddress.getCountry(), courtID);
				}
				/// /////
				
				stmt.close();
				conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		return local;
	}
	
	public Address getLocalAddress(String postcode) {
		Address local = null;
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, Pass);
				Statement stmt = conn.createStatement();){
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				String sql; 
				sql = "SELECT * FROM postcode WHERE Postcode="+"'"+postcode+"'";
				ResultSet result = stmt.executeQuery(sql);
				
				/// /////
				if(result.next()) {
				String postCode = result.getString("Postcode");
				String street = result.getString("Street");
				String city = result.getString("City");
				String country = result.getString("Country");
				
				local = new Address(postCode, street, city, country);
				}
				/// /////
				
				stmt.close();
				conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		return local;
	}
	
	public Lesson getLesson(String lessonTitle) {
		Lesson returnLsn = null;
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, Pass);
				Statement stmt = conn.createStatement();){
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				String sql; 
				sql = "SELECT * FROM lesson WHERE Lesson_Title="+"'"+lessonTitle+"'";
				ResultSet result = stmt.executeQuery(sql);
				
				/// /////
				if(result.next()) {
					String lsnID = result.getString("LessonID");
					String lsnTitle = result.getString("Lesson_Title");
					returnLsn = new Lesson(lsnID, lsnTitle);
				}
				/// /////
				
				stmt.close();
				conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		return returnLsn;
	}
	
	public ArrayList getAllLessonN() {
		ArrayList<String> allLessonNames = new ArrayList();
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, Pass);
				Statement stmt = conn.createStatement();){
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				String sql; 
				sql = "SELECT Lesson_Title FROM lesson";
				ResultSet result = stmt.executeQuery(sql);
				//
				while(result.next()) {
					String les = result.getString("Lesson_Title");
					allLessonNames.add(les);
				}
				stmt.close();
				conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		return allLessonNames;
	}
	
	public JSONObject getVideo(String lesson) {
		Lesson retrieved = getLesson(lesson);
		JSONObject video = new JSONObject();
		video.put("rule", getRule(retrieved.getID()));
		//play
		video.put("play", getPlay(retrieved.getID()));
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, Pass);
				Statement stmt = conn.createStatement();){
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				String sql; 
				sql = "SELECT * FROM video WHERE Video_ID="+"'"+Integer.toString(retrieved.getID())+"'";
				ResultSet result = stmt.executeQuery(sql);
				//
				if(result.next()) {
					video.put("video", result.getString("Video_URL"));
				}
				stmt.close();
				conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		return video;
	}
	
	public String getRule(int id) {
		String strResult = "";
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, Pass);
				Statement stmt = conn.createStatement();){
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				String sql; 
				sql = "SELECT * FROM rule WHERE RuleID="+"'"+Integer.toString(id)+"'";
				ResultSet result = stmt.executeQuery(sql);
				
				/// /////
				if(result.next()) {
					String ruleName = result.getString("Rule_Name");
					strResult = ruleName;
				}
				/// /////
				
				stmt.close();
				conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		return strResult;
	}
	
	public String getPlay(int id) {
		String strResult = "";
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, Pass);
				Statement stmt = conn.createStatement();){
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				String sql; 
				sql = "SELECT * FROM play WHERE PlayID="+"'"+Integer.toString(id)+"'";
				ResultSet result = stmt.executeQuery(sql);
				
				/// /////
				if(result.next()) {
					String ruleName = result.getString("PlayName");
					strResult = ruleName;
				}
				/// /////
				
				stmt.close();
				conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		return strResult;
	}
	
	

	//get acheivemnet
	
	
	
//		Adding lessons should be done in the database to allow easier addition this will be focused on later on if I have time
//	  
//	//needs to be completed
//	public void addLesson(Lesson lessonTobeAdded, User currentUser) {
//		try(Connection conn = DriverManager.getConnection(DB_URL, USER, Pass);
//			Statement stmt = conn.createStatement();){
//			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//			System.out.println("Connecting to database ..");
//			System.out.println("Inserting data");
//			String sql; 
//			sql = "INSERT INTO lesson(LessonID, lesson_Title, AchievementID, Play_ID, Rule_ID, User_ID, Video_ID)" + "VALUES("+"'"+lessonTobeAdded.getID()+"'"+","+"'"+lessonTobeAdded.getTitle()+"'"+","+"(select AchievementID where AchievementID= "+lessonTobeAdded.getAchievementID()+")" + "," +"'"+ lessonTobeAdded.getRule() +"'" + "," +"'" + // +"'"+")";
//			stmt.executeUpdate(sql);
//			stmt.close();
//			conn.close();
//		}catch(SQLException se) {
//			se.printStackTrace();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
}
