package api;

import java.math.BigDecimal;

import org.junit.Test;

public class IntegerTest {
	@Test
	public void Test1(){
		Integer a=127;
		Integer b=new Integer(127);
		int c=1;
		Integer d=new Integer(127);
		Integer e=1;
		Integer f=1000;
		Integer h=1000;
		System.out.println(a==b);
		System.out.println(a==c);
		System.out.println(b==d);
		System.out.println(a==e);
		System.out.println(f==h);
		BigDecimal bd=new BigDecimal(1);
	}
}
