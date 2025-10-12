package tickets;

public class TicketFactory {
	
	public Ticket getTicket(String type , String user , String purchaseDate, String travelType , String category , Boolean evening , int tripNumber) {
		if(type.equals("one trip")) return new oneTripTicket(type , user , purchaseDate , travelType , category , evening , tripNumber);
		else if(type.equals("daily pass")) return new dailyPassTicket(type , user , purchaseDate , travelType , category , tripNumber);
		else if(type.equals("weekly pass")) return new weeklyPassTicket(type , user , purchaseDate , travelType , category , tripNumber);
		else if(type.equals("monthly pass")) return new monthlyPassTicket(type , user , purchaseDate , travelType , category  , tripNumber);
		else {System.out.println("An error occured while creating the ticket, check the values of the info of the ticket!"); return null;}
	} 

}
