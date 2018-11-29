package api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
	String hello() default "hello";
	String world();
	int [] array()  default {2,4,6,8};
}
public class MyAnnotationTest {
	@MyAnnotation(hello="beijing",world="shanghai")
	public void output(){
		System.out.println("output something");
	}
	public static void main(String[] args) throws Exception {
		Method method = MyAnnotationTest.class.getMethod("output", null);
		method.invoke(new MyAnnotationTest(), null);
		if(method.isAnnotationPresent(MyAnnotation.class)){
			System.out.println("have annotation ");
			
			
			//获取注解上的信息
			MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
			
			String hello = myAnnotation.hello();
			String world = myAnnotation.world();
			System.out.println(hello);
			System.out.println(world);
			System.out.println(myAnnotation.array());
			
		}
		
	}
}
