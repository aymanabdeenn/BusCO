package DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class DBusers extends DBdep{
	
	public void addUsersToDB(Connection conn , String username , String password , String type){
		String sql = "INSERT INTO users (username, password , type) VALUES (?, ? , ?)";
		
		if(!userWithTheSameName(conn , username , password, type)) {
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				
			    pstmt.setString(1, username);
			    pstmt.setString(2, password);
			    pstmt.setString(3, type);
			    
			    int rowsInserted = pstmt.executeUpdate();

			    if (rowsInserted > 0) {
			        System.out.println("A new user was inserted successfully!");
			    }

			} catch (SQLException e) {
			    e.printStackTrace();
			}
		}
	}
	
	public Boolean checkUserForLogIn(Connection conn , String username , String password , String type) {
		 String sql = "SELECT * FROM users WHERE username = '" + username + "' AND type = '" + type + "';";
		 
	     try(Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
	    	rs.next();
	    	if(rs.getString("password").equals(password) ) return true;
	    	return false;
	     }
	     catch(SQLException e) {
	    	 System.out.println("An error has occured when getting the data from DB.");
	    	 e.printStackTrace();
	    	 return false;
	     }
	}
	
	public Boolean userWithTheSameName(Connection conn , String username , String password , String type) {
		String sql = "SELECT * FROM users WHERE username = '" + username + "' AND type = '" + type + "';";
		int cnt = 0;
		try(Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) { cnt++;}
			if(cnt > 0) {System.out.println("The username already exists!"); return true;} 
			return false;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return true;
		}
		
	}
	
}
