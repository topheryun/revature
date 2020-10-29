package com.app.jdbc.dao;

import com.app.jdbc.exception.BusinessException;
import com.app.jdbc.model.Player;

public interface PlayerDAO {
	
	public int createPlayer(Player player) throws BusinessException;
	public int updatePlayerContact(int id, long newContact) throws BusinessException;
	public void deletePlayer(int id) throws BusinessException;
	public Player getPlayerById(int id) throws BusinessException;
}
