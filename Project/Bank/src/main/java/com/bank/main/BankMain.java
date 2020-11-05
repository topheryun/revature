package com.bank.main;

import org.apache.log4j.Logger;

public class BankMain {
	
	private static Logger log = Logger.getLogger(BankMain.class);
	
	public static void main(String[] args) {
		UserDashboard.viewUserLoginRoute();
	}
	
/* ==================================================
Misc
================================================== */	
	public static void printConsoleSeperator() {
		log.info("==============================");
	}
	
	public static void printConsoleMenuItem(String menuInput) {
		printConsoleSeperator();
		log.info("*- " + menuInput + " -*");
		printConsoleSeperator();
	}
}
