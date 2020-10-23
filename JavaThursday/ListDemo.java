package JavaThursday;

import java.util.*;

public class ListDemo {
	
	public static void main(String[] args) {
		
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(34);
		intList.add(5321);
		intList.add(343214);
		intList.add(31234);
		intList.add(523);
		System.out.println("intList: " + intList);
		intList.add(0,1);
		System.out.println("intList: " + intList);
		for (int i = 0; i < intList.size(); i++) {
			intList.set(i,100);
		}
		System.out.println("intList: " + intList);
		intList.remove(3);
		Integer r = 100;
		intList.remove(r);
		System.out.println("intList: " + intList);
		
		List<Integer> vectorList = new Vector<>(intList);
		System.out.println("vectorList: " + vectorList);
		vectorList.add(13);
		vectorList.add(24);
		vectorList.add(35);
		vectorList.add(46);
		System.out.println("vectorList: " + vectorList);
		vectorList.removeAll(intList);
		System.out.println("vectorList: " + vectorList);
		
		Collections.reverse(vectorList);
		System.out.println("vectorList: " + vectorList);
		Collections.shuffle(vectorList);
		System.out.println("vectorList: " + vectorList);
		Collections.sort(vectorList);
		System.out.println("vectorList: " + vectorList);
	
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 5; i <= 30; i+=5) {
			queue.add(i);
		}
		System.out.println("Queue: " + queue);
		System.out.println("First element removed: " + queue.remove());
		System.out.println("Queue: " + queue);
		System.out.println("Peeking first element: " + queue.peek());
		System.out.println("Queue: " + queue);
		System.out.println("Size of queue: " + queue.size());
	}

}
