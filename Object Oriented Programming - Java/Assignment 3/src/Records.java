import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Records {
	
    public static void main(String[] args){
	try {
		Income income = new Income();
	    femaleinfo info = new femaleinfo();
	    maleinfo info1 = new maleinfo();
	    minimax info2 = new minimax();
		info2.getMinMaxIncome();
	    income.avgIncome();
		info.getFemalesWithMotargageAndSavingAccount();
		info1.getMaleWithChildrenAndCar();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
  }
 }   

