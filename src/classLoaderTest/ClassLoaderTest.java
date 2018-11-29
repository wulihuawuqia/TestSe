package classLoaderTest;

public class ClassLoaderTest {
	public static void main(String[] args) {
		ClassLoader loader=ClassLoaderTest.class.getClassLoader();
		while (loader.getParent()!=null){
			System.out.println(loader.toString());
			loader=loader.getParent();
		}
		System.out.println(loader);
	}
}
