/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月19日 下午3:28:11
* 创建作者：伍恰
* 文件名称：SimpleProxy.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo.proxy;

public class SimpleProxy implements ProxyInterface{
    private ProxyInterface proxied;
    public SimpleProxy(ProxyInterface proxied) {
        this.proxied=proxied;
    }
    @Override
    public void doSomething() {
        // TODO Auto-generated method stub
        System.out.println("SimpleProxy");
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        // TODO Auto-generated method stub
        System.out.println("SimpleProxy");
        System.out.println("somethingElse"+arg);
    }
}
