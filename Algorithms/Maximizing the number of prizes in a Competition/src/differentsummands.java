import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class differentsummands {
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	int n = input.nextInt();
		input.close();
		if (n < 0 && n > Math.pow(10, 9)){
			System.exit(0);
		}
	   int min = 1;
	   ArrayList<Integer> Store = new ArrayList<Integer>();
	   HashMap<Integer,Integer> Map = new HashMap<Integer,Integer>();
	   while (n!=0){
		   if (Map.get(n)!= null){
			   n = n + min-1;
			   Store.set(Store.size() - 1, n);   
			   n = 0;
		   } else {
		  Store.add(min);
		  Map.put(min,min);
		      n = n - min;
			  min++;
		   }  
	  }
	  System.out.println(Store.size());
	   for (int i = 0; i < Store.size(); i++){
		   if (i == 0){
		  System.out.print(Store.get(i));
		   } else {
			   System.out.print(" " + Store.get(i));
		   }
	   }
  }
}