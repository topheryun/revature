package com.bank.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bank.exception.BusinessException;
import com.bank.model.Account;
import com.bank.service.BankSearchService;

public class BankSearchServiceImpl implements BankSearchService {
	
	private static Logger log = Logger.getLogger(BankSearchServiceImpl.class);	

	@Override
	public List<Account> getAllAccounts(String userName) throws BusinessException {
		List<Account> accountsList = new ArrayList<>();
//		accountsList = links to searchDAO 
		Account temp1 = new Account("toph", 1234, 500L);
		Account temp2 = new Account("toph", 3412, 800L);
		accountsList.add(temp1);
		accountsList.add(temp2);
		
		return accountsList;
	}

	@Override
	public List<Account> getPendingAccounts() throws BusinessException {
		List<Account> accountsList = new ArrayList<>();
		Account temp1 = new Account("toph", 1234, 500L);
		Account temp2 = new Account("toph", 3412, 800L);
		accountsList.add(temp1);
		accountsList.add(temp2);
		
		return accountsList;
	}

}
