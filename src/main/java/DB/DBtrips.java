package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import trips.Trip;

public class DBtrips extends DBdep{
	
	public ResultSet getAvaliableTrips(Connection conn , String origin , String destination , String travelType , String date) {
		 ResultSet rs = null;
		 Statement stmt = null;
	     try {
	    	stmt = conn.createStatement(); 
	    	rs = stmt.executeQuery("SELECT * FROM trips WHERE travelType = '" + travelType + "' AND origin = '" + origin + "' AND destination = '" + destination + "' AND DATE(departureTime) = '" + date + "';");
	    	
	    	return rs;
	     
	     }
	     catch(SQLException e) {
	    	 System.out.println("An error has occured when getting the data from DB.");
	    	 e.printStackTrace();
	    	 return null;
	     }
	     
	}
	
	public ResultSet getAllTrips(Connection conn) {
		 ResultSet rs = null;
		 Statement stmt = null;
	     try {
	    	stmt = conn.createStatement();
	    	LocalDate localDate = LocalDate.now();
	    	rs = stmt.executeQuery("SELECT * FROM trips WHERE DATE(departureTime) > '" + localDate + "' ;");
	    	
	    	return rs;
	     
	     }
	     catch(SQLException e) {
	    	 System.out.println("An error has occured when getting the data from DB.");
	    	 e.printStackTrace();
	    	 return null;
	     }
	     
	}
	
	public void getAvaliableTripsTest(Connection conn) {
		ResultSet rs = null;
		 Statement stmt = null;
	     try {
	    	stmt = conn.createStatement(); 
	    	rs = stmt.executeQuery("SELECT * FROM trips  WHERE travelType = 'innerCity';");
	    	
	    	while (rs.next()) {
	    	 Timestamp ts = rs.getTimestamp("departureTime");
		     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		     String formatted = formatter.format(ts);
	    	 System.out.println("Trips Number:" + rs.getString("tripID")+  " - Origin:" + rs.getString("origin")+ " - Destination:" + rs.getString("destination") + " - departureTime:" + formatted);
            }
			
			if(conn != null) conn.close();
			if(rs != null) rs.close();
	     
	     }
	     catch(SQLException e) {
	    	 System.out.println("An error has occured when getting the data from DB.");
	    	 e.printStackTrace();
	     }
	     
	}

	
	public ResultSet getSpecificTrip(Connection conn,  int tripID) {
		
		 ResultSet rs = null;
		 Statement stmt = null;
	     try {
	    	stmt = conn.createStatement(); 
	    	rs = stmt.executeQuery("SELECT * FROM trips WHERE tripID = '" + tripID + "';");
	  
	    	return rs;
	     
	     }
	     catch(SQLException e) {
	    	 System.out.println("An error has occured when getting the data from DB.");
	    	 e.printStackTrace();
	    	 return null;
	     }
		
	}
	
	public void addATripToDB(Connection conn , Trip trip) {
		String sql = "INSERT INTO trips (origin , destination , travelType, departureTime , seats) VALUES(? , ? , ? , ? , ?)";
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1 ,trip.getOrigin());
			pstmt.setString(2 ,trip.getDestination());
			pstmt.setString(3 ,trip.getTravelType());
			pstmt.setString(4 ,trip.getDepartureDateTime()); 
			pstmt.setInt(5 ,trip.getNumOfSeats());
			
			int rowInserted = pstmt.executeUpdate();
			if(rowInserted > 0) System.out.println("The trip has been inserted successfully!");
		}
		catch(SQLException e) {
			System.out.println("An error has occured while adding a trip to the database!");
			e.printStackTrace();
		}
		
	}
	
	public void updateATrip(Connection conn , Trip trip) {
		
		String sql = "UPDATE trips SET origin = '" + trip.getOrigin() + "' , destination = '" + trip.getDestination() + "' , travelType = '" + trip.getTravelType() + "'"
				+ " , departureTime = '" + trip.getDepartureDateTime() + "' , seats = '" + trip.getNumOfSeats() + "' WHERE tripID = '" + trip.getTripID() + "';";
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			int rowUpdated = pstmt.executeUpdate();
			if(rowUpdated > 0) System.out.println("The trip has been updated successfully!");
			
		}
		catch(SQLException e) {
			System.out.println("An error occured while updating the trip in the database!");
			e.printStackTrace();
		}
	}
	
	public void updateTripNumOfSeats(Connection conn , int tripID , int newNumOfSeats) {
		String sql = "UPDATE trips SET seats = '" + newNumOfSeats + "' WHERE tripID = '" + tripID + "';";
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			int updatedTrip = pstmt.executeUpdate();
			if(updatedTrip > 0) System.out.println("The number of seats has been updated for the chosen trip!");
		}
		catch(SQLException e) {
			System.out.println("An error occured while updating the number of seats for a specific trip!");
			e.printStackTrace();
		}
	}
	
	public void deleteATripFromDB(Connection conn , int tripID) {
		String sql = "DELETE FROM trips WHERE tripID = '" + tripID + "';";
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			int rowDeleted = pstmt.executeUpdate();
			if(rowDeleted > 0) System.out.println("The trip has been deleted Successfully!");
		}
		catch(SQLException e) {
			System.out.println("An error occured while deleting a trip from the database!");
			e.printStackTrace();
		}
	}
	
}
