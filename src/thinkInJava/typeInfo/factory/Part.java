/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月19日 上午11:37:55
* 创建作者：伍恰
* 文件名称：Part.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Part {
    public String toString(){
        return getClass().getSimpleName();
    }
    
    static List<Factory<? extends Part>> partFactories =
            new ArrayList<>();
    static {
        partFactories.add(new AirFilter.FactoryImpl());
        partFactories.add(new FuelFilter.FactoryImpl());
        partFactories.add(new FanBelt.FactoryImpl());
    }
    private static Random rand = new Random(47);
    public static Part createRandom(){
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}
