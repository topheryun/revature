package com.bank.model;

public class Account {
	
	private String userName;
	private int accountNumber;
	private float balance;
	
	public Account(String userName, int accountNumber, float balance) {
		super();
		this.userName = userName;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "[Account ID: " + accountNumber + ", Balance: " + balance + "]";
	}
	
	public Account() {
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	

}
