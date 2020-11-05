package com.bank.service;

import com.bank.exception.BusinessException;

public interface BankManipulateService {
	
	public Boolean CreateNewAccount(float balance) throws BusinessException;
	public Boolean WithdrawFromAccount(int accountNumber, float amount) throws BusinessException;
	public Boolean DepositFromAccount(int accountNumber, float amount) throws BusinessException;
	public Boolean TransferMoney(int accountNumber, int targetAccountNumber, float amount) throws BusinessException;
	public Boolean ReceiveTransfer(int accountNumber, float amount) throws BusinessException;
	public Boolean FinalizePendingAccount(int accountNumber, boolean isApproved) throws BusinessException;
	public Boolean registerNewAccount(String userName, String password, String firstName, String lastName, long contact) throws BusinessException;
	
}
