package api.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Random;

public class LinkedListFeatures {
	public static void main(String[] args) {
		Random rand = new Random(47);
		LinkedList<Integer> link = new LinkedList<>();
		//NoSuchElementException
		//int first = link.getFirst();
		//java.util.NoSuchElementException
		//System.out.println(link.element());
		System.out.println(link.peek());
		int i=20;
		while (i>0){
			link.add(rand.nextInt(20));
			i--;
		}
		System.out.println(link.peek());
		System.out.println();
		Iterator<Integer> it = link.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println();
		for(Integer a:link){
			System.out.println(a);
		}
	}
}
