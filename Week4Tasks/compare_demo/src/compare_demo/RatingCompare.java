package compare_demo;

import java.util.Comparator;

public class RatingCompare implements Comparator<Game> {
	
	public int compare (Game game1, Game game2) {
		if (game1.getRating() < game2.getRating()) {
			return -1;
		}
		if (game1.getRating() > game2.getRating()) {
			return 1;
		}
		else return 0;
	}

}
