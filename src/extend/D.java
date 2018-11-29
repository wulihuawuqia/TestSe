/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月20日 上午11:15:10
* 创建作者：伍恰
* 文件名称：D.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package extend;

public class D extends B{

    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        
        System.out.println(a1.show(b));
        
        System.out.println(a1.show(c));
        
        System.out.println(a1.show(d));
        
        System.out.println(a2.show(b));
        
        System.out.println(a2.show(c));
        
        System.out.println(a2.show(d));
        
        System.out.println(b.show(b));
        
        System.out.println(b.show(c));
        
        System.out.println(b.show(d));
    }
}
