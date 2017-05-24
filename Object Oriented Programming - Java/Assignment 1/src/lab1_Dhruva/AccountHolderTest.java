package lab1_Dhruva;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class AccountHolderTest {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the initial balance");
		double initialbalance = input.nextDouble();
		AccountHolder bank = new AccountHolder(initialbalance); 
	
	
	System.out.println("Enter the amount to be deposited");
	double deposits = input.nextDouble();
	bank.deposit(deposits);
	
	System.out.println("Enter the amount for withdrawl");
	double withdrawl = input.nextDouble();
	bank.withdraw(withdrawl);
	
	bank.modifymonthlyInterest(0.04);
	System.out.println("Monthly Balances for one year at .04");
	
	for (int i=1; i<=12; i++){
		bank.monthlyInterest();
		double info = bank.getbalance();
		System.out.println("Month" + " " + i + ":" + "    " +info);
		}
	
	System.out.println("After setting interest rate to .05 and calculating monthly interest Balances:");
	System.out.println("Account Balance w. Interest");
	bank.modifymonthlyInterest(0.05);

	System.out.println(bank);
	String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
    System.out.println("Cur dt=" + timeStamp + "\nProgrammed by PrathyushaReddy\n");

    }
}
