import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class BankRecords extends Client {
    
	private String id;
	private int age;
	private float income;
	private String married;
	private String car;
	private String save_act;
	private String current_act;
	private String mortgage;
	private String pep;
	private String sex;
	private String region;
	private int children;
	PrintWriter writer = null;
	
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

	public String getMarried() {
		return married;
	}

	public void setMarried(String married) {
		this.married = married;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getSave_act() {
		return save_act;
	}

	public void setSave_act(String save_act) {
		this.save_act = save_act;
	}

	public String getCurrent_act() {
		return current_act;
	}

	public void setCurrent_act(String current_act) {
		this.current_act = current_act;
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

	public ArrayList<String> getRecords() {
		return Records;
	}

	public void setRecords(ArrayList<String> records) {
		Records = records;
	}

	public List<BankRecords> getStore() {
		return Store;
	}

	public void setStore(List<BankRecords> store) {
		Store = store;
	}

	public BankRecords(){}
	

	ArrayList <String> Records = new ArrayList<String>();
	List<BankRecords> Store = new ArrayList<BankRecords>();
	@Override
	public void readData() {
		String line = "";
		try (BufferedReader Br = new BufferedReader(new FileReader("C:/Users/Sudha/workspace/Lab3/src/bank-Detail.csv"))) {
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
		    bankrecord.setMarried(itr.next());
		    bankrecord.setChildren(Integer.parseInt(itr.next()));
		    bankrecord.setCar(itr.next());
		    bankrecord.setSave_act(itr.next());
		    bankrecord.setCurrent_act(itr.next());
            bankrecord.setMortgage(itr.next());
            bankrecord.setPep(itr.next());
            Store.add(bankrecord);         
		}
	}
	
	@Override
	public void printData() {
		System.out.println("ID" + "\t\t" + "Age" + "\t\t" + "Sex" + "\t\t" + "Region" + "\t\t" + "Income" + "\t\t" + "Mortgage");
		for (int i=0; i<=24 && i<Store.size(); i++){
			System.out.println(Store.get(i).getId() + "\t\t" + Store.get(i).getAge() + "\t\t" + Store.get(i).getSex() + "\t\t" + Store.get(i).getRegion() + "\t\t" + Store.get(i).getIncome() + "\t\t" + Store.get(i).getMortgage());
		}
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Cur dt=" + timeStamp + "\nProgrammed by DhruvaJuloori\n");
	}
	
	public static void main(String[] args){
		//BankRecords methodcall = new BankRecords();
		//methodcall.readData();
		//methodcall.processData();
		//methodcall.printData();
	}
}
