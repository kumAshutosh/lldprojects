package rentalSystem;

public class Location {
	private String address;
	private String state;
	private String city;
	private String pinCode;
	
	public Location(String address, String state, String city, String pinCode) {
		this.address=address;
		this.state=state;
		this.city=city;
		this.pinCode=pinCode;
	}
}
