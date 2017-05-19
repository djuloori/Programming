import java.util.Scanner;

public class MaxPairWiseProduct {
  public static void main(String[] args){
  Scanner input = new Scanner(System.in);
  int n;
  n = input.nextInt();
  long[] numbers = new long[n];
  for (int i = 0; i < numbers.length; i++){
	  numbers[i] = input.nextInt();
  }
  input.close();
  
  int temp = 0;
  long greatest = numbers[0];
  for (int j = 1; j < numbers.length; j++){
	  if (numbers[j] > greatest){
		  greatest = numbers[j];
		  temp = j;
	  }
  }
  
  long secondgreatest = 0;
  for (int m = 0; m < numbers.length; m++){
	  if (numbers[m] > secondgreatest & numbers[m] <= greatest & m != temp ){
		 secondgreatest = numbers[m];
	  }
  }

  long result = greatest * secondgreatest;
  System.out.println(result);  
 }
}