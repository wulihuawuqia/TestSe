package thinkInJava.arrays;

// arrays/Ex20.java
// TIJ4, Chapter Arrays, Exercise 20, page 778
// Demonstrate deepEquals() for multidimensional arrays.
import java.util.*;

class Aa {}

public class Ex20 {
	public static void main(String[] args) {
		int[][][] a1 = new int[4][3][2];
		int[][][] a2 = new int[4][3][2];
		System.out.println(Arrays.deepToString(a1));
		System.out.println(Arrays.deepEquals(a1, a2));
		Aa[][][] aa1 = new Aa[4][3][2];
		Aa[][][] aa2 = new Aa[4][3][2];
		System.out.println(Arrays.deepToString(aa1));
		System.out.println(Arrays.deepEquals(aa1, aa2));
		System.out.println(Arrays.deepEquals(a1, aa1));	
	}
}
