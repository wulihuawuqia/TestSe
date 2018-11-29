/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月19日 下午2:14:10
* 创建作者：伍恰
* 文件名称：RegisteredClasses14.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Part1 {
    public String toString() {
        return getClass().getSimpleName();
    }
    static List<Class<? extends Part>> partClasses = 
        new ArrayList<Class<? extends Part>>();
    static {
        // Collections.addAll() gives an "unchecked generic
        // array creation ... for varargs parameter" warning.
        partClasses.add(FuelFilter.class);
        partClasses.add(AirFilter.class);
        partClasses.add(FanBelt.class);
    }
    private static Random rand = new Random();
    public static Part createRandom() {
        int n = rand.nextInt(partClasses.size());
        try {
            return partClasses.get(n).newInstance();
        } catch(InstantiationException e) {
            throw new RuntimeException(e);
        } catch(IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    } 
}
public class RegisteredClasses14 {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++)
            System.out.println(Part.createRandom());
    }
}
