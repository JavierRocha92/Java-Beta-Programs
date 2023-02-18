package bank;

import java.util.Scanner;

public class Account {
	private String name;
	private String code_owner;
	private String keyAccount;
	private double amount;
	
	//TWO PARAMS CONSTRUCTOR
	public Account(String name,String code_owner,String keyAccount, double amount) {
		super();
		this.name = name;
		this.code_owner=code_owner;
		this.keyAccount=keyAccount;
		this.amount = amount;
	}
	
	//ONE PARAMS CONSTRUCTOR (NO BALANCE)
		public Account(String name,String code_owner,String keyAccount) {
			super();
			this.name = name;
			this.code_owner=code_owner;
			this.keyAccount=keyAccount;
			this.amount = 0.0;
		}
		
		//GETTERS AND SETTERS

		public String getName() {
			return name;
		}

		public void setName (String name) {
			this.name = name;
		}

		public String getcode_owner() {
			return code_owner;
		}

		public void setcode_owner(String code_owner) {
			this.code_owner = code_owner;
		}

		public String getKeyAccount() {
			return keyAccount;
		}

		public void setKeyAccount(String keyAccount) {
			this.keyAccount = keyAccount;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}
		
		//TO STRING METHOD

		@Override
		public String toString() {
			return "Account [name=" + name + ", code_owner=" + code_owner + ", keyAccount=" + keyAccount + ", amount=" + amount
					+ "]";
		}
		
		/**
		 * METHOD TO ADD NEW AMOUNT ON YOUR ACCOUNT
		 * @param amount
		 */
		
		public void addAmount(double amount) {
			Scanner in=new Scanner(System.in);
			if(amount<0) {
				do {
				System.out.println("Amount cant be negative");
				System.out.println("Tip a new amount");
				amount=in.nextDouble();
				}while(amount<0);
				
			}
			this.setAmount(this.getAmount()+amount);
			System.out.println("Your new balance is "+this.getAmount());
		}
		

		/**
		 * METHOD TO REST AMOUNT ON YOUR ACCOUNT
		 */
		public void retireAmount(double amount) {
			Scanner in1=new Scanner(System.in);
			if(amount>this.getAmount()) {
				do {
					System.out.println("Your balabnce is not enough");
					System.out.println("Tip a new amount");
					amount=in1.nextDouble();
				}while(amount>this.getAmount());
			}
			this.setAmount(this.getAmount()-amount);
			System.out.println("Your new balance is "+this.getAmount());
		}
		/**
		 * METHOD TO VALIDATE ACCES AN ANY ACCOUNT
		 * @param keyAccount
		 * @return<ul>
		 * <li>if keyAccount is equals to keyAccount param from method, when  return true</li>
		 * <li>if keyAccount is not equals to keyAccount param from method, when  return false</li>
		 * </ul>
		 */
		
		public boolean accountAcces(String keyAccount) {
			if(this.keyAccount.equals(keyAccount)) {
				return true;
			}
			return false;
		}
		
		/**
		 * METHOD TO MANAGE AN ACCOUNT
		 */
		public void manageAccount() {
			Scanner in3=new Scanner(System.in);
			int option=0;
			double amount=0.0;
			
			
			/**
			 * SWITCH/CASE TO CHOOSE WAY DEPENDS TO OPTION
			 */
			do {
				this.accountMenu();
				option=in3.nextInt();
				switch(option) {
				
				case 1:
					System.out.println("What amount do you get");
					amount=in3.nextDouble();
					this.retireAmount(amount);
					break;
				case 2:
					System.out.println("What amount do you add");
					amount=in3.nextDouble();
					this.addAmount(amount);
					break;
				}
			}while(option!=3);
		}
		
		/**
		 * METHOD TO SHOW ACCOUNT DATA
		 */
		public void accountMenu() {
			System.out.println(" You are on "+this.getName());
			System.out.println("***************************");
			System.out.println("Your blance-------"+this.getAmount());
			System.out.println("What do you want to do?");
			System.out.println("1. Get money");
			System.out.println("2. Set money");
			System.out.println("3. Back");
			
			}
//		public static void main(String[] args) {
//			Account a=new Account("Ahorros","0000", 2000);
//			Scanner teclado=new Scanner(System.in);
//			String key="";
//			
//			System.out.println("Introduce la key");
//			key=teclado.next();
//			while(!a.accountAcces(key)) {
//				System.out.println("Introduce la key");
//				key=teclado.next();
//			}
//			a.manageAccount();
//		}
}
