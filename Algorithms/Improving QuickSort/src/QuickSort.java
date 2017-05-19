import java.util.*;

public class QuickSort {
	public static void main(String[] args){
	   Scanner input = new Scanner(System.in);
	   int n = input.nextInt();
	   int[] values = new int[n];
	   for(int i = 0; i < n; i++){
		   values[i] = input.nextInt();
	   }input.close();
       quicksort(values, 0, values.length - 1);
       for(int i = 0; i < values.length; i++){
		   if (i == 0){
			   System.out.print(values[i]);   
		   }
		   else
			   System.out.print(" " + values[i]);
	   }
	}
	
   static void quicksort(int[] values, int low, int high){
	   if (high <= low || low < 0 || high < 0){
		   return;
	   }
	   int pivot = values[high];
	   int pindex = low, pindex2 = high;
	   for(int i = low; i <= pindex2; i++){
		   if (values[i] < pivot){
			   swap(values,pindex,i);
			   pindex++;
		   } 
		   else if(values[i] > pivot){
			   swap(values, i, pindex2);
			   pindex2--;
			   i=i-1;
		   } 
		   else {
			   continue;
		   }
	   }
	   quicksort(values,low,pindex-1);
	   quicksort(values,pindex2+1,high);
   }
	
	static void swap (int[] values, int a, int b){
		int temp = 0;
		temp = values[a];
		values[a] = values[b];
		values[b] = temp;
	}
}
 