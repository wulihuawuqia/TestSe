/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月19日 下午3:09:29
* 创建作者：伍恰
* 文件名称：ShowMethods.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {
    private static Pattern p = Pattern.compile("(\\w+\\.)|\\s*final|\\s*native");
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("thinkInJava.typeInfo.ShowMethods");
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            for(Method method : methods){
                System.out.println(method);
                System.out.println(p.matcher(method.toString()).replaceAll(""));
            }
            for(Constructor ctor : ctors){
                System.out.println(ctor);
                System.out.println(p.matcher(ctor.toString()).replaceAll(""));
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
