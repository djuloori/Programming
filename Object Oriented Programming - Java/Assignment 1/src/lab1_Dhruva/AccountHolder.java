package lab1_Dhruva;

public class AccountHolder {
	private double annualInterestRate;
	private double balance;
	
	public AccountHolder(double initialbalance){
        if (balance >= 0){    
    	balance = initialbalance;}
        else{
        	System.out.println("Balance cannot be negative");
        }
    }
	
	public double getbalance(){
		return balance;
	}
    
    public void monthlyInterest(){
    	balance += balance * (annualInterestRate / 12.0);
    }
    
    public void modifymonthlyInterest(double rateupdate){
    	if (rateupdate >= 0.0 &&  rateupdate <= 1.0){
    	annualInterestRate = rateupdate;}
    }
    			
    public void deposit(double amount){
    	balance = balance + amount;
    }
    
    public void withdraw(double amount){
    	balance = balance - amount;
    	if (balance < 100){
    		System.out.println("Low Balance");}
    	if (balance < 500){
    	    balance = balance - 50;}
    	}
    
   public String toString(){
	   return String.format("$%.2f", balance);}
   }
    
    
    
    

