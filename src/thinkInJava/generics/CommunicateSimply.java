/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年7月17日 下午4:39:09
* 创建作者：伍恰
* 文件名称：CommunicateSimply.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

public class CommunicateSimply {
    static void perform(Performs perfoms){
        perfoms.sit();
        perfoms.speak();
    }
    public static void main(String[] args) {
        CommunicateSimply.perform(new PerformingDog());
        CommunicateSimply.perform(new Robot1());
    }
}
