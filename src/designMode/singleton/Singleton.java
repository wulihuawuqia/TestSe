package designMode.singleton;

public class Singleton {
	private static int count1;
	private static int count2 = 0;
	private static Singleton singleton = new Singleton();
	private Singleton() {
		count1++;
		count2++;
		
		System.out.println("count1="+count1);
		System.out.println("count2="+count2);
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
	
	public static void main(String[] args) {
		Singleton singleton = getInstance();
		System.out.println("main.count1="+singleton.count1);
		System.out.println("main.count2="+singleton.count2);
	}
		
}
