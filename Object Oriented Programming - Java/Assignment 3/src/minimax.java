import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Comparator;

public class minimax extends BankRecords implements Comparator<BankRecords>{

	public minimax() throws FileNotFoundException, UnsupportedEncodingException{
		readData();
		processData();
		writer = new PrintWriter("BankRecords.txt","UTF-8");
	}
	
	@Override
	public int compare(BankRecords br1, BankRecords br2) {
		 if(br1.getIncome() < br2.getIncome()){
	            return 1;} else {
		            return -1;
		        }
		    }
      public void getMinMaxIncome() throws FileNotFoundException, UnsupportedEncodingException{
		BankRecords maxSal = Collections.max(Store, new minimax());
		BankRecords minsal = Collections.min(Store, new minimax());
		System.out.println("Maxmimum Salary is "+minsal.getIncome()+"\n"+"Minimum Salary is "+maxSal.getIncome()+"\n");	
		writer.println("                                                                                 Maxmimum Salary is "+minsal.getIncome()+"\t"+"Minimum Salary is "+maxSal.getIncome()+"\n");
		writer.close();
	}	
}


