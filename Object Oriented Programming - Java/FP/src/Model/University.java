package Model;

public class University {
	private String University_Name;	
	private Integer University_ID;
	
	public University() {
		
	}
	
	public University (String University_Name, Integer University_ID){
	this.University_Name = University_Name;
	this.University_ID = University_ID;
	
	}

	public String getUniversity_Name() {
		return University_Name;
	}

	public void setUniversity_Name(String university_Name) {
		University_Name = university_Name;
	}

	public Integer getUniversity_ID() {
		return University_ID;
	}

	public void setUniversity_ID(Integer university_ID) {
		University_ID = university_ID;
	}

}