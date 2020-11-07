package com.bank.service;

import com.bank.exception.BusinessException;
import com.bank.model.Account;
import com.bank.model.Customer;

public interface BankManipulateService {
	
	public boolean CreateNewTransactionalAccount(String userName, float balance) throws BusinessException;
	public boolean WithdrawFromAccount(int accountNumber, float amount) throws BusinessException;
	public boolean DepositToAccount(int accountNumber, float amount) throws BusinessException;
	public boolean TransferMoney(int accountNumber, int targetAccountNumber, float amount) throws BusinessException;
	public boolean ReceiveTransfer(Account transferAccount) throws BusinessException;
	public boolean FinalizePendingCustomerAccount(Customer customer, boolean isApproved) throws BusinessException;
	public boolean registerNewCustomerAccount(Customer customer, String password) throws BusinessException;
	
}
