package bank;

import java.io.Serializable;
import java.util.ArrayList;

public class Owner implements Serializable{
	private String name;
	private String nif;
	private String code_owner;
	private ArrayList<Account>myAccounts;
	
	//ALL PARAMS CONTRUCTOR
	public Owner(String name,String code_owner, String nif, ArrayList<Account> myAccounts) {
		super();
		this.name = name;
		this.code_owner=code_owner;
		this.nif = nif;
		this.myAccounts = myAccounts;
	}
	//3 PARAMS CONSTRUCTOR (NO ACCOUNT ARRAYLIST)
	public Owner(String name,String code_owner, String nif) {
		super();
		this.name = name;
		this.code_owner=code_owner;
		this.nif = nif;
		this.myAccounts = new ArrayList<Account>();
	}
	
	//GETTERS ANS SETTERS
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode_owner() {
		return code_owner;
	}
	public void setCode_owner(String code_owner) {
		this.code_owner = code_owner;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}

	public ArrayList<Account> getMyAccounts() {
		return myAccounts;
	}
	public void setMyAccounts(ArrayList<Account> myAccounts) {
		this.myAccounts = myAccounts;
	}
	
	//TO STRING
	@Override
	public String toString() {
		return "Owner [name=" + name + ", nif=" + nif + ", code_owner=" + code_owner + ", myAccounts=" + myAccounts
				+ "]";
	}
	
//	public static void main(String[] args) {
//		
//		Owner own =new Owner("Javer","501" "04857857G");
//		
//		Account a1=new Account("Ahorros", "0000", 2000);
//		Account a2=new Account("Nomina", "1111", 32000);
//		own.myAccounts.add(a1);
//		own.myAccounts.add(a2);
//		
//		for (Account a : own.myAccounts) {
//			System.out.println(a.getName()+" "+a.getAmount());
//		}
//		
//		
//	}
	
}
