package thinkInJava.polymorphism;

// polymorphism/ReferenceCounting13.java
// TIJ4 Chapter Polymorphism, Exercise 13, page 300
/* Add a finalize() method to ReferenceCounting.java to verify the termination
* condition (see the Initialization & Cleanup chapter).
*/

class Shared {
	private int refcount = 0;
	private static long counter = 0;
	private final long id = counter++;
	public void showRefcount() { System.out.println("refcount = " + refcount); }	
	public Shared() {
		System.out.println("Creating " + this);
	}
	public void addRef() { refcount++; }
	protected void finalize() {
		if(refcount > 0)
			System.out.println("Error: " + refcount + " Shared " + id + " objects in use");
	}
	protected void dispose() {
		if(--refcount == 0)
			System.out.println("Disposing " + this);
	}
	public String toString() { return "Shared " + id; }
}

class Composing {
	private Shared shared;
	private static long counter = 0;
	private final long id = counter++;
	public Composing(Shared shared) {
		System.out.println("Creating " + this);
		this.shared = shared;
		this.shared.addRef();
	}
	protected void dispose() {
		System.out.println("Disposing " + this);
		shared.dispose();
	}
	public String toString() { return "Composing " + id; }
}

public class ReferenceCounting13 {
	public static void main(String[] args) {
		Shared shared = new Shared();
		Composing[] composing = { new Composing(shared),
			new Composing(shared), new Composing(shared),
			new Composing(shared), new Composing(shared)			
		};
		for(Composing c : composing)
			c.dispose();
		Composing compTest = new Composing(shared);
		Composing compTest2 = new Composing(shared);
		compTest.dispose();
		compTest2.dispose();
		// Test finalize():
		shared.finalize();
		Shared sharedTest = new Shared();
		Composing compTest3 = new Composing(sharedTest);
		// Test sharedTest finalize():
		sharedTest.finalize();
	}
}

