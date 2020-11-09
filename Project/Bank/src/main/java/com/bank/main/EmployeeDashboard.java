package com.bank.main;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.exception.BusinessException;
import com.bank.main.util.UI;
import com.bank.model.Account;
import com.bank.model.Customer;
import com.bank.model.Log;
import com.bank.service.BankLogService;
import com.bank.service.BankManipulateService;
import com.bank.service.BankSearchService;
import com.bank.service.impl.BankLogServiceImpl;
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
			UI.printConsoleMenuItem("Employee Options");
			log.info("1. Approve Pending Customer Accounts.");
			log.info("2. Approve Pending Transactional Accounts.");
			log.info("3. View Customer Information.");
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
				viewApprovePendingTransactionalAccountsRoute(scanner);
				break;
			case 3:
				viewViewCustomerInformationRoute(scanner);
				break;
			case 4:
				log.info("Returning to main menu.");
				break;
			default: 
				log.info("Please enter a number between 1 and 4.");
				break;
			}
			log.info("");
		} while(userChoice != 4);
	}
	
/* ==================================================
 Approve Pending Customer Accounts backend done
================================================== */
	public static void viewApprovePendingCustomerAccountsRoute(Scanner scanner) {
		BankManipulateService bankManipulateService = new BankManipulateServiceImpl();
		BankSearchService bankSearchService = new BankSearchServiceImpl();
		int userAccountChoice = 0;
		boolean isApproved = false;
		
		UI.printConsoleMenuItem("Customer Accounts Pending Approval");
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
						bankManipulateService.finalizePendingCustomerAccount(
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
 Approve Pending Transactional Accounts  backend done
================================================== */
	public static void viewApprovePendingTransactionalAccountsRoute(Scanner scanner) {
		BankManipulateService bankManipulateService = new BankManipulateServiceImpl();
		BankSearchService bankSearchService = new BankSearchServiceImpl();
		int userAccountChoice = 0;
		boolean isApproved = false;
		
		UI.printConsoleMenuItem("Transactional Accounts Pending Approval");
		try {
			log.info("Select Transactional Account.");
			List<Account> accountsList = bankSearchService.getPendingTransactionalAccounts();
			if (accountsList != null & accountsList.size() > 0) {
				int i = 1;
				for (Account account: accountsList) {
					log.info(i++ + ". " + account);
				}
				userAccountChoice = Integer.parseInt(scanner.nextLine());
				log.info("1. Approve\n2. Deny");
				isApproved = Integer.parseInt(scanner.nextLine()) == 1 ? true : false;
				boolean isFinalized = 
						bankManipulateService.finalizePendingTransactionalAccount(
							accountsList.get(userAccountChoice-1), 
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
				log.info("No Pending Transactional Accounts.");
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
		} catch (NumberFormatException e) {	
		} catch (IndexOutOfBoundsException e) {
		}
		
	}
	
/* ==================================================
 View Customer Information 
================================================== */
	public static void viewViewCustomerInformationRoute(Scanner scanner) {
		BankSearchService bankSearchService = new BankSearchServiceImpl();
		BankLogService bankLogService = new BankLogServiceImpl();
		int choice = 0;
		
		UI.printConsoleMenuItem("View Customer Information");
		try {
			log.info("Select Customer Account.");
			List<Customer> customerList = bankSearchService.getAllCustomerAccounts();
			if (customerList != null & customerList.size() > 0) {
				int i = 1;
				for (Customer customer: customerList) {
					log.info(i++ + ". " + customer);
				}
				choice = Integer.parseInt(scanner.nextLine());
				log.info("Select Transactional Account.");
				List<Account> accountList = bankSearchService.getAllTransactionalAccounts(
						customerList.get(choice-1).getUserName());
				if (accountList != null & accountList.size() > 0) {
					int j = 1;
					for (Account account: accountList) {
						log.info(j++ + ". " + account);
					}
					choice = Integer.parseInt(scanner.nextLine());
					log.info("Account History:");
					List<Log> logList = bankLogService.getAccountHistory(accountList.get(choice-1));
					if (logList != null && logList.size() > 0) {
						for (Log record: logList) {
							log.info(record);
						}
					}
					else {
						log.warn("Could not find Account History.");
					}
				}
				else {
					log.warn("Could not find any Transactional Accounts.");
				}
			}
			else {
				log.warn("Could not find any Customer Accounts.");
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
		}
	}
	

}
