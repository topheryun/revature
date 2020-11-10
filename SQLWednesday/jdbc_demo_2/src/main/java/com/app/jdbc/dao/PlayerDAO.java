package com.app.jdbc.dao;

import java.time.LocalDateTime;
import java.util.Date;

import com.app.jdbc.exception.BusinessException;
import com.app.jdbc.model.Player;

public interface PlayerDAO {
	
	public int createPlayer(Player player) throws BusinessException;
	public int updatePlayerContact(int id, long newContact) throws BusinessException;
	public void deletePlayer(int id) throws BusinessException;
	public Player getPlayerById(int id) throws BusinessException;
	public void addDate(LocalDateTime ldt) throws BusinessException;
	public LocalDateTime getDate(int id) throws BusinessException;
}
