package trips;

public class Trip {
	String origin , destination , travelType , departureDateTime;
	int tripID = 0 , numOfSeats; 
	
	public Trip(String origin, String destination , String travelType , String departureDateTime, int numOfSeats) {
		this.origin = origin;
		this.destination = destination;
		this.travelType = travelType;
		this.numOfSeats = numOfSeats;
		this.departureDateTime = departureDateTime;
	}
	
	public Trip(int tripID , String origin, String destination , String travelType , String departureDateTime, int numOfSeats) {
		this.tripID = tripID;
		this.origin = origin;
		this.destination = destination;
		this.travelType = travelType;
		this.numOfSeats = numOfSeats;
		this.departureDateTime = departureDateTime;
	}
	
	public int getTripID() {
		return this.tripID;
	}
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTravelType() {
		return travelType;
	}
	public void setTravelType(String travelType) {
		this.travelType = travelType;
	}
	public int getNumOfSeats() {
		return numOfSeats;
	}
	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}
	public String getDepartureDateTime() {
		return departureDateTime;
	}
	public void setDepartureDateTime(String departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

}
