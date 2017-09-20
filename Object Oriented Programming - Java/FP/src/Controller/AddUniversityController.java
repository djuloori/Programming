package Controller;

import Component.DialogForm;
import Dao.UniversityDAO;
import Model.University;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddUniversityController extends DialogForm {
	
	@FXML
	private TextField name;

	@Override
	public void save() {
		String name = this.name.getText();
		
		//Validations
		if(name == null || name.trim().equals("")) {
			return;
		}
		
		//Create University in database
				University university = new University();
				university.setUniversity_Name(name);
				;
				try(UniversityDAO u = new UniversityDAO()) {
					u.create(university);
				}
				close();
	}

}
