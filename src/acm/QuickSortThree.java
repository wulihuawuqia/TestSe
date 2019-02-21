/**
 * 版权所有: wulihua
 * 创建日期: 2019/1/21
 * 创建作者：wuqia
 * 文件名称：QuickSortThree.java
 * 版本: 1.0
 * 修改记录:
 */
package acm;

import java.util.Arrays;

/**
 * Description: 快速排序.
 * @author wuqia
 * @since 2019/1/21
 */
public class QuickSortThree {
    public static void main(String[] args) {
        int []a = {30,1,6,20,8,9,10,15,2};
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int [] arr, int left, int right) {
        if(left < right) {
            int i = left;
            int j = right;
            int temp = arr[i];
            while (i < j) {
                /** 如果右边的值比中间值小则切换位置*/
                while (i < j && arr[j] >= temp) {
                    j -- ;
                }
                /** */
                while (i < j && arr[i] <= temp) {
                    i ++ ;
                }
                if(i<j){
                    int k = arr[i];
                    arr[i] = arr[j];
                    arr[j] = k;
                }
            }
            //交换初始值
            arr[left] = arr[i];
            arr[i] = temp;
            /** 切换位置 递归*/
            sort(arr, left, i - 1);
            sort(arr, i + 1, right);
        }
    }
}
