package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource implements AutoCloseable {

	protected Connection connection;
    private String url = "jdbc:mysql://www.papademas.net:3306/fp";
    private String username = "dbfp";
    private String password = "510";
    
    public DataSource() {
    	try {
            connection = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            System.out.println("Error creating connection to database: " + e);
            System.exit(-1);
        }
    }
    
	@Override
	public void close() {
    	try {
            connection.close();
            connection = null;
        } catch(SQLException e) {
            System.out.println("Error closing connection: " + e);
        }
	}
}
 