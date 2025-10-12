package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

import tickets.Ticket;
import tickets.TicketFactory;

//import tickets.TicketFactory;
//import tickets.Ticket;


public class testDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		DBusers dbTest = new DBusers();
//		Connection conn = dbTest.makeConnection();
//		
//		if(dbTest.checkUserForLogIn(conn , "khaled" , "1" , "passenger")) System.out.println("Logged in successfully!");
//		else System.out.println("Failed to log in");
		
		DBtickets db = new DBtickets();
		Connection conn = db.makeConnection();

//		TicketFactory factory = new TicketFactory();
//		Ticket ticket = factory.getTicket("one trip" , "ayman" , "2025-05-30" , "city" , "regular" , true);
		LocalDate localDate1 = LocalDate.parse("2025-05-13");
		LocalDate localDate2 = LocalDate.parse("2025-05-14");
		
	
		ResultSet rs = db.getTicketsInTheLastWeek(conn);
		
//		System.out.println(ticket.getUser());
		
//		DBtrips dbTest = new DBtrips();
//		Connection conn = dbTest.makeConnection();
//		ResultSet rs = dbTest.getAllTrips(conn);
		try {
			float sum = 0;
			while(rs.next()) {
				sum += rs.getFloat("ticketPrice");	
				System.out.println(rs.getString("ticketID"));
			}
			System.out.println(sum);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
