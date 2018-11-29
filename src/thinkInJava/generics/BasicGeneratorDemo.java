/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月23日 上午10:15:59
* 创建作者：伍恰
* 文件名称：BasicGeneratorDemo.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

public class BasicGeneratorDemo {
    public static void main(String[] args) {
        BasicGenerator<CountedObject> gen = 
                BasicGenerator.create(CountedObject.class);
        for(int i = 0; i < 5;i++){
            System.out.println(gen.next());
        }
    }
}
