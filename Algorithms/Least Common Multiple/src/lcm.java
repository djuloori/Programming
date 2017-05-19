import java.util.Scanner;

public class lcm {
	public static void main (String[] args){
	Scanner input = new Scanner(System.in);
    long a = input.nextInt();
    long b = input.nextInt();
    long m = a * b;
    input.close();
    if (a!= 0 && b!= 0){
    	long c;
    	while (b!=0){
    		c = a%b;
    		a = b;
    		b = c;
    	}
    System.out.println(m/a);
    }
 }
}