import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciLastDigit {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
	    long n = input.nextInt();
	    input.close();
	    long[] fib = new long[3273089];
	    fib[0] = 0;
	    fib[1] = 1;
	    if (n >= 0 && n <= 1){
	    	System.out.println(fib[(int) n]);
	    }else{
	    for (int i = 2; i <= fib.length - 2; i++){
	    	fib[i] = (fib[i-1] + fib[i-2]) % 10;
	    	if (i == n){
	    	System.out.println(fib[i]);
	   }
	 }
  }
 }
}
