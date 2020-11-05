package com.bank.dao;

import com.bank.exception.BusinessException;

public interface BankSearchDAO {
	
	public boolean verifyUserLogin(String userName, String password) throws BusinessException;
	public boolean verifyEmployeeLogin(int employeeId, String password) throws BusinessException;
	public boolean registerNewAccount(String userName, String password, String firstName, String lastName, long contact) throws BusinessException;
	
}
