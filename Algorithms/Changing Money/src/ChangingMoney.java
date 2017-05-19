import java.util.Scanner;

public class ChangingMoney {
	public static int getchange(int n){
	 int x = n/10;
	 int y = n%10;
	 int m = 0;
	 int a = 0;
	 int k = 0;
	 if (y!=0){
		  a = y/5;
		 int b = y%5;
		  if (b!= 0){
			   k = b/1;
		  }
		 }
	 m = x + a + k;
	return m; 
	}
	
	   public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();
		if (n > 0){
		System.out.println(getchange(n));
		}else{
			System.exit(0);
		}
	}

}
