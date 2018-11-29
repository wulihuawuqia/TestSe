/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月30日 下午4:17:35
* 创建作者：伍恰
* 文件名称：Holder.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

public class Holder<T> {
    private T value;
    public Holder() {
        
    }
    
    public Holder(T val) {
        value = val;
    }
    
    public void set(T val) {
        value = val;
    }
    
    public T get() {
        return value;
    }
    
    public boolean equals(Object obj) {
        return value.equals(obj);
    }
    
    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<>();
        Apple d = new Apple();
        apple.set(d);
        
        //Holder<Fruit> fruit = apple;
        Holder<? extends Fruit> fruit = apple;
        
        Fruit p = fruit.get();
        d = (Apple) fruit.get();
        /*java.lang.ClassCastException
        Orange c = (Orange) fruit.get();*/
        System.out.println(fruit.equals(d));
    }
}
