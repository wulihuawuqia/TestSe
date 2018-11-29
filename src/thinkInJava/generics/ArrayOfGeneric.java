/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月30日 下午1:43:47
* 创建作者：伍恰
* 文件名称：ArrayOfGeneric.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer> [] gia;
    
    public static void main(String[] args) {
        //java.lang.ClassCastException
        ///gia = (Generic<Integer>[]) new Object[SIZE];
        //java.lang.NullPointerException
        gia = new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<Integer>();
        System.out.println(gia[0].getClass().getSimpleName());
        /*java.lang.ClassCastException:
        gia[1] = (Generic<Integer>) new Object();*/
        
    }
}
