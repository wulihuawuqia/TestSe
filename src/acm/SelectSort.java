/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2018年3月2日 上午9:37:52
* 创建作者：伍恰
* 文件名称：SelectSort.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package acm;

import java.util.Arrays;

/**
 * 直接选择排序
 * @author 伍恰
 * 2018年3月2日 上午9:38:29
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] a = {30, 7, 1, 6, 20, 8, 9, 10, 15, 2};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
    
    /**
     * 
     * @param arr 异常/参数
     * @author 伍恰  
     * @date 2018年3月2日 上午9:38:26
     */
    public static void sort(int [] arr) {
        int len = arr.length;
        //遍历
        for (int i = 0; i < len-1; i++) {
            //选出余下的最小的
            int min = i;
            int minValue = arr[i];
            for (int j = i; j < len; j++) {
                if (arr[j] <= minValue) {
                    min = j;
                    minValue = arr[j];
                }
            }
            //交换值
            if (i != min) {
                arr[min] = arr[i];
                arr[i] = minValue;
            }
        }
    }
}
