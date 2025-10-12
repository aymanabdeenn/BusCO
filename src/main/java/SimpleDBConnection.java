import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class SimpleDBConnection {

    public static void main(String[] args) {
        // Database URL, username and password
        String url = "jdbc:mysql://localhost:3306/world";
        String user = "admin";
        String password = "admin";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load the JDBC driver (optional for modern versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");

            // Create and execute a simple query
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM country");

            // Process the result set
            while (rs.next()) {
                System.out.println("Row: " + rs.getString("Code") + " - " + rs.getString("Name"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close resources in reverse order of their creation
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}
