package com.bank.service.impl;

import org.apache.log4j.Logger;

import com.bank.exception.BusinessException;
import com.bank.model.Account;
import com.bank.service.BankManipulateService;

public class BankManipulateServiceImpl implements BankManipulateService {
	
	private static Logger log = Logger.getLogger(BankManipulateServiceImpl.class);

	@Override
	public Boolean CreateNewAccount(float balance) throws BusinessException {
		if (balance > 0) {
			return true;
		}
		else {
			log.warn("Invalid balance. Must be greater than zero.");
		}
		return false;
	}

	@Override
	public Boolean WithdrawFromAccount(int accountNumber, float amount) throws BusinessException {
		// get account from db
		Account temp1 = new Account("toph", 1234, 500);
		if (temp1.getBalance() >= amount) {
			temp1.setBalance(temp1.getBalance() - amount);
			return true;
		}
		else {
			log.warn("Invalid amount. Must be less than current balance.");
		}
		return false;
	}

	@Override
	public Boolean DepositFromAccount(int accountNumber, float amount) throws BusinessException {
		// get account from db
		if (amount > 0) {
			return true;
		}
		else {
			log.warn("Invalid amount. Must be greater than zero.");
		}
		return false;
	}

	@Override
	public Boolean TransferMoney(int accountNumber, int targetAccountNumber, float amount) throws BusinessException {
		boolean returnCheck = false;
		Account temp1 = new Account("toph", 1234, 500);
		Account temp2 = new Account("someone", 1111, 100);
		
		if (temp1.getBalance() >= amount) {
			returnCheck = true;
		}
		else {
			log.warn("Invalid amount. Must be less than current balance.");
			return false;
		}
		
		if (targetAccountNumber == temp2.getAccountNumber()) {
			temp1.setBalance(temp1.getBalance() - amount);
			temp2.setBalance(temp2.getBalance() + amount);
		}
		else {
			log.warn("Could not locate target acount number.");
			returnCheck = false;
		}

		return returnCheck;
	}

	@Override
	public Boolean ReceiveTransfer(int accountNumber, float amount) throws BusinessException {
		//check user accounts
		//check account transfers
		
		
		return false;
	}

	@Override
	public Boolean FinalizePendingAccount(int accountNumber, boolean isApproved) throws BusinessException {
		// search for account DAO
		// approve or deny it
		return true;
	}

	@Override
	public Boolean registerNewAccount(String userName, String password, String firstName, String lastName, long contact)
			throws BusinessException {
		boolean isRegistered = false;
		if (userName != null && password != null && firstName != null && lastName != null && 
			contact >= 1000000000L && contact <= 9999999999L) {
			isRegistered = true;
		}
		else if (userName == null) {
			log.warn("Invalid user name.");
		}
		else if (password == null) {
			log.warn("Invalid password.");
		}
		else if (firstName == null) {
			log.warn("Invalid first name.");
		}
		else if (lastName == null) {
			log.warn("Invalid last name.");
		}
		else if (contact < 1000000000L || contact > 9999999999L) {
			log.warn("Invalid contact. Must be 10 digits.");
		}
		return isRegistered;
}
	
}
