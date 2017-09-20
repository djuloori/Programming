package Controller;

import java.util.List;


import Dao.StudentDAO;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import main.Main;
import Model.Course;
import Model.Student;

public class StudentController  {
	
	private Boolean locked = false;
	
	public void viewCourses(){
		if (locked){
			return;
		}
		locked = true;
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/ViewCourses.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
            dialogStage.setTitle("View Courses");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent event) {
				    locked = false;	
				}
            });	
            Scene scene = new Scene(root);
            dialogStage.setScene(scene);	
            ViewCoursesController controller = loader.getController();
            List<Course> courses;
            try(StudentDAO s = new StudentDAO()) {
            	Student student = s.findbyAdmin(LoginController.getAdmin());
            	courses = s.getCourses(student);
            }
            controller.setData(FXCollections.observableArrayList(courses));
            dialogStage.show();         
		}catch(Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}
	
	public void joinCourse() {
		//TODO - Code for adding a new Transaction
	}

	
	public void logout() {
		try {
			LoginController.logout();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/Views/Login.fxml"));
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.setTitle("Login");
		} catch(Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}

}
