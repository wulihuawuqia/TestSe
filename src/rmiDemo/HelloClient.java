package rmiDemo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 
* @ClassName: HelloClient
* @Description: RMI客户端
* @author wuqia
* @date 2017年5月19日 下午1:21:53
*
 */
public class HelloClient {
	public static void main(String[] args) {
		//在RMI服务注册表中查找ihello对象，并调用方法
		try {
			IHello iHello=(IHello)Naming.lookup("rmi://localhost:8888/ihello");
			System.out.println(iHello.helloWorld());
			String name = "伍恰";
			System.out.println(iHello.sayHello(name));
			name = "aavv";
			System.out.println(iHello.sayHello(name));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
