package thinkInJava.typeInfo;

// typeinfo/SweetShop7.java
// TIJ4 Chapter Typeinfo, Exercise 7, page 561
/* Modify SweetShop.java so that each type of object creation is controlled
* by a command-line argument. That is, if your command line is "java 
* SweetShop Candy," then only the Candy object is created. Notice how you 
* can control which Class object are loaded via the command-line argument.
*/


class Candy {
	static { System.out.println("Loading Candy"); }
}

class Gum {
	static { System.out.println("Loading Gum"); } 
}

class Cookie {
	static { System.out.println("Loading Cookie"); }
}

public class SweetShop7 {
	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("Usage: sweetName");
			System.exit(0);
		}
		Class c = null;
		try {
			c = Class.forName(args[0]);
			System.out.println("Enjoy your " + args[0]);
		} catch(ClassNotFoundException e) {
			System.out.println("Couldn't find " + args[0]);
		}
	}
}