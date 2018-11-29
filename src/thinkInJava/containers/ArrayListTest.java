/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年10月16日 下午4:26:22
* 创建作者：伍恰
* 文件名称：ArrayListTest.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.containers;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    
    public static void main(String[] args) {
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        
        ArrayList<ArrayList> arr3 = new ArrayList<>();
        
        arr3.add(arr1);
        arr3.add(arr2);
        System.out.println(arr3);
    }
}
