package proj;

public class Address {
	private String postcode;
	private String street;
	private String city;
	private String country;
	
	public Address(String postcode,String street, String city, String country){
		this.postcode = postcode;
		this.street = street;
		this.city = city;
		this.country = country;
	}
	
	
	public String getStreet(){
		return street;
	}
	
	public String getCity(){
		return city;
	}
	
	public String getCountry(){
		return country;
	}
	
	public String getPostcode() {
		return postcode;
	}

}
