package Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import main.Main;

public class DepartmentController {
	
	private Boolean locked = false;
	
	public void createDepartment() {
		if(locked) {
			return;
		}
		locked = true;
		try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/AddDepartment.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Department");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            	public void handle(WindowEvent we) {
                	locked = false;
                }
            });
            Scene scene = new Scene(root);
            dialogStage.setScene(scene);
            AddDepartmentController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            dialogStage.show();
		} catch(Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}
	
	public void createCourse() {
		if(locked) {
			return;
		}
		locked = true;
		try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/AddCourse.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Course");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            	public void handle(WindowEvent we) {
                	locked = false;
                }
            });
            Scene scene = new Scene(root);
            dialogStage.setScene(scene);
            AddCourseController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            dialogStage.show();
		} catch(Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
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
