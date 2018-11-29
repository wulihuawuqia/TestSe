package api.collections;

import java.util.LinkedList;

public class ListStack<T> {
	private LinkedList<T> storage = new LinkedList<>();
	/**
	 * 
	* @Title: push
	* @Description: 入栈
	* @param v  参数描述
	* @return void 返回类型描述
	* @throws
	* @data 2017年6月10日 下午3:35:02
	* @author wuqia
	 */
	public void push(T v) {
		storage.addFirst(v);
	}
	/**
	 * 
	* @Title: peek
	* @Description: 查找
	* @return  参数描述
	* @return T 返回类型描述
	* @throws
	* @data 2017年6月10日 下午3:35:51
	* @author wuqia
	 */
	public T peek(){
		return storage.getFirst();
	}
	/**
	* @Title: pop
	* @Description: 出栈
	* @return  参数描述
	* @return T 返回类型描述
	* @throws
	* @data 2017年6月10日 下午3:36:19
	* @author wuqia
	 */
	public T pop(){
		return storage.removeFirst();
	}
	/**
	* @Title: empty
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @return  参数描述
	* @return boolean 返回类型描述
	* @throws
	* @data 2017年6月10日 下午3:37:24
	* @author wuqia
	 */
	public boolean empty(){
		return storage.isEmpty();
	}
	public String toString(){
		return storage.toString();
	}
	public static void main(String[] args) {
		ListStack<Integer> stack = new ListStack<>();
		for(int i = 0;i<10;i++){
			stack.push(i);
			System.out.println(i+"入栈");
		}
		while(!stack.empty()){
			System.out.println(stack.pop()+"出栈");
		}
	}
}
