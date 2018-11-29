/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月19日 下午3:41:09
* 创建作者：伍恰
* 文件名称：DynamicProxyHandle.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandle implements InvocationHandler{
    private Object proxied;
    public DynamicProxyHandle(Object proxied) {
        // TODO Auto-generated constructor stub
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        // TODO Auto-generated method stub
        System.out.println("after");
        return method.invoke(proxied, args);
    }

}
