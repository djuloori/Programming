package Model;

import java.util.ArrayList;

public class Student extends Admin {

	  private Department department;
	  private Course course;
	  private String firstname;
	  private String lastname;
	  private ArrayList<Course> courses;
	  private String Courseid;
	  
	public Student() {
		
	}
	  
	public Student(Integer id, String Username, String Password, String name, Boolean Administrator,
			Boolean Instructor, Department department, Course course, String firstname, String lastname) {
		super(id, Username, Password, name, Administrator, Instructor);
		this.department = department;
		this.course = course;
		this.firstname = firstname;
		this.lastname = lastname;		
    }

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public String getCourseid() {
		return Courseid;
	}

	public void setCourseid(String courseid) {
		Courseid = courseid;
	}
		
 }
