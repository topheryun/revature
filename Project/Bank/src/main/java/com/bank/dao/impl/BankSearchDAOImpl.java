package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bank.dao.BankSearchDAO;
import com.bank.dao.util.BankDbQueries;
import com.bank.dao.util.BankDbUtilProps;
import com.bank.dao.util.BankPostgresSqlConnection;
import com.bank.exception.BusinessException;
import com.bank.model.Customer;


public class BankSearchDAOImpl implements BankSearchDAO {
	
	private static Logger log = Logger.getLogger(BankSearchDAOImpl.class);

	@Override
	public boolean verifyUserLogin(String userName, String password) throws BusinessException {
		boolean checkUserLogin = false;
		try (Connection connection = BankPostgresSqlConnection.getConnection()) {
			String sql = BankDbQueries.VERIFY_CUSTOMER_LOGIN;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				if (!resultSet.getBoolean("isPending") && resultSet.getString("password").equals(password)) {
					if (resultSet.getString("password").equals(password)) {
						checkUserLogin = true;
					}
					else {
						log.warn("Wrong password.");
					}
				}
				else {
					log.warn("Account has yet to be approved by an Employee.");
				}
			}
			else {
				log.warn("Could not find user name.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException(BankDbUtilProps.ERROR_MESSAGE);
		}
		return checkUserLogin;
	}

	@Override
	public boolean verifyEmployeeLogin(int employeeId, String password) throws BusinessException {
		boolean checkEmployeeLogin = false;
		try (Connection connection = BankPostgresSqlConnection.getConnection()) {
			String sql = BankDbQueries.VERIFY_EMPLOYEE_LOGIN;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employeeId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				if (resultSet.getString("password").equals(password)) {
					checkEmployeeLogin = true;
				}
				else {
					log.warn("Wrong password.");
				}
			}
			else {
				log.warn("Could not find ID.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException(BankDbUtilProps.ERROR_MESSAGE);
		}
		return checkEmployeeLogin;
	}

	@Override
	public boolean registerNewAccount(Customer customer, String password)
			throws BusinessException {
		boolean isRegistered = false;
		try (Connection connection = BankPostgresSqlConnection.getConnection()) {
			String sql = BankDbQueries.CHECK_CUSTOMER_USERNAME_DUPLICATE;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getUserName());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				log.warn("Username already exists.");
			}
			else {
				sql = BankDbQueries.REGISTER_NEW_ACCOUNT;
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, customer.getUserName());
				preparedStatement.setString(2, password);
				preparedStatement.setString(3, customer.getFirstName());
				preparedStatement.setString(4, customer.getLastName());
				preparedStatement.setLong(5, customer.getContact());
				preparedStatement.setBoolean(6, true);
				
				preparedStatement.executeUpdate();
				isRegistered = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException(BankDbUtilProps.ERROR_MESSAGE);
		}
		return isRegistered;
	}

}
