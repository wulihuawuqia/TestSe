/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月15日 下午3:37:46
* 创建作者：伍恰
* 文件名称：IntegerMatch.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.string;

public class IntegerMatch {
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+1234".matches("-?\\d+"));
        System.out.println("-123".matches("(-|\\+)?\\d+"));
    }
}
