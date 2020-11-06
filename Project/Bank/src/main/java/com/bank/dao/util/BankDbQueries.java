package com.bank.dao.util;

public class BankDbQueries {
	
	public static final String VERIFY_CUSTOMER_LOGIN = "select password, isPending from bank.customer where userName=?";
	public static final String VERIFY_EMPLOYEE_LOGIN = "select password from bank.employee where employeeId=?";
	public static final String REGISTER_NEW_ACCOUNT = "insert into bank.customer(userName, password, firstName, lastName, contact, isPending) " + 
	"Values(?,?,?,?,?,?)";
	public static final String CHECK_CUSTOMER_USERNAME_DUPLICATE = "select customer.username from bank.customer where customer.username=?";

}
