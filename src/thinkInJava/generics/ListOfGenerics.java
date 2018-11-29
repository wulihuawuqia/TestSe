/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月30日 上午11:26:04
* 创建作者：伍恰
* 文件名称：ListOfGenerics.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

import java.util.ArrayList;
import java.util.List;

public class ListOfGenerics<T> {
    private List<T> array = new ArrayList<>();
    public void add(T item) {
        array.add(item);
    }  
    public T get(int index) {
        return array.get(index);
    }
}
