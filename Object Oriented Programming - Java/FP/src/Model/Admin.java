package Model;

public class Admin {
	
	private Integer id;
	private String Username;
	private String Password;
	private String name;
	private Boolean Administrator;
	private Boolean Instructor;
	
	public Admin() {
		
	}
	
	public Admin(Integer id, String Username, String Password, String name, Boolean Administrator, Boolean Instructor) {
		this.id = id;
		this.Username = Username;
		this.Password = Password;
		this.name = name;
		this.Administrator = Administrator;
		this.Instructor = Instructor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean isAdministrator() {
		return Administrator;
	}

	public void setAdministrator(Boolean administrator) {
		Administrator = administrator;
	}

	public Boolean isInstructor() {
		return Instructor;
	}

	public void setInstructor(Boolean instructor) {
		Instructor = instructor;
	}
		
}
