/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月19日 下午2:09:42
* 创建作者：伍恰
* 文件名称：RegisteredFactories.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo.factory;

public class RegisteredFactories {
    public static void main(String[] args) {
        for(int i = 0;i < 10; i++){
            System.out.println(Part.createRandom());
        }
    }
}
