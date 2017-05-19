import java.util.Scanner;

public class GCD {
	public static void main(String[] args){
     Scanner input = new Scanner(System.in);
     long a = input.nextLong();
	 long b = input.nextLong();	
	 input.close();
		if (a != 0 && b != 0){
			long c;
			while (b!=0){
				c = a%b;
				a = b;
				b = c;
			}
			System.out.println(a);
		}
	}
}
