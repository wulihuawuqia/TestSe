/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年7月14日 下午5:03:15
* 创建作者：伍恰
* 文件名称：ConvariantReturnTypes.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

import org.junit.Test;

class Base {}

class Derived extends Base {
    
}

class OrdinaryGetter {
    Base get(){
        System.out.println("Base");
        return new Base();
    };
}

class DerivedGetter extends OrdinaryGetter {
    Derived get(){
        System.out.println("Derived");
        return new Derived();
    };
}

public class ConvariantReturnTypes {
    @Test
    public void test(){
        DerivedGetter d = new DerivedGetter();
        Derived d2 = d.get();
        Base b = d.get();
    }
}
