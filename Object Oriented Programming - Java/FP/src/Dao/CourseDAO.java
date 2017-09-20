package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Model.Course;

public class CourseDAO extends DataSource {
	
	public Course create (Course course) {
		
		String query = "insert into course (Course_ID, Course_Name) VALUES (?,?);";
		try(
			PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			statement.setString(1, course.getCourse_ID());
			statement.setString(2, course.getCourse_Name());	
			
			statement.executeUpdate();
			ResultSet resultSet = statement.getGeneratedKeys();
		   }
		catch(SQLException e){
        	course = null;
            System.out.println("Error Creating course: " + e);
		}
		return course;	
	}
}
