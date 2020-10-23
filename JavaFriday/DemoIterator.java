package JavaFriday;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class DemoIterator {
	
	public static void main(String[] args) {
		
		Map<Integer,String> hm = new HashMap<>();
		hm.put(123,"hello");
		hm.put(1230,"world");
		hm.put(1323,"java");
		hm.put(12830,null);
		hm.put(86123,"jsa");
		hm.put(121330,"geas");
		hm.put(14123,"hibernate");
		hm.put(123213,"before");
		
		System.out.println("Before Deletion");
		System.out.println(hm);
		
//		for (Entry<Integer,String> e:hm.entrySet()) {
//			if(e.getKey() % 10 == 0 || e.getValue() == null)
//				hm.remove(e.getKey());
//		}
		
		Iterator<Entry<Integer,String>> i = hm.entrySet().iterator();
		while (i.hasNext()) {
			Entry<Integer,String> e = i.next();
			if(e.getKey() % 10 == 0 || e.getValue() == null)
				i.remove();
		}
		
		System.out.println("After Deletion");
		System.out.println(hm);
		
		
		
		
	}

}
