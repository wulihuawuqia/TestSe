/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年8月11日 下午3:25:01
* 创建作者：伍恰
* 文件名称：RmiSampleServerJndi.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package jndiDemo;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import rmiDemo.HelloImpl;
import rmiDemo.IHello;

public class RmiSampleServerJndi {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(8888);
            IHello ihello=new HelloImpl();
            System.setProperty(Context.PROVIDER_URL,"rmi://localhost:8888");
            System.setProperty(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.rmi.registry.RegistryContextFactory");
            InitialContext ctx = null;
            try {
                ctx = new InitialContext();
            } catch (NamingException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                ctx.bind("java:comp/env/SampleDemo",ihello);
                ctx.close();
                System.out.println(">>>>>INFO:远程IHello对象绑定成功！");
            } catch (NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
