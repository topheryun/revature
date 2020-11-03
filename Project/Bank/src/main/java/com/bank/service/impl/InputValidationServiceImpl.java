package com.bank.service.impl;

import com.bank.exception.BusinessException;
import com.bank.service.InputValidationService;

public class InputValidationServiceImpl implements InputValidationService {

	@Override
	public Boolean validateRegistration(String userName, String firstName, String lastName, long contact)
			throws BusinessException {
		if (userName != "" && firstName != "" && lastName != "" && 
			contact >= 1000000000L && contact <= 9999999999L) {
			return true;
		}
		else if (userName == "") {
			throw new BusinessException("Username invalid.");
		}
		else if (firstName == "") {
			throw new BusinessException("First name invalid.");
		}
		else if (lastName == "") {
			throw new BusinessException("Last name invalid.");
		}
		else if (contact < 1000000000L || contact > 9999999999L) {
			throw new BusinessException("Contact invalid.");
		}
		return false;
		
	}



}
