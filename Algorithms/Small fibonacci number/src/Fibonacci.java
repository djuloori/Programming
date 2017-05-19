import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    input.close();
    int[] fib = new int[50];
    fib[0] = 0;
    fib[1] = 1;
    if (n >= 0 && n <= 1){
    	System.out.println(fib[n]);
    }else{
    for (int i = 2; i <= fib.length - 2; i++){
    	fib[i] = fib[i-1] + fib[i-2];
    	if (i == n){
    		System.out.println(fib[i]);
    	}
    }
   }
  }
}
