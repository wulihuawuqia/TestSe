/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月30日 下午4:28:14
* 创建作者：伍恰
* 文件名称：SuperTypeWildcards.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

import java.util.List;

public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
    }
}
