package com.player.main;

import java.util.List;
import java.util.Scanner;

import com.player.exception.BusinessException;
import com.player.model.Player;
import com.player.service.PlayerSearchService;
import com.player.service.impl.PlayerSearchServiceImpl;

public class PlayerMain {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		PlayerSearchService playerSearchService = new PlayerSearchServiceImpl();
		System.out.println("Welcome to Chris' Player Search App v1.0");
		System.out.println("========================================");
		int ch = 0;
		
		do {
			System.out.println("Player Search Menu");
			System.out.println("==================");
			System.out.println("1)By ID");
			System.out.println("2)By Name");
			System.out.println("3)By Age");
			System.out.println("4)By Gender");
			System.out.println("5)By TeamName");
			System.out.println("6)By Contact");
			System.out.println("7)All Players");
			System.out.println("8)EXIT");
			System.out.println("Please enter appropriate choice (1-8)");
			try {
				ch=Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {		
				
			}
			
			switch(ch) {
			case 1:
				System.out.println("Please Enter Player ID to get Player Details");
				getPlayerByIdMethod(scanner, playerSearchService);
				break;
			case 2: 
				System.out.println("Please enter name to get players with that name.");
				getPlayersByNameMethod(scanner, playerSearchService);
				break;
			case 3: 
				System.out.println("Please enter age to get players with that age.");
				getPlayersByAgeMethod(scanner, playerSearchService);
				break;
			case 4: 
				System.out.println("Please enter gender(m/f/o) to get players with that gender.");
				getPlayersByGenderMethod(scanner, playerSearchService);
				break;
			case 5: 
				System.out.println("Please enter team name to get players in that team.");
				getPlayersByTeamNameMethod(scanner, playerSearchService);
				break;
			case 6: 
				System.out.println("Please enter contact to get players with that contact.");
				getPlayersByContactMethod(scanner, playerSearchService);
				break;
			case 7: 
				System.out.println("Fetching All Players from DB");
				getAllPlayersMethod(playerSearchService);
				break;
			case 8: 
				System.out.println("Thank you for using Chris' Player Search App v1.0");
				break;
			}
			System.out.println();
			
		} while (ch != 8);
		
		scanner.close();

	}
	
	public static void getPlayerByIdMethod(Scanner scanner, PlayerSearchService playerSearchService) { // 1
		try {
			int id = Integer.parseInt(scanner.nextLine());
			Player player = playerSearchService.getPlayerById(id);
			if (player != null) {
				System.out.println("Found player by ID: " + id);
				System.out.println(player);
			}
		} catch (NumberFormatException e) {
			System.out.println("ID should be a number.");
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void getPlayersByNameMethod(Scanner scanner, PlayerSearchService playerSearchService) { // 2
		try {
			String name = scanner.nextLine();
			List<Player> playersListName = playerSearchService.getPlayersByName(name);
			if (playersListName != null && playersListName.size() > 0) {
				System.out.println("Found " + playersListName.size() + " Players with the Name " + name);
				for (Player player: playersListName) {
					System.out.println(player);
				}
			}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void getPlayersByAgeMethod(Scanner scanner, PlayerSearchService playerSearchService) { // 3
		try {
			int age = Integer.parseInt(scanner.nextLine());
			List<Player> playersListAge = playerSearchService.getPlayersByAge(age);
			if (playersListAge != null && playersListAge.size() > 0) {
				System.out.println("Found " + playersListAge.size() + " Players with the Age " + age);
				for (Player player: playersListAge) {
					System.out.println(player);
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Age should be a number.");
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void getPlayersByGenderMethod(Scanner scanner, PlayerSearchService playerSearchService) { // 4
		try {
			String gender = scanner.nextLine();
			List<Player> playersListGender = playerSearchService.getPlayersByGender(gender);
			if (playersListGender != null && playersListGender.size() > 0) {
				System.out.println("Found " + playersListGender.size() + " Players with the Gender " + gender);
				for (Player player: playersListGender) {
					System.out.println(player);
				}
			}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void getPlayersByTeamNameMethod(Scanner scanner, PlayerSearchService playerSearchService) { // 5
		try {
			String teamName = scanner.nextLine();
			List<Player> playersListTeamName = playerSearchService.getPlayersByTeamName(teamName);
			if (playersListTeamName != null && playersListTeamName.size() > 0) {
				System.out.println("Found " + playersListTeamName.size() + " Players in team " + teamName);
				for (Player player: playersListTeamName) {
					System.out.println(player);
				}
			}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void getPlayersByContactMethod(Scanner scanner, PlayerSearchService playerSearchService) { // 6
		try {
			long contact = Long.parseLong(scanner.nextLine());
			Player player = playerSearchService.getPlayerByContact(contact);
			if (player != null) {
				System.out.println("Found Player with contact " + contact);
				System.out.println(player);
			}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void getAllPlayersMethod(PlayerSearchService playerSearchService) { // 7
		try {
			List<Player> playersList = playerSearchService.getAllPlayers();
			if (playersList != null && playersList.size() > 0) {
				System.out.println("Found " + playersList.size() + " players");
				for (Player player:playersList) {
					System.out.println(player);
				}
			}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}

}
