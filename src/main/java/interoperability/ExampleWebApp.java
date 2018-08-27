package interoperability;
import java.sql.*;
import java.util.ArrayList;

import javax.tools.JavaFileObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import proj.Address;
import proj.BasketballCourt;
import proj.DBC;
import proj.User;



@Path("/web")
public class ExampleWebApp {
	
	private DBC database = new DBC();
	
	
	@GET
	@Produces("Application/json")
	@Path("/getLesson")
	public String getAllLessons() {
		JSONObject obj = new JSONObject();
		ArrayList<String>list = database.getAllLessonN();
		obj.put("lesson", list);
		return obj.toString();
	}
	
	@GET
	@Path("/getVideo/{lesson}")
	public String getVideo(@PathParam("lesson") String lesson) {
		return database.getVideo(lesson).toString();
	}
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void addUser(
		@FormParam("username") String name,
		@FormParam("password") String passw,
		@FormParam("firstName") String fname,
		@FormParam("lastName") String lname,
		@FormParam("postcode") String pcode,
		@FormParam("street") String street,
		@FormParam("city") String city, 
		@FormParam("country") String country) {

		Address address = new Address(pcode, street, city, country);
		database.addAddress(address);
		BasketballCourt bballC = new BasketballCourt(pcode, street,city,country);  
		database.addLocalCourt(bballC);
		User newUser = new User(name, passw);
		newUser.setName(fname, lname);
		database.addUser(newUser, bballC.getCourtID()); 
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String login() {
		JSONObject result = new JSONObject();
		
		
		return result.toString();
	}
	
	
}
