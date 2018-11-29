/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月16日 下午2:36:58
* 创建作者：伍恰
* 文件名称：BoundedClassReferences.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo;

public class BoundedClassReferences {
    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
        //bounded = String.class;
        
    }
}
