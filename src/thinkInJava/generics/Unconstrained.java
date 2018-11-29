/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年7月14日 上午9:12:39
* 创建作者：伍恰
* 文件名称：Unconstrained.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

class Other {}
class BasicOther extends BasicHolder<Other> {
    
}

public class Unconstrained {
    public static void main(String[] args) {
        BasicOther b = new BasicOther(), b2 = new BasicOther();
        b.set(new Other());
        Other other = b.get();
        b.f();
        
    }
}
