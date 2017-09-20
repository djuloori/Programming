package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Admin;
import Model.Course;
import Model.Student;

public class StudentDAO extends DataSource {

	public Student findbyAdmin(Admin admin){
		Student student = null;
		String query = "SELECT * FROM mainadmin WHERE instructor=0 AND administrator=0;";
		try(
			PreparedStatement statement = connection.prepareStatement(query)){
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				student = new Student();
				student.setId(resultSet.getInt(1));
				student.setAdministrator(false);
				student.setInstructor(false);
				student.setFirstname(resultSet.getString(4));
            	student.setLastname(resultSet.getString(5));
            	student.setCourseid(resultSet.getString(6));
			}
		} catch(SQLException e){
            System.out.println("Error fetching Student: " + e);
        }
		return student;	
	}
	
	public List<Course> getCourses(Student student){
		List<Course> courses = new ArrayList<>();
		String query = "SELECT * FROM course WHERE Course_ID = ?;";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setInt(1, student.getId());
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Course course = new Course();
				course.setId(resultSet.getInt(1));
            	course.setNumber(resultSet.getString(3));
            	courses.add(course);
			}
		} catch(SQLException e){
			System.out.println("Error fetching courses: " + e);
		}
		return courses;
	}
}
