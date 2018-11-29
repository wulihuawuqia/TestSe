/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年7月14日 上午9:13:43
* 创建作者：伍恰
* 文件名称：BasicHolder.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

public class BasicHolder<T> {
    T element;
    void set(T arg) {
        element = arg;
    }
    
    T get() {
        return element;
    }
    
    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}
