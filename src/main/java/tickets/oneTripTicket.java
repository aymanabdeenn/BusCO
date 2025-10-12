package tickets;

import models.fareConfig;
import models.oneTripCalc;

public class oneTripTicket implements Ticket{
	String type , user , purchaseDate , travelType , category;
	float price;
	Boolean evening;
	int tripNumber;
	
	public oneTripTicket(String type , String user , String purchaseDate, String travelType , String category , Boolean evening , int tripNumber) {
		this.type = type;
		this.user = user;
		this.purchaseDate = purchaseDate;
		this.travelType = travelType;
		this.category = category;
		this.evening = evening;
		this.tripNumber = tripNumber;
	}
	
	public void calcPrice(fareConfig fare_config) {
		oneTripCalc calc = new oneTripCalc(fare_config , travelType , category , evening);
		this.price = calc.getFare();
	}
	
	public String getType() {return this.type;}
	public String getCategory() {return this.category;}
	public String getUser() {return this.user;}
	public String getPurchaseDate() {return this.purchaseDate;}
	public float getPrice() {return this.price;}
	public int getTripNumber() {return this.tripNumber;}
}
