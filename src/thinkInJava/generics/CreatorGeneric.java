/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月30日 上午9:28:00
* 创建作者：伍恰
* 文件名称：CreatorGeneric.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

abstract class GenericWithCreate<T> {
    final T element;
    abstract T create();
    GenericWithCreate() {
        element = create();
    }
}
class X {
    
}

class Creator extends GenericWithCreate<X> {

    @Override
    X create() {
        return new X();
    }
    void f(){
        System.out.println(element.getClass().getSimpleName());
    }
}
public class CreatorGeneric {
    public static void main(String[] args) {
        Creator c = new Creator();
        c.f();
    }
}
