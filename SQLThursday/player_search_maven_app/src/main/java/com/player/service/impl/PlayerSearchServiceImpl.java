package com.player.service.impl;

import java.util.List;

import com.player.dao.PlayerSearchDAO;
import com.player.dao.impl.PlayerSearchDAOImpl;
import com.player.exception.BusinessException;
import com.player.model.Player;
import com.player.service.PlayerSearchService;

public class PlayerSearchServiceImpl implements PlayerSearchService{
	
	private PlayerSearchDAO searchDAO = new PlayerSearchDAOImpl();

	@Override
	public Player getPlayerById(int id) throws BusinessException {
		Player player = null;
		if (id > 99 && id < 1000) {
			player = searchDAO.getPlayerById(id);
		} else {
			throw new BusinessException("Player ID: " + id + " is invalid.");
		}
		return player;
	}

	@Override
	public List<Player> getAllPlayers() throws BusinessException {
		List<Player> playersList = null;
		playersList = searchDAO.getAllPlayers();
		return playersList;
	}

	@Override
	public List<Player> getPlayersByName(String name) throws BusinessException {
		List<Player> playerListName = null;
		playerListName = searchDAO.getPlayersByName(name);
		return playerListName;
	}

	@Override
	public List<Player> getPlayersByAge(int age) throws BusinessException {
		List<Player> playerListAge = null;
		if (age > 17 && age < 100) {
			playerListAge = searchDAO.getPlayersByAge(age);
		}
		else {
			throw new BusinessException("Entered Age " + age + " is Invalid.");
		}
		return playerListAge;
	}

	@Override
	public Player getPlayerByContact(long contact) throws BusinessException {
		Player player = null;
		if (contact >= 1000000000L && contact <= 9999999999L) {
			player = searchDAO.getPlayerByContact(contact);
		}
		else {
			throw new BusinessException("Entered Contact " + contact + " is Invalid.");
		}
		return player;
	}

	@Override
	public List<Player> getPlayersByTeamName(String teamName) throws BusinessException {
		List<Player> playerListTeamName = null;
		playerListTeamName = searchDAO.getPlayersByTeamName(teamName);
		return playerListTeamName;
	}

	@Override
	public List<Player> getPlayersByGender(String gender) throws BusinessException {
		List<Player> playerListGender = null;
		if (gender != null && gender.matches("[mMfFoO]{1}")) {
			playerListGender = searchDAO.getPlayersByGender(gender);
		}
		else {
			throw new BusinessException("Entered Gender " + gender + " is Invalid.");
		}
		return playerListGender;
	}

}
