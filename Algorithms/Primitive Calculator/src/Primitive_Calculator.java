import java.util.Scanner;
import java.util.*;

public class Primitive_Calculator {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();
		DPCalculator(n);
	}
	
	static void DPCalculator (int n){
		int[] arr = new int[n + 1];
		for(int i = 2; i < arr.length; i++){
			arr[i] = arr[i-1] + 1;
			if(i%2==0 && i%3!=0){
				arr[i] = Math.min(arr[i/2] + 1, arr[i]);
			}else if(i%3==0 && i%2!=0){
				arr[i] = Math.min(arr[i/3] + 1, arr[i]);
			}else if(i%3==0 && i%2==0){
				arr[i] = Math.min(arr[i/2] + 1, arr[i]);
				arr[i] = Math.min(arr[i/3] + 1, arr[i]);
			}
	}
	System.out.println(arr[n]);
	Sequence(n,arr);
	}
	
	static void Sequence(int n,int[] A){
		ArrayList<Integer> Seq = new ArrayList<Integer>();
		boolean flag = true;
		while (flag){
		    if (n == 1){
		    	Seq.add(n);
		    	flag = false;
		    }else{
		    	Seq.add(n);
		    	if(A[n] == A[n-1] + 1){
		    		n = n - 1;
		    	}else if(n%3==0){
		    		n = n/3;
		    	}else if(n%2==0){
		    		n = n/2;
		    	}
		    }
		}
		Collections.reverse(Seq);
        for(int i = 0; i < Seq.size(); i++){
        	if (i == 0){
        	System.out.print(Seq.get(i).intValue());
        	}else{
        		System.out.print(" " + Seq.get(i).intValue());
        	}
        }
	}
}
