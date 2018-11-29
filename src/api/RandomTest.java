package api;

import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		System.out.println(new Random().nextInt(100));
		System.out.println(new Random().nextLong());
	}
}
