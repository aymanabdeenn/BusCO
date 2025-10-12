package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.fareConfig;

public class DBfare extends DBdep{
	
	public Boolean isEmpty(Connection conn) {
			
		String sql = "SELECT * FROM fares;";
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			int cnt = 0;
			while(rs.next()) {cnt++;}
			
			if(cnt < 1) return true;
			
			return false;
		}
		catch(SQLException e) {
			System.out.println("An error has occured when retreiving the fares from the database!");
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void addFareToDB(Connection conn , fareConfig fare_config) {
		String sql = "INSERT INTO fares (cityFare , innerCityFare , oneTripFare , dailyFare , weeklyFare , monthlyFare , regularFare , studentFare , seniorFare , eveningFare) VALUES(? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1 , fare_config.getCityFare()+"");
			pstmt.setString(2 ,fare_config.getInnerCityFare()+"");
			pstmt.setString(3 ,fare_config.getOneTripFare()+"");
			pstmt.setString(4 ,fare_config.getDailyFare()+""); 
			pstmt.setString(5 ,fare_config.getWeeklyFare()+"");
			pstmt.setString(6 ,fare_config.getMonthlyFare()+"");
			pstmt.setString(7 ,fare_config.getRegularFare()+"");
			pstmt.setString(8 ,fare_config.getStudentFare()+"");
			pstmt.setString(9 ,fare_config.getSeniorFare()+"");
			pstmt.setString(10 ,fare_config.getEveningFare()+"");
			
			int rowInserted = pstmt.executeUpdate();
			if(rowInserted > 0) System.out.println("The fare has been inserted successfully!");
		}
		catch(SQLException e) {
			System.out.println("An error has occured while adding the fare to the database!");
			e.printStackTrace();
		}
	}
	
	public fareConfig getFareFromDB(Connection conn) {
		
		 ResultSet rs = null;
		 Statement stmt = null;
	     try {
	    	stmt = conn.createStatement(); 
	    	rs = stmt.executeQuery("SELECT * FROM fares;");
	    	if(rs.next()) {
	    		float cityFare = Float.parseFloat(rs.getString("cityFare"));
	    		float innerCityFare = Float.parseFloat(rs.getString("innerCityFare"));
	    		float oneTripFare = Float.parseFloat(rs.getString("oneTripFare"));
	    		float dailyFare = Float.parseFloat(rs.getString("dailyFare"));
	    		float weeklyFare = Float.parseFloat(rs.getString("weeklyFare"));
	    		float monthlyFare = Float.parseFloat(rs.getString("monthlyFare"));
	    		float regularFare = Float.parseFloat(rs.getString("regularFare"));
	    		float studentFare = Float.parseFloat(rs.getString("studentFare"));
	    		float seniorFare = Float.parseFloat(rs.getString("seniorFare"));
	    		float eveningFare = Float.parseFloat(rs.getString("eveningFare"));
	    		fareConfig fare_config = new fareConfig(cityFare , innerCityFare ,oneTripFare ,dailyFare ,weeklyFare ,monthlyFare ,regularFare ,studentFare ,seniorFare ,eveningFare);
	    		rs.close();
	    		stmt.close();
	    		return fare_config;
	    	}
	    	else {System.out.println("Failed in getting the fare from the database!");return null;}  
	     }
	     catch(SQLException e) {
	    	 System.out.println("An error has occured when getting the fare from DB.");
	    	 e.printStackTrace();
	    	 return null;
	     }
		
	}
	
	public void updateFare(Connection conn , String fareType , float newFare) {
		
		String sql = "UPDATE fares SET " + fareType + " = '" + newFare + "';";
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			int rowUpdated = pstmt.executeUpdate();
			if(rowUpdated > 0) System.out.println("The FARE has been updated successfully!");
			
		}
		catch(SQLException e) {
			System.out.println("An error occured while updating the fare in the database!");
			e.printStackTrace();
		}
	}

}
