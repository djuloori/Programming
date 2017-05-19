import java.util.ArrayList;
import java.util.Scanner;

public class Fibonaccimodulus {
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
    long n ;
    long m;
    n = input.nextLong();
	m = input.nextLong();
	input.close();
    if(n <= 1 && n >= Math.pow(10,18) && m <=2 && m >= Math.pow(10, 5)){
    	System.exit(0);
    } 
    long[] fib = new long[(int) (n+5)];
    fib[0] = 0;
    fib[1] = 1;
    int count = 2;
    for (int i = 2 ; i < n + 3; i++){
    	fib[i] = (fib[i-1] + fib[i-2])%m;
    	fib[i+1] = (fib[i] + fib[i-1])%m;
    	count++;
    	if (fib[i] == 0 && fib[i+1] == 1){
    		break;
    	}
    }
    System.out.println(fib[(int) (n%count)]%m);
 }
}