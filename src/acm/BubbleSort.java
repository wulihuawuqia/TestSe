package acm;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author 伍恰
 * 2018年3月2日 上午9:07:18
 */
public class BubbleSort {
    
    /**
     * 入口方法
     * @param args 异常/参数
     * @author 伍恰  
     * @date 2018年3月2日 上午9:20:43
     */
    public static void main(String[] args) {
        int[] a = {30, 7, 1, 6, 20, 8, 9, 10, 15, 2};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 
     * @param arr 异常/参数
     * @author 伍恰  
     * @date 2018年3月2日 上午9:21:11
     */
    private static void sort(int[] arr) {
        int len = arr.length;
        //遍历
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                //交换顺序
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
