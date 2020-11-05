package com.bank.main;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.exception.BusinessException;
import com.bank.model.Account;
import com.bank.service.BankManipulateService;
import com.bank.service.BankSearchService;
import com.bank.service.impl.BankManipulateServiceImpl;
import com.bank.service.impl.BankSearchServiceImpl;

public class CustomerDashboard {
	
	private static Logger log = Logger.getLogger(CustomerDashboard.class);
	
/* ==================================================
 Customer Dashboard
================================================== */
	public static void viewCustomerDashboard(Scanner scanner, String userName) {
		int userChoice = 0;
		
		do {
			BankMain.printConsoleMenuItem("Customer Options");
			log.info("1. Create New Account.");
			log.info("2. View Accounts.");
			log.info("3. Withdraw Money.");
			log.info("4. Deposit Money.");
			log.info("5. Transfer Money.");
			log.info("6. Receive Transfer.");
			log.info("7. Exit.");
			try {
				userChoice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {	
			}
			
			switch (userChoice) {
			case 1:
				viewCreateNewAccountRoute(scanner, userName);
				break;
			case 2:
				viewAccountsRoute(scanner, userName);
				break;
			case 3:
				viewWithdrawMoneyRoute(scanner, userName);
				break;
			case 4:
				viewDepositMoneyRoute(scanner, userName);
				break;
			case 5:
				viewTransferMoneyRoute(scanner, userName);
				break;
			case 6: 
				viewReceiveTransferRoute(scanner, userName);
				break;
			case 7:
				log.info("Returning to main menu.");
				break;
			default:
				log.info("Please enter a number between 1 and 7.");
				break;
			}
			
		} while(userChoice != 7);
	}
	
/* ==================================================
 Create New Account
================================================== */
	public static void viewCreateNewAccountRoute(Scanner scanner, String userName) {
		BankManipulateService bankManipulateService = new BankManipulateServiceImpl();
		float balance = 0;
		BankMain.printConsoleMenuItem("Create New Account");
		try {
			log.info("Deposit initial balance for new account.");
			balance = Float.parseFloat(scanner.nextLine());
			Boolean checkCreateAccount = 
					bankManipulateService.CreateNewAccount(balance);
			if (checkCreateAccount) {
				log.info("Account Creation Successful. Pending Approval.");
			}
			else {
				log.warn("Account Creation Failed.");
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
		}
		
	}
	
/* ==================================================
 View Accounts
================================================== */
	public static void viewAccountsRoute(Scanner scanner, String userName) {
		BankSearchService bankSearchService = new BankSearchServiceImpl();
		BankMain.printConsoleMenuItem("Accounts");
		try {
			List<Account> accountList = bankSearchService.getAllAccounts(userName);
			if (accountList != null & accountList.size() > 0) {
				for (Account account: accountList) {
					log.info(account);
				}
			}
			else {
				log.warn("Could Not Locate Accounts.");
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
		}
		
	}
	
/* ==================================================
 Withdraw Money
================================================== */
	public static void viewWithdrawMoneyRoute(Scanner scanner, String userName) {
		BankSearchService bankSearchService = new BankSearchServiceImpl();
		BankManipulateService bankManipulateService = new BankManipulateServiceImpl();
		int userAccountChoice = 0;
		float userWithdrawAmount = 0;
		
		BankMain.printConsoleMenuItem("Withdraw Money");
		try {
			log.info("Select Account.");
			List<Account> accountList = bankSearchService.getAllAccounts(userName);
			if (accountList != null & accountList.size() > 0) {
				int i = 1;
				for (Account account: accountList) {
					log.info(i++ + ". " + account);
				}
				userAccountChoice = Integer.parseInt(scanner.nextLine());
				log.info("How much would you like to withdraw?");
				userWithdrawAmount = Float.parseFloat(scanner.nextLine());
				boolean checkWithdraw = 
						bankManipulateService.WithdrawFromAccount(
							accountList.get(userAccountChoice-1).getAccountNumber(), 
							userWithdrawAmount
						);
				if (checkWithdraw) {
					log.info("$" + userWithdrawAmount + " has been withdrawn from your account.");
				}
				else {
					log.warn("Could not withdraw from account.");
				}
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
		} catch (NumberFormatException e) {	
		} catch (IndexOutOfBoundsException e) {
		}
	}
	
/* ==================================================
 Deposit Money
================================================== */
	public static void viewDepositMoneyRoute(Scanner scanner, String userName) {
		BankSearchService bankSearchService = new BankSearchServiceImpl();
		BankManipulateService bankManipulateService = new BankManipulateServiceImpl();
		int userAccountChoice = 0;
		float userDepositAmount = 0;
		
		BankMain.printConsoleMenuItem("Deposit Money");
		try {
			log.info("Select Account.");
			List<Account> accountList = bankSearchService.getAllAccounts(userName);
			if (accountList != null & accountList.size() > 0) {
				int i = 1;
				for (Account account: accountList) {
					log.info(i++ + ". " + account);
				}
				userAccountChoice = Integer.parseInt(scanner.nextLine());
				log.info("How much would you like to deposit?");
				userDepositAmount = Float.parseFloat(scanner.nextLine());
				boolean checkDeposit = 
						bankManipulateService.DepositFromAccount(
							accountList.get(userAccountChoice-1).getAccountNumber(), 
							userDepositAmount
						);
				if (checkDeposit) {
					log.info("$" + userDepositAmount + " has been deposited to your account.");
				}
				else {
					log.warn("Could not deposit from account.");
				}
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
		} catch (NumberFormatException e) {	
		} catch (IndexOutOfBoundsException e) {
		}
	}
	
/* ==================================================
 Transfer Money
================================================== */
	public static void viewTransferMoneyRoute(Scanner scanner, String userName) {
		BankManipulateService bankManipulateService = new BankManipulateServiceImpl();
		BankSearchService bankSearchService = new BankSearchServiceImpl();
		int userAccountChoice = 0;
		int userTransferTarget = 0;
		float userTransferAmount = 0;
		
		BankMain.printConsoleMenuItem("Transfer Money");
		try {
			log.info("Select Account.");
			List<Account> accountList = bankSearchService.getAllAccounts(userName);
			if (accountList != null & accountList.size() > 0) {
				int i = 1;
				for (Account account: accountList) {
					log.info(i++ + ". " + account);
				}
				userAccountChoice = Integer.parseInt(scanner.nextLine());
				log.info("Enter account number to transfer to.");
				userTransferTarget = Integer.parseInt(scanner.nextLine());
				log.info("Enter amount to be transfered.");
				userTransferAmount = Float.parseFloat(scanner.nextLine());
				boolean checkTransfer = 
						bankManipulateService.TransferMoney(
							accountList.get(userAccountChoice-1).getAccountNumber(),
							userTransferTarget,
							userTransferAmount
						);
				if (checkTransfer) {
					log.info("$" + userTransferAmount + " has been trasnfered to account #" + userTransferTarget + ".");
				}
				else {
					log.warn("Could not transfer.");
				}
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
		} catch (NumberFormatException e) {	
		} catch (IndexOutOfBoundsException e) {
		}
	}
	
/* ==================================================
 Receive Transfer
================================================== */
	public static void viewReceiveTransferRoute(Scanner scanner, String userName) {
		BankManipulateService bankManipulateService = new BankManipulateServiceImpl();
		int userTargetAccountNumber = 0;
		float userTransferAmount = 0;
		
		BankMain.printConsoleMenuItem("Receive Transfer");
		try {
			log.info("Input account number of account to send to.");
			userTargetAccountNumber = Integer.parseInt(scanner.nextLine());
			log.info("Input transfer amount.");
			userTransferAmount = Float.parseFloat(scanner.nextLine());
			boolean checkTransfer = 
					bankManipulateService.ReceiveTransfer(
						userTargetAccountNumber, 
						userTransferAmount
					);
			if (checkTransfer) {
				log.info("Transfer received.");
			}
			else {
				log.info("Could not receive transfer.");
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
		}
		
	}
	
}
