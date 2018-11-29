package thinkInJava.typeInfo;

// typeinfo/ShowMethods18.java
// TIJ4 Chapter Typeinfo, Exercise 18, page593
// Make ShowMethods a non-public class and verify that the synthesized default
// constructor no longer shows up in the output.
// {Args: ShowMethods18}
import java.lang.reflect.*;
import java.util.regex.*;

class ShowMethods18 {
	private static String usage =
		"usage:\n" +
		"ShowMethods qualified.class.name\n" +
		"To show all methods in class or:\n" +
		"ShowMethods qualified.class.name word\n" +
		"To search for methods involving 'word'";
	private static Pattern p = Pattern.compile("\\w+\\.");
	public static void main(String[] args) {
		if(args.length < 1) {
		    System.out.println(usage);
			System.exit(0);
		}
		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor[] ctors = c.getConstructors();
			if(args.length == 1) {
				for(Method method : methods) {
				    System.out.println(p.matcher(method.toString()).replaceAll(""));
				}
				for(Constructor ctor : ctors)
				    System.out.println(p.matcher(ctor.toString()).replaceAll(""));
				lines = methods.length + ctors.length;
			} else {
				for(Method method : methods)
					if(method.toString().indexOf(args[1]) != -1) {
					    System.out.println(p.matcher(method.toString()).replaceAll(""));
						lines++;
					}
				for(Constructor ctor : ctors) 
					if(ctor.toString().indexOf(args[1]) != -1) {
					    System.out.println(p.matcher(ctor.toString()).replaceAll(""));
						lines++;
				}
			}
		} catch(ClassNotFoundException e) {
		    System.out.println("No such class: " + e);
		}
	}
}