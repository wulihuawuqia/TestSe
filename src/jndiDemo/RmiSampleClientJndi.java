/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年8月11日 下午4:39:22
* 创建作者：伍恰
* 文件名称：RmiSampleClientJndi.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package jndiDemo;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import rmiDemo.IHello;

public class RmiSampleClientJndi {
    public static void main(String[] args) {
        System.setProperty(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.rmi.registry.RegistryContextFactory");
        System.setProperty(Context.PROVIDER_URL,"rmi://localhost:8888");
        InitialContext ctx = null;
        try {
            ctx = new InitialContext();
        } catch (NamingException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        String url = "java:comp/env/SampleDemo";
        IHello iHello;
        try {
            iHello = (IHello)ctx.lookup(url);
            System.out.println(iHello.helloWorld());
            String name = "伍恰";
            System.out.println(iHello.sayHello(name));
            name = "aavv";
            System.out.println(iHello.sayHello(name));
        } catch (NamingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
