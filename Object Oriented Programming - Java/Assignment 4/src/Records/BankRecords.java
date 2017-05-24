package Records;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.lang.String;

public class BankRecords implements Client {
	static List<List<String>> Records = new ArrayList<>();;

    private String id;
	private int age;
	private String sex;
	private double income;
	private String region;
	private String marriage; 
	private int children;
	private String car;
	private String saveact;
	private String currentact;
	private String mortgage;
	private String pep;
    
    	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double d) {
		this.income = d;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getSaveact() {
		return saveact;
	}

	public void setSaveact(String saveact) {
		this.saveact = saveact;
	}

	public String getCurrentact() {
		return currentact;
	}

	public void setCurrentact(String currentact) {
		this.currentact = currentact;
	}

	public String getMortgage() {
		return mortgage;
	}

	public void setMortgage(String mortgage) {
		this.mortgage = mortgage;
	}

	public String getPep() {
		return pep;
	}

	public void setPep(String pep) {
		this.pep = pep;
	}	
	
	public static void readData() {
		String line = "";
		try (BufferedReader Br = new BufferedReader(new FileReader("bank-Detail.csv"))) {
		    int i = 0;
			while((line=Br.readLine())!= null){	
			Records.add(Arrays.asList(line.split(",")));
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
	static ArrayList<BankRecords> GetRecords = new ArrayList<BankRecords>();
	
	public static void processData() {
		BankRecords client = new BankRecords();
        for (List<String> rawData : Records){
		client.setAge(Integer.parseInt(rawData.get(1)));
		client.setCar(rawData.get(8));
		client.setCurrentact(rawData.get(10));
		client.setId(rawData.get(0));
		client.setIncome(Double.parseDouble(rawData.get(4)));
		client.setMarriage(rawData.get(6));
		client.setMortgage(rawData.get(5));
		client.setPep(rawData.get(11));
		client.setRegion(rawData.get(3));
		client.setSaveact(rawData.get(9));
		client.setSex(rawData.get(2));
		GetRecords.add(client);
			}
		}
		
	
	public static void printData() {
		/*System.out.printf("%s%10s%5s%15s%10s\n", "ID", "AGE", "SEX", "REGION", "INCOME", "MORTGAGE");    
        for (int i = 0; i < GetRecords.size() && i < 25; i++){  
            BankRecords clients = (BankRecords) GetRecords.get(i);  
            System.out.printf("%s%4d%8s%15s%10.2f\n", clients.getId(), clients.getAge(), clients.getSex(),clients.getRegion(),clients.getIncome(),clients.getMortgage());*/

        
		
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println("Cur dt=" + timeStamp + "\nProgrammed by Dhruva Juloori\n" + "ITMD 510 Lab 4");

	}
	
	public static void main (String[] args){
    	BankRecords call = new BankRecords();
    	call.readData();
    	call.processData();
    	call.printData();
    }
	
	
}	