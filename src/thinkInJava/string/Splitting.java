/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月15日 下午3:43:08
* 创建作者：伍恰
* 文件名称：Splitting.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.string;

import java.util.Arrays;

public class Splitting {
    public static String knights = "Then when you ";
    public static void main(String[] args) {
        System.out.println(Arrays.toString(knights.split(" ")));
        System.out.println(Arrays.toString(knights.split("\\w+")));
        System.out.println(Arrays.toString(knights.split("n\\w+")));
        
    }
}
