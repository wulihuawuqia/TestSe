/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月26日 下午8:34:59
* 创建作者：伍恰
* 文件名称：QuickSortOne.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package acm;

import java.util.Arrays;

public class QuickSortOne {
    public static void main(String[] args) {
        int []a = {1,6,20,8,9,10,15,2}; 
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public static void sort(int []a, int left, int right){
        if(left<right){
            int i = left;
            int j = right;
            int temp = a[i];
            while(i<j){
                //找右边比temp小的值
                while(i<j && a[j] >= temp){
                    j--;
                }
                //找左边比temp大的值
                while(i<j && a[i] <= temp){
                    i++;
                }
                if(i<j){
                    int k = a[i];
                    a[i] = a[j];
                    a[j] = k;
                }
            }
            //交换初始值
            a[left] = a[i];
            a[i] = temp;
            //递归
            sort(a, left , i-1);
            sort(a, i+1, right);
        }
    }
}
