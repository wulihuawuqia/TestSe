/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年8月3日 下午5:02:22
* 创建作者：伍恰
* 文件名称：CopyingArrays.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.arrays;

import java.util.Arrays;

public class CopyingArrays {
    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i, 47);
        Arrays.fill(j, 99);
        
        System.out.println("i = "+Arrays.toString(i));
        System.out.println("j = "+Arrays.toString(j));
        System.arraycopy(i, 0, j, 0, i.length);
        
        System.out.println("j = "+Arrays.toString(j));
        
        int[] k = new int[5];
        
        Arrays.fill(k, 103);
        
        System.out.println("k = "+Arrays.toString(k));
        
        System.arraycopy(j, 0, k, 0, k.length);
        
        System.out.println("k = "+Arrays.toString(k));
        
        
    }
}
