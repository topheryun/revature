package com.app.jdbc;

import com.app.jdbc.dao.PlayerDAO;
import com.app.jdbc.dao.impl.PlayerDAOImpl;
import com.app.jdbc.exception.BusinessException;
import com.app.jdbc.model.Player;

public class JdbcDemoMain {
	
	public static void main(String[] args) {
		
		
		testcreatePlayer(105, "Fatima", 23, "F", "Rockers", 8574829174L);
		testGetPlayerById(105);
		testUpdatePlayerContact(105, 1234567890L);
		testGetPlayerById(105);
		testDeletePlayer(105);
		testGetPlayerById(105);
		
		
	}
	
	public static void testDeletePlayer(int id) {
		PlayerDAO playerDAO = new PlayerDAOImpl();
		
		try { // find player
			Player player = playerDAO.getPlayerById(id);
			if (player != null) {
				System.out.println("Player ID: "+ id + " Found!");
				playerDAO.deletePlayer(id);
				System.out.println("Delete Successful!\n");
			}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void testcreatePlayer(int id, String name, int age, String gender, String teamName, long contact) {
		PlayerDAO playerDAO = new PlayerDAOImpl();
		Player player = new Player(id, name, age, gender, teamName, contact);
		try {
			if (playerDAO.createPlayer(player) > 0) {
				System.out.println("Player created in DB:");
				System.out.println(player + "\n");
			}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void testUpdatePlayerContact(int id, long contact) {
		PlayerDAO playerDAO = new PlayerDAOImpl();
		try {
			if(playerDAO.updatePlayerContact(id, contact) > 0) {
				System.out.println("Contact updated in DB:");
				System.out.println("ID: " + id + " / New Contact: " + contact + "\n");
			} 
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void testGetPlayerById(int id) {
		PlayerDAO playerDAO = new PlayerDAOImpl();
		try {
			Player player = playerDAO.getPlayerById(id);
			if (player != null) {
				System.out.println("Player found with id: " + id);
				System.out.println(player + "\n");
			}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}

}
