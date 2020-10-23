package JavaFriday;

import java.util.*;

public class HashMapDemo {
	
	public static void main(String[] args) {
		
		Map<String,Integer> hashmap = new HashMap<>();
		hashmap.put("Enlightened Labourer", 25);
		hashmap.put("Shinobi", 12);
		hashmap.put("Dancing Assassin", 10);
		hashmap.put("Militant Samurai", 15);
		hashmap.put("Shaolin Kung Fu", 10);
		hashmap.put("Armored Archer", 10);
		hashmap.put("Dumpling Delivery", 10);
		System.out.println("HashMap: " + hashmap);
		
		Map<Integer,String> treemap = new TreeMap<>(Collections.reverseOrder());
		treemap.put(123,"hello");
		treemap.put(123,"updated");
		treemap.put(1234,"java");
		treemap.put(1223,null);
		treemap.put(1423,"test");
		System.out.println("TreeMap: " + treemap);
		
		System.out.println("get hashmap Shinobi value: " + hashmap.get("Shinobi"));
		System.out.println("get treemap 123 string: " + treemap.get(123));
		
		Set<Integer> hs = treemap.keySet();
		for(Integer i:hs) {
			System.out.println("key: " + i + " value: " + treemap.get(i));
		}
		
	}

}
