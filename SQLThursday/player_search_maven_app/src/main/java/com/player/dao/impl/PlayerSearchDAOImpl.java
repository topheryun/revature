package com.player.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.player.dao.PlayerSearchDAO;
import com.player.dao.util.PlayerSearchQueries;
import com.player.dao.util.PostgresSqlConnection;
import com.player.exception.BusinessException;
import com.player.model.Player;

public class PlayerSearchDAOImpl implements PlayerSearchDAO{

	@Override
	public Player getPlayerById(int id) throws BusinessException {
		Player player = null;
		try (Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = PlayerSearchQueries.GET_PLAYER_BY_ID;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				player = new Player(
						id, 
						resultSet.getString("name"), 
						resultSet.getInt("age"), 
						resultSet.getString("gender"),
						resultSet.getString("teamName"), 
						resultSet.getLong("contact")
				);
			}
			else {
				throw new BusinessException("Invalid ID. No matching records found for ID: " + id);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Error: Contact SYSADMIN.");
		}

		
		return player;
	}

	@Override
	public List<Player> getAllPlayers() throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		try (Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = PlayerSearchQueries.GET_ALL_PLAYERS;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Player player = new Player(
						resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getInt("age"),
						resultSet.getString("gender"),
						resultSet.getString("teamName"),
						resultSet.getLong("contact")
						);
				playerList.add(player);
			}
			if (playerList.size() == 0) {
				throw new BusinessException("No Player Records Available.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Error: Contact SYSADMIN.");
		}

		return playerList;
	}

	@Override
	public List<Player> getPlayersByName(String name) throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		try (Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = PlayerSearchQueries.GET_PLAYERS_BY_NAME;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Player player = new Player(
						resultSet.getInt("id"),
						name,
						resultSet.getInt("age"),
						resultSet.getString("gender"),
						resultSet.getString("teamName"),
						resultSet.getLong("contact")
						);
				playerList.add(player);
			}
			if (playerList.size() == 0) {
				throw new BusinessException("No Players Found with Name: " + name);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Error: Contact SYSADMIN.");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByAge(int age) throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		try (Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = PlayerSearchQueries.GET_PLAYERS_BY_AGE;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, age);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Player player = new Player(
						resultSet.getInt("id"),
						resultSet.getString("name"),
						age,
						resultSet.getString("gender"),
						resultSet.getString("teamName"),
						resultSet.getLong("contact")
						);
				playerList.add(player);
			}
			if (playerList.size() == 0) {
				throw new BusinessException("No Players Found with Age: " + age);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Error: Contact SYSADMIN.");
		}
		return playerList;
	}

	@Override
	public Player getPlayerByContact(long contact) throws BusinessException {
		Player player = null;
		try (Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = PlayerSearchQueries.GET_PLAYER_BY_CONTACT;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, contact);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				player = new Player(
						resultSet.getInt("id"),
						resultSet.getString("name"), 
						resultSet.getInt("age"), 
						resultSet.getString("gender"),
						resultSet.getString("teamName"), 
						contact
				);
			}
			else {
				throw new BusinessException("Invalid ID. No matching records found for contact: " + contact);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Error: Contact SYSADMIN.");
		}

		
		return player;
	}

	@Override
	public List<Player> getPlayersByTeamName(String teamName) throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		try (Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = PlayerSearchQueries.GET_PLAYERS_BY_TEAM_NAME;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, teamName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Player player = new Player(
						resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getInt("age"),
						resultSet.getString("gender"),
						teamName,
						resultSet.getLong("contact")
						);
				playerList.add(player);
			}
			if (playerList.size() == 0) {
				throw new BusinessException("No Players Found in team: " + teamName);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Error: Contact SYSADMIN.");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByGender(String gender) throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		try (Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = PlayerSearchQueries.GET_PLAYERS_BY_GENDER;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, gender.toUpperCase());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Player player = new Player(
						resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getInt("age"),
						gender,
						resultSet.getString("teamName"),
						resultSet.getLong("contact")
						);
				playerList.add(player);
			}
			if (playerList.size() == 0) {
				throw new BusinessException("No Players Found with Gender: " + gender);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Error: Contact SYSADMIN.");
		}
		return playerList;
	}

}
