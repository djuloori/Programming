import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Income extends BankRecords {

	public Income () throws FileNotFoundException, UnsupportedEncodingException{
		readData();
		processData();
		writer = new PrintWriter("BankRecords.txt","UTF-8");
	}
	
	public void avgIncome(){
		 double sum = 0;
		  double avgincome;
		  for (int i = 0; i < Store.size(); i++){
			  sum += Store.get(i).getIncome();
		  }
		  avgincome = sum/Store.size();
		  System.out.println("Average Income Per Location :" +avgincome);
		  writer.println("                                 Average Income Per Location :" +avgincome);
		  writer.close();
	  }
	
}
