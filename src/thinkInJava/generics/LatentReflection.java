/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年7月17日 下午4:41:50
* 创建作者：伍恰
* 文件名称：LatentReflection.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

import java.lang.reflect.Method;

class Mime {
    public void walkAgainstTheWind() {
        
    }
    
    public void sit() {
        System.out.println("Pretending to sit");
    }
    
    public void pushInvisibleWalls() {
        
    }

    public String toString() {
        return "Mime";
    }
}

class SmartDog {
    public void speak() {
        System.out.println("Woof!");
    }
    public void sit() {
        System.out.println("Sitting");
    }
}

class CommunicateReflectively {
    public static void perform(Object speaker) {
        Class<?> spkr = speaker.getClass();
        System.out.println(spkr);
        try {
            try {
                Method sperk = spkr.getMethod("speak");
                sperk.invoke(speaker);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            Method sit = spkr.getMethod("sit");
            sit.invoke(speaker);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}

public class LatentReflection {
    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Robot1());
        CommunicateReflectively.perform(new Mime());
    }
}   
