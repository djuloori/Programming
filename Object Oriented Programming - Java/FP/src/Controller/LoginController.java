package Controller;

import Dao.LoginDAO;
import Model.Admin;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import main.Main;


public class LoginController extends Main {
	
	private static Admin admin;
		
	@FXML
	private Label lblStatus; 
	
	@FXML
	private TextField txtUsername;
	
	@FXML
	private TextField txtPassword;
	
	public void Login() {
		Admin a;
		String username = this.txtUsername.getText();
		String password = this.txtPassword.getText();
		if (username == null || username.trim().equals("")) {
			lblStatus.setText("Username Cannot be empty or spaces");
			return;
		}
		if (password == null || password.trim().equals("")) {
			lblStatus.setText("Password Cannot be empty or spaces");
			return;
		}
		
		LoginDAO l = new LoginDAO();
		a = l.findByUsername(username);
		l.close();
		
		if(a == null) {
			lblStatus.setText("Username cannot be found");
			return;
		}
		
		
		if(!(a.getPassword().equals(password.trim()))) {
			lblStatus.setText("Username and Password dont match");
			return;
		}
	 
		admin = a;
		try {
			
			AnchorPane root = null;
			if (admin.isAdministrator() || admin.isInstructor()) {
				//if admin is Administrator, inflate Administrator view
				if (admin.isAdministrator()){
					root = (AnchorPane)FXMLLoader.load(getClass().getResource("/Views/Administrator.fxml"));
				}
				else{
				//if admin is Instructor, inflate Instructor view
				if (admin.isInstructor()){
					root = (AnchorPane)FXMLLoader.load(getClass().getResource("/Views/Instructor.fxml"));
				}
			}
			}
				
				else{
					//if a is Student, inflate Student view
					root = (AnchorPane)FXMLLoader.load(getClass().getResource("/Views/Student.fxml"));
				}
				Scene scene = new Scene(root);
				Main.stage.setScene(scene);
				Main.stage.setTitle("Home");
				
			}catch(Exception e){
				System.out.println("Error occured while inflating view: " + e);	
				}
			
			}
	
	public static Admin getAdmin() {
		return admin;
	}
	
	public static void logout() {
        admin = null;
	} 
	
}
