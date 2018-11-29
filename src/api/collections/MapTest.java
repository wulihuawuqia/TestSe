package api.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapTest {
	public static void main(String[] args) {
		Random rand = new Random(47);
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0;i < 10000; i++){
			int r = rand.nextInt(20);
			Integer freq = map.get(r);
			map.put(r, freq==null?1:freq+1);
		}
		System.out.println(map);
	}
}
