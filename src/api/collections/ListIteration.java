package api.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ListIteration {
	public static void main(String[] args) {
		Random rand = new Random(47);
		List<Integer> list = new ArrayList<>();
		int i=5;
		while(i>0){
			list.add(rand.nextInt(5));
			i--;
		}
		ListIterator<Integer> it = list.listIterator();
		while(it.hasNext()){
			Integer a = it.next();
			System.out.println(list.indexOf(a)+","+a+","+it.nextIndex() +","+it.previousIndex());
		}
	}
}
