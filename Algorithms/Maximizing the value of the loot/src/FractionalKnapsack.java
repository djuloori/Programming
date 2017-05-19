import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class FractionalKnapsack {
	public static void main(String args[]){
	Scanner input = new Scanner(System.in);
	int n = input.nextInt();
	int capacity = input.nextInt();	
	ArrayList<Integer> values = new ArrayList<Integer>();	
	HashMap<Integer,Integer> weights = new HashMap<Integer,Integer>();
	HashMap<Integer,Double> valperweight = new HashMap<Integer,Double>();
	for(int i = 0; i < n; i++){
			values.add(input.nextInt());
			weights.put(i,input.nextInt());
			double ratio = (double) values.get(i)/weights.get(i);
			valperweight.put(i,ratio);
		}
		input.close();
	double value = 0;
	while (capacity > 0 && weights.size()!=0){
		int key = Collections.max(valperweight.entrySet(), Map.Entry.comparingByValue()).getKey();
		if (weights.get(key) <= capacity){
			capacity-= weights.get(key);
			value+= (double) values.get(key);
		}else{
			value+=(double)capacity*valperweight.get(key);
			capacity = 0; 
		}
		valperweight.remove(key);
		weights.remove(key);
	 }System.out.printf("%.4f",value);
	}    
} 
