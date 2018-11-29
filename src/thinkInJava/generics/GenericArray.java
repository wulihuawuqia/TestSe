/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月30日 下午1:51:08
* 创建作者：伍恰
* 文件名称：GenericArray.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

public class GenericArray<T> {
    private T[] array;
    
    @SuppressWarnings("unchecked")
    public GenericArray(int sz) {
        array = (T[])new Object[sz];
    }
    
    public void put(int index, T item) {
        array[index] = item;
    }
    
    public T get(int index) {
        return array[index];
    }
    
    public T[] rep() {
        return array;
    }
    
    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10);
        /*java.lang.ClassCastException
        Integer [] ia = gai.rep();*/
        Object[] oa = gai.rep();
    }
}
