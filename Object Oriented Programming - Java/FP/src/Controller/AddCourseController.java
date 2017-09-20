package Controller;

import Component.DialogForm;
import Dao.CourseDAO;
import Model.Course;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddCourseController extends DialogForm {
	
	@FXML
	private TextField coursename;

	@FXML
	private TextField courseid;
	
	@Override
	public void save() {
		String coursename = this.coursename.getText();
		String courseid = this.courseid.getText();
		//Validations
		if(coursename == null || coursename.trim().equals("")) {
			return;
		}
		if(courseid == null || courseid.trim().equals("")) {
			return;
		}
	//Update Course in DataBase
		Course course = new Course();
		course.setCourse_Name(coursename);
		course.setCourse_ID(courseid);
		try(CourseDAO b = new CourseDAO()){
			b.create(course);
		}
		close();
	}
	
}

