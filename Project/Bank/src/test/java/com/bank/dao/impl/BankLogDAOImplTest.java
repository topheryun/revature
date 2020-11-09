package com.bank.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bank.dao.BankLogDAO;
import com.bank.exception.BusinessException;

class BankLogDAOImplTest {
	
	private static BankLogDAO bankLogDAO;
	
	@BeforeAll
	public static void setUp() {
		bankLogDAO = new BankLogDAOImpl();
	}

	@Test
	void testGetMaxId() {
		int a = 0;
		int b = 0;
		try {
			a = bankLogDAO.getMaxId();
			b = bankLogDAO.getMaxId();
		} catch (BusinessException e) {
			System.out.println(e);
		}
		assertEquals(a,b);
	}

}
