/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月19日 下午3:31:30
* 创建作者：伍恰
* 文件名称：SimpleProxyDemo.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo.proxy;

public class SimpleProxyDemo {
    public static void consumer(ProxyInterface iface){
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
