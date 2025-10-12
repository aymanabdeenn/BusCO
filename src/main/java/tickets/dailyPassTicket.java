package tickets;

import models.fareConfig;
import models.dailyPassCalc;

public class dailyPassTicket implements Ticket{
	String type , user , purchaseDate , travelType , category;
	float price;
	int tripNumber;
	
	public dailyPassTicket(String type , String user , String purchaseDate, String travelType , String category , int tripNumber) {
		this.type = type;
		this.user = user;
		this.purchaseDate = purchaseDate;
		this.travelType = travelType;
		this.category = category;
		this.tripNumber = tripNumber;
	}
	
	public void calcPrice(fareConfig fare_config) {
		dailyPassCalc calc = new dailyPassCalc(fare_config , travelType , category);
		this.price = calc.getFare();
	}
	
	public String getType() {return this.type;}
	public String getCategory() {return this.category;}
	public String getUser() {return this.user;}
	public String getPurchaseDate() {return this.purchaseDate;}
	public float getPrice() {return this.price;}
	public int getTripNumber() {return this.tripNumber;}
}
