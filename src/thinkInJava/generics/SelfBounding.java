/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年7月14日 上午9:27:30
* 创建作者：伍恰
* 文件名称：SelfBounding.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

class SelfBounded<T extends SelfBounded<T>> {
    T element;
    SelfBounded<T> set(T arg){
        element = arg;
        return this;
    }
    T get() {
        return element;
    }
}

class AA extends SelfBounded<AA> {
    
}

class B extends SelfBounded<AA> {
    
}

class C extends SelfBounded<C> {
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}

class D {
    
}
//Bound mismatch: The type D is not a valid substitute for the bounded parameter <T extends SelfBounded<T>> of the type SelfBounded<T>
//class E extends SelfBounded<D> {}

class F extends SelfBounded {
    
}
public class SelfBounding {
    public static void main(String[] args) {
        AA a = new AA();
        a.set(new AA());
        a = a.set(new AA()).get();
        a = a.get();
        C c = new C();
        c = c.setAndGet(new C());
    }
}
