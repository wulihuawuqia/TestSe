package leedcode;

import java.util.HashMap;

/**
 * 描述:
 *
 * @author qia.wu
 * @create 2019-09-30 11:33
 * @see leedcode.one
 */
public class Test387 {

	public static void main(String[] args) {
		System.out.println(firstUniqChar1("leetcode"));
		System.out.println(firstUniqChar1("loveleetcode"));
		System.out.println(firstUniqChar1("cc"));
	}

	public static int firstUniqChar1(String s) {
		HashMap<Character, Integer> count = new HashMap<>();
		for (int i = 0; i < s.length(); i ++) {
			int cur = count.getOrDefault(s.charAt(i), 0);
			count.put(s.charAt(i), cur + 1);
		}
		for (int i = 0; i < s.length(); i ++) {
			if (count.getOrDefault(s.charAt(i), 0) == 1) {
				return i;
			}
		}
		return -1;
	}

	public static int firstUniqChar(String s) {
		char[] arr = s.toCharArray();
		if (arr.length == 1) {
			return 0;
		} else if(arr.length < 1) {
			return -1;
		}
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (i != j) {
					if (arr[i] == arr[j]) {
						count++;
						break;
					}
				}
			}
			if (count == 0) {
				return i;
			}
		}
		return -1;
	}
}
