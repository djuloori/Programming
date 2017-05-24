import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class femaleinfo extends BankRecords {
	static int females = 0;
	
	public femaleinfo() throws FileNotFoundException, UnsupportedEncodingException{
		readData();
		processData();
		writer = new PrintWriter("BankRecords.txt","UTF-8");
	}

	public void getFemalesWithMotargageAndSavingAccount(){
		for (int i=0;i<Store.size();i++){
			if(Store.get(i).getSave_act().contains("YES")&&Store.get(i).getMortgage().contains("YES")&&
					Store.get(i).getSex().contains("FEMALE")){
				females++;
			}
		}
		System.out.println("\n Female Count "+females);
		writer.println("                Female Count "+females);
		writer.close();
	}

}
