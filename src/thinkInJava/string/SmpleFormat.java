/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月15日 下午2:11:32
* 创建作者：伍恰
* 文件名称：SmpleFormat.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.string;

public class SmpleFormat {
    public static void main(String[] args) {
        int x = 5;
        double y = 5.3324542;
        System.out.println("Row 1:["+ x + " " + y + "]");
        System.out.format("Row 1 :[%d %f]\n",x,y);
        System.out.printf("Row 1 :[%d %f]\n",x,y);
    }
}
