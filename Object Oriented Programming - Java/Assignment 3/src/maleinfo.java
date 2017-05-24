import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class maleinfo extends BankRecords{
	static int males = 0;
	
	public maleinfo() throws FileNotFoundException, UnsupportedEncodingException{
		readData();
		processData();
		writer = new PrintWriter("BankRecords.txt","UTF-8");
	}

	public void getMaleWithChildrenAndCar(){
		
		for (int i=0;i<Store.size();i++){
			if(Store.get(i).getChildren()>0&&Store.get(i).getCar().contains("YES")&&
					Store.get(i).getSex().contains("MALE")){
				males++;
			}
		}
		System.out.println("\n Male Count "+males);
		writer.println("Male Count "+males);
		writer.close();
	}
}
