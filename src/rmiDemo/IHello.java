package rmiDemo;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * 
* @ClassName: IHello
* @Description: 定义一个远程接口，必须继承Remote 接口，其中需要远程调用的方法必须抛出RemoteException
* @author wuqia
* @date 2017年5月19日 下午1:16:32
*
 */
public interface IHello extends Remote{
	/**
	 * 
	* @Title: helloWorld
	* @Description: 返回Hello Word
	* @return
	* @throws RemoteException  参数描述
	* @return String 返回类型描述
	* @throws
	* @data 2017年5月19日
	* @author wuqia
	 */
	public String helloWorld() throws RemoteException;
	
	/**
	 * 
	* @Title: sayHello
	* @Description: 根据名字 返回问候语
	* @param name
	* @return
	* @throws RemoteException  参数描述
	* @return String 返回类型描述
	* @throws
	* @data 2017年5月19日
	* @author wuqia
	 */
	public String sayHello(String name) throws RemoteException;
	
}
