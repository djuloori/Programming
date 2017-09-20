package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import Model.University;

public class UniversityDAO extends DataSource {
	
	public University create(University university){
		
		ResultSet rs = null;
		String query = "INSERT INTO University (university_name) Values (?) ";
		try(
			PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
	            statement.setString(1, university.getUniversity_Name());
	            statement.executeUpdate();
	            rs = statement.getGeneratedKeys();
	        	if(rs.next()) {
	               university.setUniversity_ID(rs.getInt(1));
	        	}
	        	rs.close();
		    }
		 catch(SQLException e){
	        	university = null;
	            System.out.println("Error Creating University: " + e);
	        }
			return university;
	 }

  }
