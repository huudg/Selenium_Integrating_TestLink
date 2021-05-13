package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtils {
	 private static String DB_URL = "jdbc:mysql://localhost:3306/bitnami_testlink";
	 private static String USER_NAME = "root";
	 private static String PASSWORD = "010199";
 
	 public static Connection getConnection(String dbURL, String userName, 
	            String password) {
	        Connection conn = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(dbURL, userName, password);
	            System.out.println("connect successfully!");
	        } catch (Exception ex) {
	            System.out.println("connect failure!");
	            ex.printStackTrace();
	        }
	        return conn;
	    }
	 public static int getLastExId(int testPlanId) throws SQLException {
		 Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
		 int id = 0;
         // crate statement
         Statement stmt = conn.createStatement();
         // get data from table 'executions'
         ResultSet rs = stmt.executeQuery("select MAX(id) from executions where testplan_id = "+ testPlanId);
         if(rs.next()) { 
        	 id = rs.getInt(1);
         }
         return id;
	 }
}
