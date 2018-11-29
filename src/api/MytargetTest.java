package api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
//定义个一注解@MyTarget，用RetentionPolicy.RUNTIME修饰；
@Retention(RetentionPolicy.RUNTIME)
@interface Mytarget{
}
public class MytargetTest {
	@Mytarget
	public void doSomething(){
		System.out.println("hello world");
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Method method = MytargetTest.class.getMethod("doSomething",null);
		if(method.isAnnotationPresent(Mytarget.class)){
			System.out.println(method.getAnnotation(Mytarget.class));
		}
	}
}
