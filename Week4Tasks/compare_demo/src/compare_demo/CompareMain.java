package compare_demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareMain {

	public static void main(String[] args) {
		List<Game> gameList = createGameList();
		
		System.out.println("Before Sorting.");
		printList(gameList);
		Collections.sort(gameList);
		
		System.out.println("\nAfter Sorting.");
		printList(gameList);
		
		System.out.println("\nSort by Rating Ascending.");
		RatingCompare ratingCompare = new RatingCompare();
		Collections.sort(gameList,ratingCompare);
		printList(gameList);
		
		System.out.println("\nSort by Name Alphabetical.");
		NameCompare nameCompare = new NameCompare();
		Collections.sort(gameList,nameCompare);
		printList(gameList);

	}
	
	public static List<Game> createGameList() {
		List<Game> gameList = new ArrayList<>();
		gameList.add(new Game("Minecraft",2009,93));
		gameList.add(new Game("Super Mario Galaxy",2007,97));
		gameList.add(new Game("Journey",2015,92));
		gameList.add(new Game("Hades",2020,92));
		gameList.add(new Game("Metroid Fusion",2002,92));
		gameList.add(new Game("The Legend of Zelda: Ocarina of Time",1998,99));
		gameList.add(new Game("Slay the Spire",2019,89));
		gameList.add(new Game("Sid Meier's Civilization V",2010,90));
		gameList.add(new Game("BioShock",2007,96));
		gameList.add(new Game("Jet Grind Radio",2000,94));
		return gameList;
	}
	
	public static void printList(List<Game> list) {
		for (Game game : list) {
			System.out.println("[Year: " + game.getYear() + ", Rating: " + game.getRating() + 
					", Game: " + game.getName());
		}
	}

}
