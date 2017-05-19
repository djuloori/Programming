import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class CollectingSignatures{
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		if (n < 0 || n > 100){
			System.exit(0);
		}
      HashMap<Integer,Integer> startingpoint = new HashMap<Integer,Integer>();
      HashMap<Integer,Integer> endingpoint = new HashMap<Integer,Integer>();
      for (int i = 0; i < n; i++){
    	  startingpoint.put(i, input.nextInt());
    	  endingpoint.put(i, input.nextInt());
      }input.close();  
	int count = 0;
	int min = 0;
	ArrayList<Integer> minimum = new ArrayList<Integer>();
	HashMap<Integer,Integer> deletedindex = new HashMap<Integer,Integer>();
	while (startingpoint.size() != 0 && endingpoint.size() != 0){
	    min = Collections.min(endingpoint.values());
	    minimum.add(min);
	   count++;
	   for (int i = 0; i < n; i++){
		   if(deletedindex.containsKey(i)) continue;
		   if (startingpoint.get(i) <= min && endingpoint.get(i) >= min){
			   startingpoint.remove(i);
			   endingpoint.remove(i);
			   deletedindex.put(i, i);
		   }else{
			   continue;
		   }
	   }
	 }
	System.out.println(count);
	for (int i = 0; i < minimum.size(); i++){
	System.out.println(minimum.get(i));
	 }
	}
}
