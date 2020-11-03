package com.bank.service.impl;

import com.bank.exception.BusinessException;
import com.bank.service.BankSearchService;

public class BankSearchServiceImpl implements BankSearchService {

	@Override
	public Boolean verifyUserLogin(String userName, String password) throws BusinessException {
		if (userName != "" && password != "") {
			return true;
		}
		else if (userName == "\n") {
			throw new BusinessException("Invalid user name.");
		}
		else if (password == "\n") {
			throw new BusinessException("Invalid password.");
		}
		return false;
	}

	@Override
	public Boolean verifyEmployeeLogin(String userName, String password) throws BusinessException {
		System.out.println("userName: " + userName);
		if (userName != "" && password != "") {
			return true;
		}
		else if (userName == "\n") {
			throw new BusinessException("Invalid user name.");
		}
		else if (password == "\n") {
			throw new BusinessException("Invalid password.");
		}
		return false;
	}

}
