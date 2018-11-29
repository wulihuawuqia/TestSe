package thinkInJava.reuse;

public class FinalTest {
	//static final int a;The blank final field a may not have been initialized
	static final int a=1;
	static final Integer b=2;
	final int c;
	final Integer d=2;
	static final StringBuffer sb=new StringBuffer("sdas");
	FinalTest(){
		c=1;
	}
	void testFinl(final String a){
		//a=new String();The final local variable a cannot be assigned. It must be blank and not using a compound assignment
	}
	public static void main(String[] args) {
		final int e=1;
		final Integer f=1;
		//a=a+1;
		//b=b+1;
		Integer g=b;
		g++;
		System.out.println(g);
		System.out.println(b);
		StringBuffer sb1=sb;
		sb.append("12");
		System.out.println(sb);
		sb1.append("34");
		System.out.println(sb1);
		System.out.println(sb);
	}
}	
