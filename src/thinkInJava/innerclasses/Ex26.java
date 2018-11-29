package thinkInJava.innerclasses;

import thinkInJava.innerclasses.Outer1.Inner1;

class Outer{
	class Inner{
		public Inner(String a) {
			// TODO Auto-generated constructor stub
			System.out.println(a);
		}
	}
}
class Outer1{
	class Inner1 extends Outer.Inner{
		public Inner1(Outer outer, String a) {
			outer.super(a);
		}
	}
}
public class Ex26 {
	public static void main(String[] args) {
		Outer o = new Outer();
		//Inner1 l1 = new Inner1(o,"asd");
	}
}
