/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年7月17日 下午4:32:17
* 创建作者：伍恰
* 文件名称：DogsAndRobots.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

import thinkInJava.typeInfo.pets.Dog;

interface Performs {
    void speak ();
    void sit ();
}

class PerformingDog extends Dog implements Performs {

    @Override
    public void speak() {
        // TODO Auto-generated method stub
        System.out.println("Woof!");
    }

    @Override
    public void sit() {
        // TODO Auto-generated method stub
        System.out.println("Sitting");
    }
    
    void reproduce() {
        
    }
}

class Robot1 implements Performs {

    @Override
    public void speak() {
        // TODO Auto-generated method stub
        System.out.println("Click!");
    }

    @Override
    public void sit() {
        // TODO Auto-generated method stub
        System.out.println("Clank!");
    }
    
    public void oilChange() {
        
    }
}

class Communicate {
    public static <T extends Performs>
    void Performs(T performer){
        performer.sit();
        performer.speak();
    }
}

public class DogsAndRobots {
    public static void main(String[] args) {
        PerformingDog d = new PerformingDog();
        Robot1 r = new Robot1();
        Communicate.Performs(d);
        Communicate.Performs(r);
    }
}
