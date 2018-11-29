//: polymorphism/PrivateOverride.java
// Trying to override a private method.
package thinkInJava.polymorphism.shape;

public class PrivateOverride {
  private void f() { System.out.println("private f()"); }
  public static void main(String[] args) {
    PrivateOverride po = new Derived();
    po.f();
    Derived dv = new Derived();
    dv.f();
  }
}

class Derived extends PrivateOverride {
  public void f() { System.out.println("public f()"); }
} /* Output:
private f()
*///:~
