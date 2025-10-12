package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.sql.PreparedStatement;

import tickets.Ticket;

public class DBtickets extends DBdep{
	
	public void addTicketsToDB(Connection conn , Ticket ticket) {
		
		String sql = "INSERT INTO tickets (ticketOwner, ticketType , ticketPrice , purchaseDate , trip , userCategory) VALUES(? , ? , ? , ? , ? , ?);";
		DecimalFormat df = new DecimalFormat("#.##");
		float formattedPrice = Float.parseFloat(df.format(ticket.getPrice()));
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1 , ticket.getUser());
			pstmt.setString(2 , ticket.getType());
			pstmt.setFloat(3 , formattedPrice);
			pstmt.setString(4 , ticket.getPurchaseDate());
			pstmt.setInt(5 , ticket.getTripNumber());
			pstmt.setString(6 , ticket.getCategory());
			
			int rowsInserted = pstmt.executeUpdate();

		    if (rowsInserted > 0) {
		        System.out.println("A new ticket was inserted successfully!");
		    }
			
		}
		catch(SQLException e) {
			System.out.println("An error occured while adding the ticket into the database!");
			e.printStackTrace();
		}
	}
	
	public ResultSet getUserTickets(Connection conn , String username) {
		String sql = "SELECT * FROM tickets WHERE ticketOwner = '" + username + "';";
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt =  conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			return rs;
		}
		catch(SQLException e) {
			System.out.println("An error occured while retrieving the tickets history of the user!");
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ResultSet getUserTicketsWithTripInfo(Connection conn , String username) {
		String sql = "SELECT * FROM tickets JOIN trips ON tickets.trip = trips.tripID WHERE ticketOwner = '" + username + "';";
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt =  conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			return rs;
		}
		catch(SQLException e) {
			System.out.println("An error occured while retrieving the tickets history of the user!");
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ResultSet getTicketsInDateRange(Connection conn , LocalDate dateRangeStart , LocalDate dateRangeEnd) {
		String sql = "SELECT * FROM tickets WHERE purchaseDate >= '" + dateRangeStart + "' AND purchaseDate <= '" + dateRangeEnd + "';";
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt =  conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			return rs;
		}
		catch(SQLException e) {
			System.out.println("An error occured while retrieving the tickets history of the user!");
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ResultSet getTicketsWithTicketType(Connection conn , String type) {
		String sql = "SELECT * FROM tickets WHERE ticketType = '" + type + "';";
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt =  conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			return rs;
		}
		catch(SQLException e) {
			System.out.println("An error occured while retrieving the tickets history of the user!");
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ResultSet getTicketsWithUserCategory(Connection conn , String userCategory) {
		String sql = "SELECT * FROM tickets WHERE userCategory = '" + userCategory + "';";
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt =  conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			return rs;
		}
		catch(SQLException e) {
			System.out.println("An error occured while retrieving the tickets history of the user!");
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ResultSet getTicketsInTheLastDay(Connection conn) {
		LocalDate currentDay = LocalDate.now();
		System.out.println(currentDay);
		
		String sql = "SELECT * FROM tickets WHERE purchaseDate = '" + currentDay+ "';";
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt =  conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			return rs;
		}
		catch(SQLException e) {
			System.out.println("An error occured while retrieving the tickets history of the user!");
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ResultSet getTicketsInTheLastWeek(Connection conn) {
		LocalDate currentDay = LocalDate.now();
		LocalDate lastWeek = currentDay.minusWeeks(1);
		
		System.out.println(currentDay + " " + lastWeek);
		
		String sql = "SELECT * FROM tickets WHERE purchaseDate >= '" + lastWeek + "' AND purchaseDate <= '" + currentDay + "';";
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt =  conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			return rs;
		}
		catch(SQLException e) {
			System.out.println("An error occured while retrieving the tickets history of the user!");
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ResultSet getTicketsInTheLastMonth(Connection conn) {
		LocalDate currentDay = LocalDate.now();
		LocalDate lastMonth = currentDay.minusMonths(1);
		
		System.out.println(currentDay + " " + lastMonth);
		
		String sql = "SELECT * FROM tickets WHERE purchaseDate >= '" + lastMonth + "' AND purchaseDate <= '" + currentDay + "';";
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt =  conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			return rs;
		}
		catch(SQLException e) {
			System.out.println("An error occured while retrieving the tickets history of the user!");
			e.printStackTrace();
			return null;
		}
		
	}
	
}
