package com.bank.dao.util;

public class BankSearchQueries {
	
	public static final String VERIFY_CUSTOMER_LOGIN = "select password, isPending from bank.customer where userName=?";
	public static final String VERIFY_EMPLOYEE_LOGIN = "select password from bank.employee where employeeId=?";

}
