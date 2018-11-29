/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月16日 下午2:31:56
* 创建作者：伍恰
* 文件名称：Generu.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo;

public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericClass = int.class;
        
        Class<?> genericCommon = int.class;
        genericClass = Integer.class;
        //genericClass = double.class;
        genericCommon = double.class;
        genericCommon = int.class;
    }
}
