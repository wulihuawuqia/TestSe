/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月19日 下午5:11:00
* 创建作者：伍恰
* 文件名称：NullRobotProxyHandle.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;
class NRobot implements Null,Robot{

    @Override
    public String name() {
        // TODO Auto-generated method stub
        return "nullName";
    }

    @Override
    public String model() {
        // TODO Auto-generated method stub
        return "nullName";
    }

    @Override
    public List<Operation> operations() {
        // TODO Auto-generated method stub
        return Collections.emptyList();
    }
    
}
class NullRobot{
    public static Robot newNullRobot(Class<? extends Robot> type){
        return (Robot)Proxy.newProxyInstance(NullRobot.class.getClassLoader()
                ,new Class[]{Null.class,Robot.class}, new NullRobotProxyHandle(type));
    }
}
public class NullRobotProxyHandle implements InvocationHandler{
    private String nullName;
    private Robot proxied = new NRobot();
    
    public NullRobotProxyHandle(Class<? extends Robot> type) {
        // TODO Auto-generated constructor stub
        this.nullName= type.getName();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        // TODO Auto-generated method stub
        return method.invoke(proxied, args);
    }
    public static void main(String[] args) {
        Robot [] bots = {
                new SnowRemovalRobot("ok"),
                NullRobot.newNullRobot(SnowRemovalRobot.class)
        };
        for(Robot bot : bots){
            Robot.Test.test(bot);
        }
    }
}
