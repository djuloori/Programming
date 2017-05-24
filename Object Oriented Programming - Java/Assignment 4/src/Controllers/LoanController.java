package Controllers;

import Records.BankRecords;
import Models.Connector;
import Models.daoModel;
import java.util.*;
import Views.LoanView;

public class LoanController extends BankRecords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		daoModel dao = new daoModel();
		readData();
			
			try {
			new LoanView();
			
			}
			catch (Exception e){
				e.getStackTrace();
			}
		
	}

}