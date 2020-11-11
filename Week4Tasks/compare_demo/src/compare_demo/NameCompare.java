package compare_demo;

import java.util.Comparator;

public class NameCompare implements Comparator<Game> {
	
	public int compare (Game game1, Game game2) {
		return game1.getName().compareTo(game2.getName());
	}

}
