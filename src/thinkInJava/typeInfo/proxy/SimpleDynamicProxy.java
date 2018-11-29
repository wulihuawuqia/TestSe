/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月19日 下午3:43:48
* 创建作者：伍恰
* 文件名称：SimpleDynamicProxy.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo.proxy;

import java.lang.reflect.Proxy;

public class SimpleDynamicProxy {
    public static void consume(ProxyInterface iface){
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        RealObject real = new RealObject();
        consume(real);
        ProxyInterface proxy = (ProxyInterface) Proxy.newProxyInstance(ProxyInterface.class.getClassLoader(), 
                new Class[]{ProxyInterface.class}, new DynamicProxyHandle(real));
        proxy.doSomething();
        proxy.somethingElse("ad");
    }
}
