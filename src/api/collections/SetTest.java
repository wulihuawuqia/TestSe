package api.collections;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		Random rand = new Random(47);
		Set<Integer> intSet = new HashSet<>();
		for(int i = 0;i < 10000; i++){
			System.out.println(rand.nextInt(30));
			intSet.add(rand.nextInt(30));
		}
		System.out.println(intSet);
	}
}
