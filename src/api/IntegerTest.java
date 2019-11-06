package api;

import java.math.BigDecimal;

import org.junit.Test;

public class IntegerTest {
	@Test
	public void Test1(){
		Integer a=127;
		Integer a1=127;
		Integer b=new Integer(127);
		int c=127;
		Integer d=new Integer(127);
		Integer e=1;
		Integer f=1000;
		Integer h=1000;
		//true
		System.out.println(a==a1);
		// false
		System.out.println(a==b);
		// true
		System.out.println(a==c);
		// false
		System.out.println(b==d);
		// false
		System.out.println(a==e);
		// false
		System.out.println(f==h);

		a = a + b;
		a += b;
		BigDecimal bd=new BigDecimal(1);
	}
}
