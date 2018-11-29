/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月30日 下午2:07:19
* 创建作者：伍恰
* 文件名称：GenericArrayWithTypeToke.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

import java.lang.reflect.Array;

public class GenericArrayWithTypeToke<T> {
    private T[] array;
    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToke(Class<T> type, int size) {
        array = (T[]) Array.newInstance(type, size);
    }
    
    public void put(int index, T item) {
        array[index] = item;
    }
    
    public T get(int index){
        return array[index];
    }
    
    public T[] rep () {
        return array;
    }
    
    public static void main(String[] args) {
        GenericArrayWithTypeToke<Integer> gai = 
                new GenericArrayWithTypeToke<>(Integer.class,  10);
        Integer[] ia = gai.rep();
    }
}
