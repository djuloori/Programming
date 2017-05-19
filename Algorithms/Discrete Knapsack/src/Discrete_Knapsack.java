import java.util.Scanner;

public class Discrete_Knapsack {
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	int W = input.nextInt();
	int n = input.nextInt();
	int[] weights = new int[n];
	for(int i = 0; i < weights.length; i++){
		weights[i] = input.nextInt();
	}input.close();
	System.out.println(knapsack(W,n,weights));
	}
	
	static int knapsack(int W, int n, int[] weights){
		int[][] result = new int[n+1][W+1];
		for(int i = 0; i < n + 1; i++){
		 for(int j = 0; j < W + 1; j++){
			if(i==0 || j==0){
				result[i][j] = 0;
			}
				
			
		 }
		}
		return 0;
	}
}
