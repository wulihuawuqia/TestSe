package thinkInJava.generics;

// generics/ClassTypeCapture24.java
// TIJ4 Chapter Generics, Exercise 24, page 667
// Modify Exercise 21 so that factory objects are held in the Map instead of Class<?>.
import java.util.*;

class BuildingFactory implements Factory<Building> {
	public Building create() {
		return new Building();
	}
}

class HouseFactory implements Factory<House> {
	public House create() {
		return new House();
	}
}

public class ClassTypeCapture24<T> {
	Class<?> kind;
	public ClassTypeCapture24(Class<?> kind) {
		this.kind = kind;
	}
	Map<String,Factory> map;	
	public ClassTypeCapture24(Class<?> kind, Map<String,Factory> map) {
		this.kind = kind;
		this.map = map;
	}
	public boolean f(Object arg) {
		return kind.isInstance(arg);
	}
	public void addType(String typename, Factory factory) {
		map.put(typename, factory);
	}
	public Object createNew(String typename) 
		throws IllegalAccessException, InstantiationException {
		if(map.containsKey(typename))
			return map.get(typename).create();			
		System.out.println(typename + " class not available");
		return null;
	}
	public static void main(String[] args) {
		ClassTypeCapture24<Building> ctt1 = 
			new ClassTypeCapture24<Building>(Building.class);
		System.out.println(ctt1.f(new Building()));
		System.out.println(ctt1.f(new House()));
		ClassTypeCapture24<House> ctt2 = 
			new ClassTypeCapture24<House>(House.class);
		System.out.println(ctt2.f(new Building()));
		System.out.println(ctt2.f(new House()));
		ClassTypeCapture24<Building> ct = 
		new ClassTypeCapture24<Building>(
			Building.class, new HashMap<String,Factory>());
		ct.addType("House", new HouseFactory());
		ct.addType("Building", new BuildingFactory());
		System.out.println("ct.map = " + ct.map);
		try {
			Building b = (Building)ct.createNew("Building");
			House h = (House)ct.createNew("House");
			System.out.println("b.getClass().getName(): ");
			System.out.println(b.getClass().getName());
			System.out.println("h.getClass().getName(): ");
			System.out.println(h.getClass().getName());
			System.out.println("House h is instance House: ");
			System.out.println(h instanceof House);
			System.out.println("House h is instance of Building: ");
			System.out.println(h instanceof Building);
			System.out.println("Building b is instance of House: ");
			System.out.println(b instanceof House);
			ct.createNew("String");  // String class not available
		} catch(IllegalAccessException e) {
			System.out.println("IllegalAccessException in main");
		} catch(InstantiationException e) {
			System.out.println("InstantiationException in main");
		}		
	}
}