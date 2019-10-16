package test.base;

import api.SystemOut;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * 描述: 浅拷贝 和 深拷贝
 *
 * @author qia.wu
 * @create 2019-03-25 11:46
 */
public class cloneTest {

	/**
	 * 测试
	 */
	@Test
	public void test1() throws CloneNotSupportedException {
		Body body = new Body("test", new Head("11"));
		Body body1 = (Body)body.clone();
		System.out.println(body == body1);
		System.out.println(body.getName() == body1.getName());
		System.out.println(body.getHead() == body1.getHead());
	}

	/**
	 * org.springframework.beans.BeanUtils.copyProperties  深拷贝
	 * 测试
	 */
	@Test
	public void test2(){
		Body body = new Body("test", new Head("11"));
		Body body1 = new Body();
		BeanUtils.copyProperties(body, body1);
		System.out.println(body.getName() == body1.getName());  // true
		System.out.println(body.getHead() == body1.getHead());	// true
	}

	/**
	 * org.apache.commons.beanutils.BeanUtils.copyProperties 深拷贝
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@Test
	public void test3() throws InvocationTargetException, IllegalAccessException {
		Body body = new Body("test", new Head("11"));
		Body body1 = new Body();
		org.apache.commons.beanutils.BeanUtils.copyProperties(body, body1);
		System.out.println(body.getName() == body1.getName());  // false
		System.out.println(body.getHead() == body1.getHead());	// false
	}

}

class Body implements Cloneable{

	Body(){

	}
	Body(String name, Head head){
		this.name = name;
		this.head = head;
	}

	private String name;
	private Head head;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Body body =  (Body)super.clone();
		body.setName(new String(body.getName()));
		body.setHead((Head)body.getHead().clone());
		return body;
	}
}

class Head implements Cloneable{

	Head(String msg) {
		this.msg = msg;
	}
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
