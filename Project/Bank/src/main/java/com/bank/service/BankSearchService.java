package com.bank.service;

import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.Account;
import com.bank.model.Customer;

public interface BankSearchService {
	
	public List<Account> getAllAccounts(String userName) throws BusinessException;
	public List<Customer> getPendingCustomerAccounts() throws BusinessException;
	public List<Account> getAllTransfers(String userName) throws BusinessException;
	
}
