package rmiDemo;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
/**
 * 
* @ClassName: HelloServer
* @Description: RMI服务端搭建
* @author wuqia
* @date 2017年5月19日 下午1:20:52
*
 */
public class HelloServer {
	public static void main(String[] args) {
		try {
			//创建远程对象
			IHello ihello=new HelloImpl();
			
			//本机远程对象注册表Registry实例，并指定端口为8888，打开服务器
			LocateRegistry.createRegistry(8888);
			//把远程对象注册到RMI服务器，并命名
			Naming.bind("rmi://localhost:8888/ihello",ihello);
			System.out.println(">>>>>INFO:远程IHello对象绑定成功！");
		} catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("创建远程对象发生异常！"); 
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
