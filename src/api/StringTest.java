package api;

import java.util.UUID;

import org.junit.Test;

public class StringTest {
	@Test
	public void Test1(){
		String a=new String();
		String b="";
		String c=new String();
		String d="";
		System.out.println(a==b);
		System.out.println(a==c);
		System.out.println(b==d);
		StringBuffer buffer=new StringBuffer();
		System.out.println(a.length());
		System.out.println(buffer);
		a=b;
		b="1";
		System.out.println(a);
		System.out.println(b);
	}
	@Test
	public void Test2(){
		System.out.println("aabbb".indexOf("c"));
	}
	@Test
	public void Test3(){
	    String formatUploadFileName = "%s/%s/%s";
	    String filePath = String.format(formatUploadFileName, "ZTE", "ABC","dsa");
	    System.out.println(filePath);
	}
	@Test
	public void test4(){
	    String uuid = UUID.randomUUID().toString().toLowerCase().replace("-", "");
	    System.out.println(uuid);
	}
	
	@Test
	public void test5() {
	    String batch = "20170719-Star-dsad-dsad-Net-1";
	    String [] arr=batch.split("-");
        System.out.println(arr[arr.length-1]);
	    int len = batch.lastIndexOf("-");
	    System.out.println(batch.substring(len+1, batch.length()));
	}
	
	@Test
    public void test6() {
        String aa = (String)null;
        System.out.println(aa);
    }
	
	@Test
	public void test7() {
	    Long a = 1L;
	    String b = "123"+a;
	    System.out.println(b);
	}

	@Test
	public void test8() {
		String a ="%sa%s";
		String  b = String.format(a, 1 ,2);
		System.out.println(b);
	}

	@Test
	public void testReplace() {
		String a ="a|b|c|d";
		String  b = a.replace("|","&#13;");
		System.out.println(b);
	}

}
