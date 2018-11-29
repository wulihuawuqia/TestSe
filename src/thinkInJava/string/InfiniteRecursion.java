package thinkInJava.string;

//: strings/InfiniteRecursion.java
// Accidental recursion.
// {RunByHand}
import java.util.*;

public class InfiniteRecursion {
  public String toString() {
      //递归异常 java.lang.StackOverflowError
    //return " InfiniteRecursion address: " + this + "\n";
      return " InfiniteRecursion address: " + super.toString() + "\n";
  }
    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
        for (int i = 0; i < 10; i++)
            v.add(new InfiniteRecursion());
            System.out.println(v);
    }
} ///:~
