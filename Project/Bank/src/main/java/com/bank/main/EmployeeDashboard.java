package com.bank.main;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.exception.BusinessException;
import com.bank.model.Account;
import com.bank.model.Customer;
import com.bank.service.BankManipulateService;
import com.bank.service.BankSearchService;
import com.bank.service.impl.BankManipulateServiceImpl;
import com.bank.service.impl.BankSearchServiceImpl;

public class EmployeeDashboard {
	
	private static Logger log = Logger.getLogger(EmployeeDashboard.class);
	
/* ==================================================
 Employee Dashboard
================================================== */
	public static void viewEmployeeDashboard(Scanner scanner) {
		int userChoice = 0;
		
		do {
			BankMain.printConsoleMenuItem("Employee Options");
			log.info("1. Approve Pending Accounts.");
			log.info("2. View Customer Accounts.");
			log.info("3. View Customer History.");
			log.info("4. Exit.");
			try {
				userChoice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {	
			}
			
			switch (userChoice) {
			case 1:
				viewApprovePendingCustomerAccountsRoute(scanner);
				break;
			case 2:
				viewViewCustomerAccountsRoute(scanner);
				break;
			case 3:
				viewCustomerHistoryRoute(scanner);
				break;
			case 4:
				log.info("Returning to main menu.");
				break;
			default: 
				log.info("Please enter a number between 1 and 4.");
				break;
			}
		} while(userChoice != 4);
	}
	
/* ==================================================
 Approve Pending Accounts backend done
================================================== */
	public static void viewApprovePendingCustomerAccountsRoute(Scanner scanner) {
		BankManipulateService bankManipulateService = new BankManipulateServiceImpl();
		BankSearchService bankSearchService = new BankSearchServiceImpl();
		int userAccountChoice = 0;
		boolean isApproved = false;
		
		BankMain.printConsoleMenuItem("Customer Accounts Pending Approval");
		try {
			log.info("Select Customer Account.");
			List<Customer> customerList = bankSearchService.getPendingCustomerAccounts();
			if (customerList != null & customerList.size() > 0) {
				int i = 1;
				for (Customer customer: customerList) {
					log.info(i++ + ". " + customer);
				}
				userAccountChoice = Integer.parseInt(scanner.nextLine());
				log.info("1. Approve\n2. Deny");
				isApproved = Integer.parseInt(scanner.nextLine()) == 1 ? true : false;
				boolean isFinalized = 
						bankManipulateService.FinalizePendingCustomerAccount(
							customerList.get(userAccountChoice-1), 
							isApproved
						);
				if (isFinalized) {
					log.info("Account status has been finalized.");
				}
				else {
					log.info("Failed to finalize account status.");
				}
			}
			else {
				log.info("No Pending Accounts.");
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
		} catch (NumberFormatException e) {	
		} catch (IndexOutOfBoundsException e) {
		}
		
	}
	
/* ==================================================
 View Customer Accounts backend done
================================================== */
	public static void viewViewCustomerAccountsRoute(Scanner scanner) {
		BankSearchService bankSearchService = new BankSearchServiceImpl();
		String customerUserName = "";
		
		BankMain.printConsoleMenuItem("View Customer Account");
		try {
			log.info("Enter Customer Username.");
			customerUserName = scanner.nextLine();
			List<Account> accountList = bankSearchService.getAllAccounts(customerUserName);
			for (Account account: accountList) {
				log.info(account);
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
		}
	}
	
/* ==================================================
 View Account History
================================================== */
	public static void viewCustomerHistoryRoute(Scanner scanner) {
		BankSearchService bankSearchService = new BankSearchServiceImpl();
		String customerUserName = "";
		
		BankMain.printConsoleMenuItem("View Customer History");
		/*
		try {
			log.info("Enter Customer Username.");
			customerUserName = scanner.nextLine();
			// create log file for just transactions and access them
		} catch (BusinessException e) {
			log.error(e.getMessage());
		}
		*/
	}

}
