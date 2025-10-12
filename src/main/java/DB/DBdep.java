package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBdep {
	
	public Connection makeConnection() {
		String url = "jdbc:mysql://localhost:3306/buscodb";
        String user = "admin";
        String password = "admin";
        
        Connection conn = null;
        try{
            // Load the JDBC driver (optional for modern versions)
        	  System.out.println("Loading MySQL Driver...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected to the database!");
            
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connection established!");
            }
            return conn;
        }
        catch(SQLException | ClassNotFoundException e) {
        	System.out.println("An error has occured when making the connection.");
        	e.printStackTrace();
        	return null;
        }
	}
	
	public void getDataFromDB(String tableName , Connection conn) {
	     
	     try( Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName)) {
	    	 
	    	 while (rs.next()) {
		            System.out.println("Row: " + rs.getString("Code") + " - " + rs.getString("Name"));
		        }
	     	
	     }
	     catch(SQLException e) {
	    	 System.out.println("An error has occured when getting the data from DB.");
	    	 e.printStackTrace();
	     }
	}
	
	
	///////////////////////////////////////
	
	public void insertDataToDB(String username, String password, Connection conn) {
		String sql = "INSERT INTO users (username, email) VALUES (?, ?)";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

		    pstmt.setString(1, username);
		    pstmt.setString(2, password);

		    int rowsInserted = pstmt.executeUpdate();

		    if (rowsInserted > 0) {
		        System.out.println("A new user was inserted successfully!");
		    }

		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
	}
}
