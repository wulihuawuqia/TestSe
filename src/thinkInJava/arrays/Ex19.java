package thinkInJava.arrays;

// arrays/Ex19.java
// TIJ4 Chapter Arrays, Exercise 19, page 778
/* Create a class with an int field that's initialized from a constructor
* argument. Create two arrays of these objects, using identical
* intitialization values for each array, and show that Arrays.equals() says
* that they are unequal. Add an equals() method to your class to fix the
* problem.
*/
import java.util.*;

class AArray {
	protected int x;
	AArray(int x) { this.x = x; }
	public boolean equals(Object b) {
		return (b.getClass().getSimpleName() == "AArray" 
			&& this.x == ((AArray)b).x) ? true : false;
	}
}

public class Ex19 {
	public static void main(String[] args) {
	    AArray[] a1 = { new AArray(1), new AArray(2), new AArray(3) };
	    AArray[] a2 = { new AArray(1), new AArray(2), new AArray(3) };
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
		System.out.println(Arrays.equals(a1, a2));
	}
}