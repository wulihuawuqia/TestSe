/**
 * 版权所有: 中国电信爱WiFi运营中心
 * 创建日期: 2018/4/20
 * 创建作者：wuqia
 * 文件名称：QuickSortTwo.java
 * 版本: 1.0
 * 修改记录:
 */
package acm;

import java.util.Arrays;

/**
 * Description: 快排训练.
 * @author wuqia
 * @since 2018/4/20
 */
public class QuickSortTwo {
    public static void main(String[] args) {
        int []a = {1,6,20,8,9,10,15,2};
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
        Integer aa = 1;
        Integer bb = 2;
        swap(aa,bb);
        System.out.println(aa+"-"+bb);
    }

    public static void sort(int arr [], int left, int right) {
        /*判断是否需要排序*/
        if (left >= right){
            return;
        }
        /*初始化参数*/
        int i = left;
        int j = right;
        /*数组第一个作为中轴*/
        int temp = arr[left];

        while(i < j){
            /*找右边比中轴小的*/
            while(i < j && arr[j] >= temp) {
                j--;
            }
            /*找左边比中轴大的值*/
            while(i < j && arr[i] <= temp) {
                i++;
            }
            /*交换值*/
            if(i < j) {
                arr[i] = arr[i]^arr[j];
                arr[j] = arr[i]^arr[j];
                arr[i] = arr[i]^arr[j];
            }
        }
        /*重新初始化*/
        arr[left] = arr[i];
        arr[i] = temp;

        /*再次递归*/
        sort(arr, left, i-1);
        sort(arr, i+1, right);

    }

    //

    public static void swap(Integer a, Integer b) {
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a+"-"+b);
    }
}
