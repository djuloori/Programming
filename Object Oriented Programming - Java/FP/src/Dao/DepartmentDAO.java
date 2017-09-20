package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Model.Department;

public class DepartmentDAO extends DataSource {
	
	public Department create (Department department) {
		
		String query = "insert into department (Department_ID, Department_Name) VALUES (?,?);";
		try(
			PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			statement.setString(1, department.getDepartment_ID());
			statement.setString(2, department.getDepartment_Name());
			
			statement.executeUpdate();
			ResultSet resultSet = statement.getGeneratedKeys();
		   }
		 catch(SQLException e){
	        	department = null;
	            System.out.println("Error Creating department: " + e);
	        }	
		return department;		
	}

}
