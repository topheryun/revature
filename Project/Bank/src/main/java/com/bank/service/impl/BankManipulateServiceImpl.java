package com.bank.service.impl;

import java.util.Random;

import org.apache.log4j.Logger;

import com.bank.dao.BankManipulateDAO;
import com.bank.dao.BankSearchDAO;
import com.bank.dao.impl.BankManipulateDAOImpl;
import com.bank.dao.impl.BankSearchDAOImpl;
import com.bank.exception.BusinessException;
import com.bank.model.Account;
import com.bank.model.Customer;
import com.bank.service.BankManipulateService;

public class BankManipulateServiceImpl implements BankManipulateService {
	
	private static Logger log = Logger.getLogger(BankManipulateServiceImpl.class);
	BankSearchDAO bankSearchDAO = new BankSearchDAOImpl();
	BankManipulateDAO bankManipulateDAO = new BankManipulateDAOImpl();

	@Override
	public boolean CreateNewTransactionalAccount(String userName, float balance) throws BusinessException {
		boolean isCreated = false;
		if (balance > 0) {
			Random random = new Random();
			int randomAccountNumber = 0;
			boolean isUnique = false;
			while (!isUnique) {
				randomAccountNumber = random.nextInt(8999) + 1000;
				isUnique = bankSearchDAO.checkForUniqueAccountNumber(randomAccountNumber);
			}
			Account account = new Account(userName, randomAccountNumber, balance);
			isCreated = bankManipulateDAO.CreateNewTransactionalAccount(account);
		}
		else {
			log.warn("Invalid balance. Must be greater than zero.");
		}
		return isCreated;
	}

	@Override
	public boolean WithdrawFromAccount(int accountNumber, float amount) throws BusinessException {
		boolean isWithdrawn = false;
		Account account = bankSearchDAO.getAccount(accountNumber);
		if (account != null) {
			if (account.getBalance() >= amount) {
				amount = account.getBalance() - amount;
				isWithdrawn = bankManipulateDAO.UpdateAccount(account, amount);
				log.info("New balance: $" + amount);
			}
			else {
				log.warn("Invalid amount. Must be less than current balance.");
			}
		}
		return isWithdrawn;
	}

	@Override
	public boolean DepositToAccount(int accountNumber, float amount) throws BusinessException {
		boolean isDeposited = false;
		Account account = bankSearchDAO.getAccount(accountNumber);
		if (account != null) {
			if (amount > 0) {
				amount += account.getBalance();
				isDeposited = bankManipulateDAO.UpdateAccount(account, amount);
				log.info("New balance: $" + amount);
			}
			else {
				log.warn("Invalid amount. Must be greater than zero.");
			}
		}
		return isDeposited;
	}

	@Override
	public boolean TransferMoney(int accountNumber, int targetAccountNumber, float amount) throws BusinessException {
		boolean isTransferedFrom = false;
		boolean transferCreated = false;
		Account account = bankSearchDAO.getAccount(accountNumber);
		Account targetAccount = bankSearchDAO.getAccount(targetAccountNumber);
		
		if (account != null && targetAccount != null && account.getBalance() >= amount) {
			if (targetAccountNumber == targetAccount.getAccountNumber()) {
				Random random = new Random();
				int randomId = 0;
				boolean isUnique = false;
				while (!isUnique) {
					randomId = random.nextInt(8999) + 1000;
					isUnique = bankSearchDAO.checkForUniqueId(randomId);
				}
				isTransferedFrom = bankManipulateDAO.UpdateAccount(account, account.getBalance() - amount);
				transferCreated = bankManipulateDAO.CreateTransfer(randomId, targetAccount, amount);
				log.info("Transfering: $" + amount);
			}
			else {
				log.warn("Could not locate target account number.");
			}
		}
		else {
			log.warn("Invalid amount. Must be less than current balance.");
		}
		if (isTransferedFrom && transferCreated) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean ReceiveTransfer(Account transferAccount) throws BusinessException {
		Account account = bankSearchDAO.getAccount(transferAccount.getAccountNumber());
		boolean isTransfered = bankManipulateDAO.UpdateAccount(
			account, 
			transferAccount.getBalance() + account.getBalance()
		);
		boolean isUpdated = bankManipulateDAO.DeleteTransfer(transferAccount);
		if (isTransfered && isUpdated) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean FinalizePendingAccount(int accountNumber, boolean isApproved) throws BusinessException {
		// search for account DAO
		// approve or deny it
		return true;
	}

	@Override
	public boolean registerNewCustomerAccount(Customer customer, String password) throws BusinessException {
		boolean isRegistered = false;
		if (customer != null && customer.getContact() >= 1000000000L && customer.getContact() <= 9999999999L) {
			isRegistered = bankManipulateDAO.RegisterNewCustomerAccount(customer, password);
		}
		else if (customer.getContact() < 1000000000L || customer.getContact() > 9999999999L) {
			log.warn("Invalid contact. Must be 10 digits.");
		}
		return isRegistered;
	}
	
}
