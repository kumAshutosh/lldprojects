package entities;

public class Account {
	private String accountNumber;
	private double balance;
	
	public Account(String accountNumber,double balance) {
		this.accountNumber=accountNumber;
		this.balance=balance;
	}
	
	public boolean withdraw(int amount) {
		if(amount>balance) {
			return false;
		}
		balance= balance-amount;
		return true;
	}
	
	public void deposit(int amount) {
		balance+=amount;
	}

	public String getAccountNumber() {
		// TODO Auto-generated method stub
		return accountNumber;
	}

	public double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}
	
}
