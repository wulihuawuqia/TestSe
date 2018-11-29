package api.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
public class ListFeatures {
	public static void main(String[] args) {
		Random rand = new Random(47);
		List<Integer> list = new ArrayList<>();
		int i=50000;
		Long currentTime = System.currentTimeMillis();
		while(i>0){
			list.add(rand.nextInt(50000));
			i--;
		}
		System.out.println(System.currentTimeMillis()-currentTime);
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
