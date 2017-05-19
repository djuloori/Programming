import java.util.Scanner;

public class Fibonaccisum {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		long n = 0;
		if (n>=0 && n<=Math.pow(10, 14)){
			n = input.nextLong();
		}else{
			System.exit(0);
		}
		input.close();
		long[] fib = new long[5000];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 0; i < 60; i++){
			if (i > 1){
				fib[i] = ((fib[i-1]) + (fib[i-2]))%10;
			}
		}
		long m = (n+2)%60;
		long z = fib[(int) m] - 1;
		if ( fib[(int) m] == 0){
			z = 9;
		}
		System.out.println(z);
	}

}
