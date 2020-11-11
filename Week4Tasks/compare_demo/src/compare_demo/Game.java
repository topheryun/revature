package compare_demo;

public class Game implements Comparable<Game> {
	
	private String name;
	private int year;
	private int rating;
	
	public Game(String name, int year, int rating) {
		super();
		this.name = name;
		this.year = year;
		this.rating = rating;
	}
	
	public Game() {
	}
	
	public int compareTo(Game game) {
		return this.year - game.year;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
