package bank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
	/**
	 * App CLASS THAT HAS OWNER ARRAYLIST AS UNIQUE PARAM
	 */
	private ArrayList<Owner>myOwners;
	
	/**
	 * ALL PARAMS CONSTRUCTOR
	 * @param myOwners
	 */
	public App(ArrayList<Owner> myOwners) {
		super();
		this.myOwners = myOwners;
	}
	/**
	 * EMPTY DEAFULT CONSTRUCTOR
	 * @param myOwners
	 */
	
	public App() {
		super();
		this.myOwners = new ArrayList<Owner>();
	}
	
	/**
	 * GETTERS AND SETTERS
	 */
	public ArrayList<Owner> getMyOwners() {
		return myOwners;
	}
	public void setMyOwners(ArrayList<Owner> myOwners) {
		this.myOwners = myOwners;
	}
	
	/**
	 * TO STRING METHOD
	 */
	@Override
	public String toString() {
		return "App [myOwners=" + myOwners + "]";
	}
	
	public static void main(String[] args) {
		/**
		 * CREATING:
		 * OBJECT FROM App,
		 * OBJECT FROM Scanner TO GET USER DATA
		 * Int VARIABLE AS OPTION TO CHOOSE AN OPTION FROM MENU
		 */
		App app=new App();
		Scanner in=new Scanner(System.in);
		int option=0;
		/**
		 * CALLING METHOD TO FILL ARRAYLIST FROM OBJECT FILE Owner 
		 */
		app.arrayListFiller();
		app.accountFiller();
		
		do {
			/**
			 * OPTION TO CONTINUE
			 */
			System.out.println("Do you want to go ahead?");
			System.out.println("Tip 1 for yes");
			System.out.println("Tip 2 for no");
			option=in.nextInt();
			/**
			 * SAVE NIF IN A STRING
			 */
			if(option==1) {
			System.out.println("Tip your NIF");
			String nif=in.next();
			
			/**
			 * CALLING METHOD TO GET OWNER´S ACCOUNT COMPARING NIF
			 */
			
			app.getAccounts(nif);
			}
			
			
			
		}while(option!=2);
		
		/**
		 * CALLING METHOD TO SAVE ALL MODIFIES ON Owners´s Account
		 */
		app.saveAccountsInfo();
	}
	
	/**
	 * METHOD TO SAVE ALL MODIFIES ON Owners´s Account
	 */
	private void saveAccountsInfo() {
		for (Owner o : this.myOwners) {
			try {
				PrintWriter pr=new PrintWriter(new File(o.getCode_owner()+"_"+o.getName()+o.getNif()+"Accounts.txt"));
				pr.println("Name;Code_Owner;Key;Amount");
				for (Account a : o.getMyAccounts()) {
					pr.println(a.getName()+";"+a.getcode_owner()+";"+a.getKeyAccount()+";"+a.getAmount());
					
				}
				pr.flush();
				pr.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * METHOD TO FILL EACH Account ATTAYLIST FOR EACH Owner
	 */
	private void accountFiller() {
		/**
		 * LOOP THROUGH Owner ARRAYLIST
		 */
		for (Owner o : this.myOwners) {
			/**
			 * CREATE FILE TO GET ACCOUNTS INFO
			 */
			try {
				Scanner in5=new Scanner(new File(o.getCode_owner()+"_"+o.getName()+o.getNif()+"Accounts.txt"));
				String line="";
				String[] fields;
				/**
				 * WASTE FIRST LINE BE CAUSE HAS NOT RELEVANT INFO
				 */
				in5.nextLine();
				while(in5.hasNext()) {
					line=in5.nextLine();
					fields=line.split(";");
					o.getMyAccounts().add(new Account(fields[0], fields[1], fields[2], Double.parseDouble(fields[3])));
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * METHOD TO FILL Owner ARRAYLIST FROM "owners.bin"
	 */
	public void arrayListFiller() {
		try {
			/**
			 * CREATE FileInputStearm OBJECT TO UPLOAD INFO FILE
			 * CREATE ObjectInputStream OBJECT TO READ FILE "owners.bin"
			 */
			FileInputStream fis=new FileInputStream("owners.bin");
			ObjectInputStream ois=new ObjectInputStream(fis);
			/**
			 * WHILE ois OBJECT ISN´T NULL, IT IS READING OBJECT AND ADDING TO ARRAYLIST
			 */
			while(ois!=null) {
				try {
				this.myOwners.add((Owner)ois.readObject());
				}catch(Exception e) {
					ois=null;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * METHOD TO SEARCH FOR ACCOUNT FROM NIF OWNER
	 * @param nif
	 */
	private void getAccounts(String nif) {
		/**
		 * CREATE VARIABLES TO COUNT ACCOUNT AND TO CHOSE AN OPTION FORM MENU
		 * CREATE Scanner OBJECT TO PRINT INFO OVER SCREEN
		 * CREATE String KEY TO SAVE INFO FORM KEY ACCOUNT
		 */
		int count=0,option=0;
		Scanner in2=new Scanner(System.in);
		String key="";
		/**
		 * USING FOREACH TO LOOP THROUGH Owner ARRAYLIST
		 */
		for (Owner own : this.myOwners) {
			/**
			 * CONDITION TO GET IN AN Owner
			 */
			if(own.getNif().equals(nif)) {
				/**
				 * USING FOREACH TO LOOP THROUGH Account ARRAYLIST
				 */
				for (Account a : own.getMyAccounts()) {
					/**
					 * CREATE AN ITERATOR TO SHOE AN INDEX Account OVER SCREEN
					 */
					count++;
					/**
					 * SHOW NAME AND INDEX TO EACH ACCOUNT
					 */
					System.out.println(count+" "+a.getName());
					
				}
				/**
				 * USER TIPE A OPTION FROM MENU
				 */
				System.out.println("Choose an account to access");
				option=in2.nextInt();
				/**
				 * USER TIPE KEY FROM ACCOUNT THAT HIM CHOSE
				 */
				System.out.println("Tip the key");
				key=in2.next();
				/**
				 * CALLING METHOD TO VALIDATE KEY VERACITY
				 */
				if(!own.getMyAccounts().get(option-1).accountAcces(key)) {
					System.out.println("Taht is wrong");
					System.out.println("Tip the key one more time");
					key=in2.next();
				}
				/**
				 * CALLING METHOD TO GOT TO ACCOUNT MENU
				 */
				own.getMyAccounts().get(option-1).manageAccount();
			}
			
			
		}
		
	}
	
	
	

}
