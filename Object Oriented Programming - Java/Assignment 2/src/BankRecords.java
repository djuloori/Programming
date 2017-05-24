import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class BankRecords extends Client {
    private String id;
	private int age;
	private float income;
	private Boolean married;
	private Boolean car;
	private Boolean save_act;
	private Boolean current_act;
	private Boolean mortgage;
	private Boolean pep;
	private String sex;
	private String region;
	private int children;
	
	public BankRecords(){}
	
	public BankRecords(String id, int age, float income, Boolean married, Boolean car, Boolean save_act, Boolean current_act, Boolean mortgage, Boolean pep, String sex, String region, int children){
	this.id = id;
	this.age = age;
	this.income = income;
	this.married = married;
	this.car = car;
	this.save_act = save_act;
	this.current_act = current_act;
	this.mortgage = mortgage;
	this.pep = pep;
	this.sex = sex;
	this.region = region;
	this.children = children;
	}
	
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

	public float getIncome() {
		return income;
	}

	public void setIncome(float income) {
		this.income = income;
	}

	public Boolean isMarried() {
		return married;
	}

	public void setMarried(Boolean married) {
		this.married = married;
	}

	public Boolean isCar() {
		return car;
	}

	public void setCar(Boolean car) {
		this.car = car;
	}

	public Boolean isSave_act() {
		return save_act;
	}

	public void setSave_act(Boolean save_act) {
		this.save_act = save_act;
	}

	public Boolean isCurrent_act() {
		return current_act;
	}

	public void setCurrent_act(Boolean current_act) {
		this.current_act = current_act;
	}

	public Boolean isMortgage() {
		return mortgage;
	}

	public void setMortgage(Boolean mortgage) {
		this.mortgage = mortgage;
	}

	public Boolean isPep() {
		return pep;
	}

	public void setPep(Boolean pep) {
		this.pep = pep;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	ArrayList <String> Records = new ArrayList<String>();
	List<BankRecords> Store = new ArrayList<BankRecords>();
	@Override
	public void readData() {
		String line = "";
		try (BufferedReader Br = new BufferedReader(new FileReader("C:/Users/Sudha/workspace/Lab2/src/bank-Detail.csv"))) {
			while((line=Br.readLine())!= null)
			{
				Records.addAll(Arrays.asList(line.split(",")));	
			}
			} catch (IOException e) 
		{
				e.printStackTrace();
		}
	}
    
	@Override
	public void processData() {
		Iterator<String> itr = Records.iterator();
		while (itr.hasNext()){
		    BankRecords	bankrecord = new BankRecords();
			bankrecord.setId(itr.next());
			bankrecord.setAge(Integer.parseInt(itr.next()));
			bankrecord.setSex(itr.next());
			bankrecord.setRegion(itr.next());
			bankrecord.setIncome(Float.parseFloat(itr.next()));
		    bankrecord.setMarried(Boolean.valueOf(itr.next()));
		    bankrecord.setChildren(Integer.parseInt(itr.next()));
		    bankrecord.setCar(Boolean.valueOf(itr.next()));
		    bankrecord.setSave_act(Boolean.valueOf(itr.next()));
		    bankrecord.setCurrent_act(Boolean.valueOf(itr.next()));
            bankrecord.setMortgage(Boolean.valueOf(itr.next()));
            bankrecord.setPep(Boolean.valueOf(itr.next()));
            Store.add(bankrecord);         
		}
	}
	
	@Override
	public void printData() {
		System.out.printf("%s%15s%17s%20s%18s%16s\n", "ID", "Age", "Sex", "Region", "Income", "Mortgage");
		System.out.println("===========================================================================================");
		for (int i=0; i<=24 && i<Store.size(); i++){
		   System.out.printf("%7s%10d%19s%20s%17.2f%12s\n", Store.get(i).getId(), Store.get(i).getAge(), Store.get(i).getSex(), Store.get(i).getRegion(), Store.get(i).getIncome(), Store.get(i).isMortgage()); 
		}System.out.println("===========================================================================================");
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Cur dt=" + timeStamp + "\nProgrammed by DhruvaJuloori\n");
	}
	
	public static void main(String[] args){
		BankRecords methodcall = new BankRecords();
		methodcall.readData();
		methodcall.processData();
		methodcall.printData();
	}
}
