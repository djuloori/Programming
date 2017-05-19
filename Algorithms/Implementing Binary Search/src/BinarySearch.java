import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch {
 public static void main(String[] args){
	 Scanner input = new Scanner(System.in);
	 int n = input.nextInt();
	 int[] inputs = new int[n];
	 for(int i = 0; i < n; i++){
		 inputs[i] = input.nextInt();
	 }
	 int k = input.nextInt();
	 int[] keys = new int[k];
	 for(int i = 0; i < k; i++){
		 keys[i] = input.nextInt();
	 }input.close();
	 ArrayList<Integer> Store = new ArrayList<Integer>();
	 for (int i = 0; i < k; i++){
		 Store.add(version(inputs, keys[i]));
		 if (i == 0){
			 System.out.print(Store.get(i));
		 }else{
				 System.out.print(" " + Store.get(i));
			 }
		 }
	 }

    public static int version(int[] inputs, int target){
    	return version(inputs, target, 0, inputs.length - 1);
    }
    
    private static int version(int[] inputs,int target, int low, int high){
    	 if (low > high) return -1; 
         int middle = (low + high)/2; 
    	 if (target == inputs[middle]){
    		 return middle;
    	 }else if (target < inputs[middle]){
    		 return version(inputs,target,low,middle-1);
    	 }else if (target > inputs[middle]){
    		 return version(inputs,target,middle+1,high);
    	 }else{
              return -1;
    	 }
    }
}

