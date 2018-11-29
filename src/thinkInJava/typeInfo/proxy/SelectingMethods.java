/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月19日 下午3:50:58
* 创建作者：伍恰
* 文件名称：SelectingMethods.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class MethodSelector implements InvocationHandler{
    private Object proxied;
    public static int count =0;
    public MethodSelector(Object proxied) {
        // TODO Auto-generated constructor stub
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        // TODO Auto-generated method stub
        System.out.println(args);
        if(args==null&&method.getName().equals("interesting")){
            System.out.println("after interesting");
            count++;
        };
        return method.invoke(proxied, args);
    }
    
}
interface SomeMethods{
    void boring();
    void interesting(String arg);
    void interesting();
}
class SomeMethodsImpl implements SomeMethods{

    @Override
    public void boring() {
        // TODO Auto-generated method stub
        System.out.println("boring");
    }

    @Override
    public void interesting(String arg) {
        // TODO Auto-generated method stub
        System.out.println("interesting" + arg);
    }

    @Override
    public void interesting() {
        // TODO Auto-generated method stub
        System.out.println("interesting");
    }
    
}
public class SelectingMethods {
    public static void main(String[] args) {
        SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(SomeMethods.class.getClassLoader(),
               new Class[]{SomeMethods.class}, new MethodSelector(new SomeMethodsImpl()));
        proxy.boring();
        proxy.interesting();
        proxy.interesting("aa");
    }
}
