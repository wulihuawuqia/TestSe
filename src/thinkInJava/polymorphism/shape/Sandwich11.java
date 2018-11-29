// polymorphism/Sandwich11.java
// TIJ4 Chapter Polymorphism, Exercise 11, page 295
// Add class Pickle to Sandwich.java
package thinkInJava.polymorphism.shape;

class Meal {
	static void test(){
		System.out.println("static meal");
	}
	Meal() { System.out.println("Meal()"); }
	Meal(String name) { System.out.println(name+":Meal()"); }
}

class Bread {
	private static Meal meal = new Meal("Bread");
	Bread() { System.out.println("Bread()"); } 
}

class Cheese {
	Cheese() { System.out.println("Cheese()"); } 
}

class Lettuce {
	Lettuce() { System.out.println("Lettuce()"); } 
}

class Pickle {
	Pickle() { System.out.println("Pickle()"); }
}

class Lunch extends Meal {
	Lunch() { System.out.println("Lunch()"); } 
}

class PortableLunch extends Lunch {
	PortableLunch() { System.out.println("PortableLunch()"); } 
}	

public class Sandwich11 extends PortableLunch {
	private static Bread b = new Bread();
	private Cheese c = new Cheese();
	private Pickle p = new Pickle();
	private Lunch l = new Lunch();
	public Sandwich11() { System.out.println("Sandwich()"); }
	public static void main(String[] args) {
		new Sandwich11();
	} 
}