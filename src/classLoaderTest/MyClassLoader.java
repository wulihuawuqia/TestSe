package classLoaderTest;

public class MyClassLoader extends ClassLoader{
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
        return loadClass(name, false);
    }
}
