package com.bank.service.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bank.exception.BusinessException;
import com.bank.service.BankManipulateService;

class BankManipulateServiceImplTest {
	
	private static BankManipulateService bms;
	
	@BeforeAll
	public static void setUp() {
		bms = new BankManipulateServiceImpl();
	}
	
	@Test
	void testDepositToAccount() {
		boolean isDeposited = false;
		try {
			isDeposited = bms.depositToAccount(1111, 1);
		} catch (BusinessException e) {
			System.out.println(e);
		}
		assertTrue(isDeposited);
	}

	@Test
	void testWithdrawFromAccount() {
		boolean isWithdrawn = false;
		try {
			isWithdrawn = bms.withdrawFromAccount(1111, 1);
		} catch (BusinessException e) {
			System.out.println(e);
		}
		assertTrue(isWithdrawn);
	}
	
	@Test
	void testDepositNegativeAmountToAccount() {
		boolean isDeposited = false;
		try {
			isDeposited = bms.depositToAccount(1111, -1);
		} catch (BusinessException e) {
			System.out.println(e);
		}
		assertFalse(isDeposited);
	}

	@Test
	void testWithdrawNegativeAmountFromAccount() {
		boolean isWithdrawn = false;
		try {
			isWithdrawn = bms.withdrawFromAccount(1111, -1);
		} catch (BusinessException e) {
			System.out.println(e);
		}
		assertFalse(isWithdrawn);
	}
	
	@Test
	void testWithdrawAmountGreaterThanBalanceFromAccount() {
		boolean isWithdrawn = false;
		try {
			isWithdrawn = bms.withdrawFromAccount(1111, 100000);
		} catch (BusinessException e) {
			System.out.println(e);
		}
		assertFalse(isWithdrawn);
	}

}
