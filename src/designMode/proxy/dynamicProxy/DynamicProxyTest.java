/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年9月27日 下午8:16:10
* 创建作者：伍恰
* 文件名称：DynamicProxyTest.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package designMode.proxy.dynamicProxy;

public class DynamicProxyTest {
    
    
    public static void main(String[] args) {
        BusinessImpl bfoo = new BusinessImpl();
        Business bf = (Business)BusinessImplProxy.factory(bfoo);
        
        bf.doAction(); 
        
        /*;
        System.out.println();
        
        BusinessBarImpl bbar = new BusinessBarImpl();
        BusinessBar bb = (BusinessBar)BusinessImplProxy.factory(bbar);
        String message = bb.bar("Hello,World");
        System.out.println(message);*/
    }
    
    
}
