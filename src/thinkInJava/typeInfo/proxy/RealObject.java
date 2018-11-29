/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月19日 下午3:26:29
* 创建作者：伍恰
* 文件名称：RealObject.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo.proxy;

public class RealObject implements ProxyInterface{

    @Override
    public void doSomething() {
        // TODO Auto-generated method stub
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        // TODO Auto-generated method stub
        System.out.println("somethingElse"+arg);
    }
    
}
