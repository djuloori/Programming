package Controller;

import Model.Course;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class ViewCoursesController {
	
	@FXML
	private TableView<Course> courses;

	public void setData(ObservableList<Course> courses) {
		this.courses.setItems(courses);
		
	}

}
