package Dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Admin;


public class LoginDAO extends DataSource {
	
	public Admin findByUsername(String username) {
		Admin admin = null;
		String query = "SELECT * FROM mainadmin WHERE username = ?;";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
            	admin = new Admin(
            			resultSet.getInt("id"),
            			resultSet.getString("Username"),
            			resultSet.getString("Password"),
            			resultSet.getString("name"),
            			resultSet.getBoolean("Administrator"),
            			resultSet.getBoolean("Instructor")
            			);
            }
        } catch(SQLException e){
            System.out.println("Error Finding User by Username: " + e);
        }
        return admin;
    }
}
