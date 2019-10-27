package api.collections;

import java.util.*;

public class ListIteration {
	public static void main(String[] args) {
		Random rand = new Random(47);
		List<Integer> list = new ArrayList<>();
		int i=5;
		while(i>0){
			list.add(rand.nextInt(5));
			i--;
		}
		System.out.println(list);
		System.out.println(list.subList(0, 1));
		System.out.println(list.subList(1, list.size()));
		ListIterator<Integer> it = list.listIterator();
		while(it.hasNext()){
			Integer a = it.next();
			System.out.println(list.indexOf(a)+","+a+","+it.nextIndex() +","+it.previousIndex());
		}
	}
}
