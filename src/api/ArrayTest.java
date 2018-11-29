package api;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ArrayTest {
	@Test
	public void Test1(){
		int [][] arr = new int[5][5];
		int len=arr.length;
		for(int i=0;i<len;i++){
			System.out.println(Arrays.toString(arr[i]));
		}
		
	}
	@Test
	public void test2(){
	    List<Object> lists = new ArrayList<Object>();  
	    System.out.println(lists.size());
	    lists.add("1");  
	    lists.add("2");  
	    lists.add("3");  
	    lists.add("4");  
	    System.out.println(lists.size());
	    List<Object> tempList = lists.subList(0, 2);  
	    System.out.println(tempList.size());
	    System.out.println(tempList.indexOf("1"));
	    tempList.add(0,"6");  
	    System.out.println(tempList.indexOf("1"));
	    tempList.remove(0);
	    System.out.println(tempList.indexOf("1"));
	    System.out.println(tempList); // 1  
	  
	    System.out.println(lists); // 2  
	}
}
