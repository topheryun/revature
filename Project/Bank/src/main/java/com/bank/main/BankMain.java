package com.bank.main;

import java.util.Scanner;

import com.bank.exception.BusinessException;
import com.bank.service.BankSearchService;
import com.bank.service.InputValidationService;
import com.bank.service.impl.BankSearchServiceImpl;
import com.bank.service.impl.InputValidationServiceImpl;

public class BankMain {

	public static void main(String[] args) {
		viewUserLoginRoute();
	}
	
/* ==================================================
 User Dashboard
================================================== */
	public static void viewUserLoginRoute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Chris' Super Cool Bank");
		int userChoice = 0;
		
		do {
			printConsoleMenuItem("Login Menu");
			System.out.println("1. Customer Login");
			System.out.println("2. Employee Login");
			System.out.println("3. Register new account");
			System.out.println("4. Exit");
			try {
				userChoice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {	
			}
			
			switch (userChoice) {
			case 1: 
				viewCustomerLoginRoute(scanner);
				break;
			case 2:
				viewEmployeeLoginRoute(scanner);
				break;
			case 3:
				viewCustomerRegisterRoute(scanner);
				break;
			case 4:
				System.out.println("Thank you for user Chris' Super Cool Bank uwu.");
				break;
			default:
				System.out.println("Please enter a number between 1 and 4.");
				break;
			}
			System.out.println();
		} while(userChoice != 4);
		
		scanner.close();
	}
	
/* ==================================================
 Customer Login
================================================== */	
	public static void viewCustomerLoginRoute(Scanner scanner) {
		BankSearchService bankSearchService = new BankSearchServiceImpl();
		String userName = "", password = "";
		
		printConsoleMenuItem("Customer Login");
		
		try {
			System.out.println("Enter User Name.");
			userName = scanner.nextLine();
			System.out.println("Enter Password.");
			password = scanner.nextLine();
			Boolean checkUserLogin = 
					bankSearchService.verifyUserLogin(userName,password);
			if (checkUserLogin) {
				System.out.println("Login Successful!");
				viewCustomerDashBoard(scanner);
			}
			else {
				System.out.println("Login Unsuccessful.");
			}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}
	
/* ==================================================
 Employee Login
================================================== */	
	public static void viewEmployeeLoginRoute(Scanner scanner) {
		BankSearchService bankSearchService = new BankSearchServiceImpl();
		String userName = "", password = "";
		
		printConsoleMenuItem("Employee Login");
		
		try {
			System.out.println("Enter User Name.");
			userName = scanner.nextLine();
			System.out.println("Enter Password.");
			password = scanner.nextLine();
			Boolean checkEmployeeLogin =
					bankSearchService.verifyEmployeeLogin(userName,password);
			if (checkEmployeeLogin) {
				System.out.println("Login Successful!");
				// navigate to employeedashboard
			}
			else {
				System.out.println("Login Unsuccessful.");
			}
		} catch (BusinessException e ) {
			System.out.println(e.getMessage());
		}
	}
	
/* ==================================================
 Customer Register
================================================== */
	public static void viewCustomerRegisterRoute(Scanner scanner) {
		InputValidationService inputValidationService = new InputValidationServiceImpl();
		String userName = "", firstName = "", lastName = "";
		Long contact = 0L;
		
		printConsoleMenuItem("Customer Registration");
		
		try {
			System.out.println("Enter User Name.");
			userName = scanner.nextLine();
			System.out.println("Enter First Name.");
			firstName = scanner.nextLine();
			System.out.println("Enter Last Name");
			lastName = scanner.nextLine();
			System.out.println("Enter 10-digit Phone Number");
			contact = Long.parseLong(scanner.nextLine());
			Boolean checkRegistrationInfo = 
					inputValidationService.validateRegistration(
					userName, firstName, lastName, contact);
			if (checkRegistrationInfo) {
				System.out.println("Registration Pending.");
			}
			else {
				System.out.println("Registration Failed.");
			}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
/* ==================================================
 Customer Dashboard
================================================== */
	public static void viewCustomerDashBoard(Scanner scanner) {
		int userChoice = 0;
		
		do {
			printConsoleMenuItem("Customer Options");
			System.out.println("1. Create New Account.");
			System.out.println("2. View Accounts.");
			System.out.println("3. Withdraw Money.");
			System.out.println("4. Deposit Money.");
			System.out.println("5. Transfer Money.");
			System.out.println("6. Receive Transfer.");
			System.out.println("7. Exit.");
			try {
				userChoice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {	
			}
			
			switch (userChoice) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6: 
				
				break;
			case 7:
				System.out.println("Exit.");
				break;
			default:
				System.out.println("Please enter a number between 1 and 7.");
				break;
			}
			
		} while(userChoice != 7);
	}
	
/* ==================================================
Misc
================================================== */	
	public static void printConsoleSeperator() {
		System.out.println("==============================");
	}
	
	public static void printConsoleMenuItem(String menuInput) {
		printConsoleSeperator();
		System.out.println("*- " + menuInput + " -*");
		printConsoleSeperator();
	}
}
