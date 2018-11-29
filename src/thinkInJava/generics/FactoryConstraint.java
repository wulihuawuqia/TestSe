/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月29日 下午5:30:33
* 创建作者：伍恰
* 文件名称：FactoryConstraint.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

interface Factory<T> {
    T create();
}

class Foo2<T> {
    @SuppressWarnings("unused")
    private T x;
    public <F extends Factory<T>> Foo2(F factory) {
        x = factory.create();
    }
}

class IntegerFactory implements Factory<Integer> {

    @Override
    public Integer create() {
        return new Integer(0);
    }
    
}

class Widget {
    public static class Factory1 implements Factory<Widget> {
        public Widget create() {
            return new Widget();
        }
    }
}
public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.Factory1());
    }
}
