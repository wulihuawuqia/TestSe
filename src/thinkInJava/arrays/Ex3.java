/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年7月28日 下午2:19:18
* 创建作者：伍恰
* 文件名称：Ex3.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.arrays;

import java.util.Arrays;

public class Ex3 {
    public static double [][] getArray(int i, int j){
        double arr[][] = new double [i][j];
        for(int k = 0; k<i; k++){
            for( int h = 0; h<j; h++){
                arr[k][h] = k*h;
            }
        }
        return arr;
    }
    public static void print(double [][] arr){
        for(int i = 0; i < arr.length ; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    public static void main(String[] args) {
        print(getArray(3, 3));
        print(getArray(4, 3));
        print(getArray(6, 9));
        print(getArray(1, 9));
    }
}
