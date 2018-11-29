/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月15日 下午4:24:26
* 创建作者：伍恰
* 文件名称：Finding.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Finding {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("\\w+").matcher(""
                + "Evening is full of the linnet's wings");
        while(m.find()){
            System.out.println(m.group()+" ");
        }
    }
}
