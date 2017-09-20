package Controller;

import Component.DialogForm;
import Dao.DepartmentDAO;
import Model.Department;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddDepartmentController extends DialogForm {
	
	@FXML
	private TextField DptName;
	
	@FXML
	private TextField DptID;
	
	@Override
	public void save() {
		String DptName = this.DptName.getText();
		String DptID = this.DptID.getText();
		//Validations
				if(DptName == null || DptName.trim().equals("")) {
					return;
				}
				if(DptID == null || DptID.trim().equals("")) {
					return;
				}
		//Update Department in DataBase
				Department department = new Department();
				department.setDepartment_Name(DptName);
				department.setDepartment_ID(DptID);
				try(DepartmentDAO a = new DepartmentDAO()){ 
				 a.create(department);
				}
				close();
	 }
	}


