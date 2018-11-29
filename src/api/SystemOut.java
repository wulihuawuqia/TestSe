package api;

public class SystemOut {
	public static void main(String[] args) {
		String dir = System.getProperty("java.io.tmpdir");
		System.out.println(dir);
		System.out.println(System.currentTimeMillis());
	}
}
