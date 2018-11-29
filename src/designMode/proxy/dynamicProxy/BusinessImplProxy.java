/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年9月27日 下午8:13:57
* 创建作者：伍恰
* 文件名称：BusinessImplProxy.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package designMode.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BusinessImplProxy implements InvocationHandler{
    private Object obj;
    
    BusinessImplProxy() {
        
    }
    BusinessImplProxy(Object obj) {
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object result = null;
        doBefore();
        result = method.invoke(obj,args);
        doAfter();
        return result;
    }
    
    public static Object factory(Object obj) {
        Class cls = obj.getClass();
        return Proxy.newProxyInstance(cls.getClassLoader(),cls.getInterfaces(),new BusinessImplProxy(obj));
    }
    
    public void doBefore(){
        System.out.println("do something before Business Logic");
    }
    
    public void doAfter(){
        System.out.println("do something after Business Logic");
    }
}
