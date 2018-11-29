package acm;

public class ReplaceSpace {
	public static void main(String[] args) {
		StringBuffer str=new StringBuffer("We Are Happy");
		System.out.println(str.toString().replaceAll(" ", "%20"));
	}
}
