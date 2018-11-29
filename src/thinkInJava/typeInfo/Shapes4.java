package thinkInJava.typeInfo;

// typeinfo/Shapes4.java
// TIJ4 Chapter Typeinfo, Exercise 4, page 561
/* Modify the previous exercise so that it uses instancof to check the
* type before performing the downcast.
*/
import java.util.*;


public class Shapes4 {
	public static void main(String[] args) {
		// upcasting to Shape:
		List<Shape> shapeList = Arrays.asList(
			new Circle(), new Square(), new Triangle(), new Rhomboid()
		);
		// downcasting back to specific shape:
		for(Shape shape : shapeList)
			shape.draw();
		Rhomboid r = new Rhomboid();
		// Upcast:
		Shape s = (Shape)r;
		s.draw();
		// check type before downcast:
		if(s instanceof Circle) 
			((Circle)s).draw();
		else if(!(s instanceof Circle))
			System.out.println("(Shape)r is not a Circle");		
	}
}