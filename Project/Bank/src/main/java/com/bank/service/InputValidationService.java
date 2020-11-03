package com.bank.service;

import com.bank.exception.BusinessException;

public interface InputValidationService {
	
	public Boolean validateRegistration(String userName, String firstName, String lastName, long contact) throws BusinessException;

}
