package Model;

public class Course extends University {
	
	private String number;
	private Integer id;
	private Student student;
	private String Course_Name;
	private String Course_ID;

	public Course(){
		
	}
	
	public Course(String number, Integer id, Student student){
		this.number = number;
		this.id = id;
		this.student = student;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getCourse_Name() {
		return Course_Name;
	}

	public void setCourse_Name(String course_Name) {
		Course_Name = course_Name;
	}

	public String getCourse_ID() {
		return Course_ID;
	}

	public void setCourse_ID(String course_ID) {
		Course_ID = course_ID;
	}
	
}