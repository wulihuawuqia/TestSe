package api.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MapTest {
	public static void main(String[] args) {
		Random rand = new Random(47);
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0;i < 10000; i++){
			int r = rand.nextInt(23);
			Integer freq = map.get(r);
			map.put(r, freq==null?1:freq+1);
		}
		Queue queue = new ConcurrentLinkedQueue();
		System.out.println(map);
	}
}
