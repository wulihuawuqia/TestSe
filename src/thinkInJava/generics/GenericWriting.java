/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月30日 下午4:31:30
* 创建作者：伍恰
* 文件名称：GenericWriting.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericWriting {
    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }
    
    static List<Apple> apples = new ArrayList<Apple>();
    
    static List<Fruit> fruit = new ArrayList<>();
    
    static void f1() {
        writeExact(apples, new Apple());
        writeExact(fruit, new Apple());
    }
    
    static <T> void writeWithWildcard(List<? super T> list, T item){
        list.add(item);
    }
    
    static void f2() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruit, new Apple());
    }
    public static void main(String[] args) {
        f1();
        f2();
    }
}
