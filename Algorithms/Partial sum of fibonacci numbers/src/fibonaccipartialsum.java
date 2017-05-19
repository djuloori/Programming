import java.util.Scanner;

public class fibonaccipartialsum {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		long m = 0;
		long n = 0;
		if (m >= 0 && m <= Math.pow(10,18) && n>=0 && n <= Math.pow(10,18) && m <= n){
			m = input.nextLong();
			n = input.nextLong();
		}else{
			System.exit(0);
		}
		input.close();
		int[] fib = new int[60];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i < 60; i++){
				fib[i] = (fib[i-1] + fib[i-2])%10;
		}
		int x = fib[(int) ((n+2)%60)];
		int y = fib[(int) ((m+2)%60)];		
	    System.out.println((x - y + 10 + fib[(int) (m%60)])%10);
	}

}

