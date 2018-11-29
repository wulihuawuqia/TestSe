package thinkInJava.polymorphism.shape;

//: polymorphism/shape/Square.java

public class Square extends Shape {
  public void draw() { System.out.println("Square.draw()"); }
  public void erase() { System.out.println("Square.erase()"); }
  public void eraseOther() { System.out.println("Square.eraseOther()"); }
} ///:~
