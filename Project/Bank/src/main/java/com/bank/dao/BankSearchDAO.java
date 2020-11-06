package com.bank.dao;

import com.bank.exception.BusinessException;
import com.bank.model.Customer;

public interface BankSearchDAO {
	
	public boolean verifyUserLogin(String userName, String password) throws BusinessException;
	public boolean verifyEmployeeLogin(int employeeId, String password) throws BusinessException;
	public boolean registerNewAccount(Customer customer, String password) throws BusinessException;
	
}
