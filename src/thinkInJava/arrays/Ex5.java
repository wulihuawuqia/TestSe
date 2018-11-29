/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年7月28日 下午2:31:46
* 创建作者：伍恰
* 文件名称：Ex5.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.arrays;

import java.util.Arrays;

public class Ex5 {
    public static void main(String[] args) {
        int arr [][][] = new int[5][][];
        arr[1] = new int [5][5];
        arr[1][2][3] = 1;
        for(int i = 0; i < arr.length; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
