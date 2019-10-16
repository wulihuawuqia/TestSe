package lambda;

import api.SystemOut;

import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 * 异常打印
 *
 * @author qia.wu
 * @create 2019-05-23 15:32
 */
public class TryTest {
	public static void main(String[] args){
		List<String> a = Arrays.asList("1","2");
		a.forEach(s -> a());
		try{
			//a();
			a = Arrays.asList("1","2");
			a.forEach(s -> a());
		}catch (Exception e){
			e.printStackTrace();
		}


	}

	private static void a(){
		System.out.println(0 == new Integer(null));
		System.out.println(1/0);

	}
}
