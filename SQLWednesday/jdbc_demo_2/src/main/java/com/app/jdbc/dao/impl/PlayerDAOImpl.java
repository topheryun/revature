package com.app.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.jdbc.dao.PlayerDAO;
import com.app.jdbc.dbutil.PostgresSqlConnection;
import com.app.jdbc.exception.BusinessException;
import com.app.jdbc.model.Player;

public class PlayerDAOImpl implements PlayerDAO {

	@Override
	public int createPlayer(Player player) throws BusinessException {
		int c = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "INSERT INTO roc_myrevature.player(id, name, age, gender, teamname, contact) " + 
					"Values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, player.getId());
			preparedStatement.setString(2, player.getName());
			preparedStatement.setInt(3, player.getAge());
			preparedStatement.setString(4, player.getGender());
			preparedStatement.setString(5, player.getTeamName());
			preparedStatement.setLong(6, player.getContact());
			
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Error Occured. Contact SYSADMIN");
		}
		
		return c;
	}

	@Override
	public int updatePlayerContact(int id, long newContact) throws BusinessException {
		int c = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE roc_myrevature.player "
					+ "SET contact=? "
					+ "WHERE id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, newContact);
			preparedStatement.setInt(2, id);
			c = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Error Occured. Contact SYSADMIN");
		}
		
		return c;
	}

	@Override
	public void deletePlayer(int id) throws BusinessException {
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "DELETE FROM roc_myrevature.player "
					+ "WHERE id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Error Occured. Contact SYSADMIN");
		} 
	}

	@Override
	public Player getPlayerById(int id) throws BusinessException {
		Player player = null;
		try (Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "select name, age, gender, teamname, contact from roc_myrevature.player where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				player = new Player(id, 
						resultSet.getString("name"), 
						resultSet.getInt("age"), 
						resultSet.getString("gender"),
						resultSet.getString("teamName"),
						resultSet.getLong("contact")
				);
			}else {
				throw new BusinessException("Invalid ID!!!... No matching records found for the ID = "+id);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
		}
		return player;
	}

}
