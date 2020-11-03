package com.bank.service;

import com.bank.exception.BusinessException;

public interface BankSearchService {
	
	public Boolean verifyUserLogin(String userName, String password) throws BusinessException;
	public Boolean verifyEmployeeLogin(String userName, String password) throws BusinessException;
	
}
