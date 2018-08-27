package proj;


public class BasketballCourt extends Address{
	private String postcode;
	private int courtID;
	private DBC db = new DBC();
	
	public BasketballCourt(String postcode,String street, String city, String country) {
		super(postcode, street, city, country);
		this.postcode = postcode;
		this.courtID = db.getNewestID("CourtID", "bballcourt") + 1; 
	}
	
	public BasketballCourt(String postcode, String street, String city, String country, String courtID) { //constructer for the DBC result version
		super(postcode, street, city, courtID);
		this.postcode = postcode;
		this.courtID = Integer.parseInt(courtID);
	};
	
	public String getPostcode(){
		return postcode;
	}
	
	public int getCourtID(){
		return courtID;
	}
	
}
