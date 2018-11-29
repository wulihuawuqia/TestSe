package rmiDemo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
* @ClassName: HelloImpl
* @Description: 远程接口实现
* @author wuqia
* @date 2017年5月19日 下午1:17:33
*
 */
public class HelloImpl extends UnicastRemoteObject implements IHello{

	public HelloImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String helloWorld() throws RemoteException {
		// TODO Auto-generated method stub
		return "Hello World!!!";
	}

	@Override
	public String sayHello(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return "Hello World "+name+"!!!";
	}

}
