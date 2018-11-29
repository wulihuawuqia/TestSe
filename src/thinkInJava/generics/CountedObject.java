/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月23日 上午10:14:19
* 创建作者：伍恰
* 文件名称：CountedObject.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;
    public long id(){
        return id;
    }
    public String toString(){
        return "CountedObject"+id;
    }
}
