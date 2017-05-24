package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector{
	
	public Connection getConnection() {
		
		Connection connect  = null;
		try	{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://www.papademas.net:3306/510labs" , "db510" , "510");			
		    System.out.println("Logged on to the system");
	       }
		catch(SQLException e) {
		System.out.println(e.getMessage());
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}		
		
		return connect;
	}
}
