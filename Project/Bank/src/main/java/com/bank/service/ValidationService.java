package com.bank.service;

import com.bank.exception.BusinessException;

public interface ValidationService {
	
	public Boolean verifyUserLogin(String userName, String password) throws BusinessException;
	public Boolean verifyEmployeeLogin(int employeeId, String password) throws BusinessException;

}
