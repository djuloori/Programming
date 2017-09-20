package Model;

public class Department extends University {
	private String Department_ID;
	private String Department_Name;
	
	public Department(){
		
	}
	
	public Department(String Department_ID, String Department_Name){
		this.Department_ID = Department_ID;
		this.Department_Name = Department_Name;
	}

	public String getDepartment_ID() {
		return Department_ID;
	}

	public void setDepartment_ID(String Department_ID) {
		this.Department_ID = Department_ID;
	}

	public String getDepartment_Name() {
		return Department_Name;
	}

	public void setDepartment_Name(String department_Name) {
		Department_Name = department_Name;
	}
	
}
