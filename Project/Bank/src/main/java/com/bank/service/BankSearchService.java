package com.bank.service;

import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.Account;

public interface BankSearchService {
	
	public List<Account> getAllAccounts(String userName) throws BusinessException;
	public List<Account> getPendingAccounts() throws BusinessException;
	
}
