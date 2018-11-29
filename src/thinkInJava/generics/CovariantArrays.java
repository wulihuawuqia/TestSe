/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月30日 下午3:27:11
* 创建作者：伍恰
* 文件名称：Co.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

class Fruit {
    
}

class Apple extends Fruit {
    
}

class Jonathan extends Apple {
    
}

class Orange extends Fruit {
    
}
public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple();
        fruit[1] = new Jonathan();
        /*java.lang.ArrayStoreException
        fruit[2] = new Fruit();
        fruit[3] = new Orange();*/
    }
}
