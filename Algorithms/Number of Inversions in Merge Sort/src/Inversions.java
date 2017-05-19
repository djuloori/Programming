import java.util.*;

public class Inversions {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		long[] values = new long[n];
		for(int i = 0; i < n; i++){
			values[i] = input.nextInt();
		}input.close();
	    System.out.print(sortcount(values)); 
	}
	
	static long sortcount(long[] values){
		   int n = values.length;
		   long inv_count = 0;
		   if(n >= 2){
			   int mid = n/2;
			   long[] left = new long[mid];
			   long[] right = new long[n - mid];
			   for(int i = 0; i < mid; i++){
				   left[i] = values[i];
			   }
			   for(int j = mid; j < values.length; j++){
				    right[j-mid] = values[j];   
			   }
			   inv_count = sortcount(left);
			   inv_count+= sortcount(right);
			   inv_count+= merge(left,right,values);
		   }
		return inv_count;
		}
		
		static long merge(long[] left, long[] right, long[] values){
			int x = 0;
			int y = 0;
			int z = 0;
			long inv_count = 0;
			while(x < left.length && y < right.length){
				if (left[x] <= right[y]){
					values[z] = left[x];
					x++;
					z++;
				}
				else{                                 
					inv_count+= left.length - x;
					values[z] = right[y];
					y++;
					z++;
				}
			}
			
			while(x < left.length){
				values[z] = left[x];
				z++;
				x++;
			}
			
			while(y < right.length){
				values[z] = right[y];
				z++;
				y++;
			}
				return inv_count;
		}
}