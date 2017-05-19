import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class maxrev {
	public static void main(String[] args){
	 Scanner input = new Scanner(System.in);
	 int n = input.nextInt();
	 HashMap<Integer,Long> profitperclick = new HashMap<Integer,Long>();
	 HashMap<Integer,Long> avgnoofclicks = new HashMap<Integer,Long>();
	 for(int i = 0; i < n; i++){
		 profitperclick.put(i, input.nextLong());
	 }
	 for(int i = 0; i < n; i++){
		 avgnoofclicks.put(i, input.nextLong());
	 }input.close();
	 long temp = 0;
	 while (profitperclick.size()!=0 && avgnoofclicks.size()!=0){
		int key1 = Collections.max(profitperclick.entrySet(), Map.Entry.comparingByValue()).getKey();
		int key2 = Collections.max(avgnoofclicks.entrySet(), Map.Entry.comparingByValue()).getKey();
		 temp += profitperclick.get(key1) * avgnoofclicks.get(key2);
		 profitperclick.remove(key1);
		 avgnoofclicks.remove(key2);
	 }System.out.println(temp);
	}
}
