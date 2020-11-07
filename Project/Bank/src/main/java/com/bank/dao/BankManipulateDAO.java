package com.bank.dao;

import com.bank.exception.BusinessException;
import com.bank.model.Account;
import com.bank.model.Customer;

public interface BankManipulateDAO {
	
	public boolean CreateNewTransactionalAccount(Account account) throws BusinessException;
	public boolean RegisterNewCustomerAccount(Customer customer, String password) throws BusinessException;
	public boolean UpdateAccount(Account account, float amount) throws BusinessException;
	public boolean CreateTransfer(int id, Account targetAccount, float amount) throws BusinessException;
	public boolean DeleteTransfer(Account transfer) throws BusinessException;

}
