package acm;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {1, 31, 6, 20, 8, 9, 10, 15, 2, 11};
        sort4(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] arr, int left, int right) {
        //判断是否需要排序
        if (left < right) {
            int i = left;//开始节点
            int j = right;
            //保存起点值
            int temp = arr[i];
            //开始循环
            while (i < j) {
                //先查找右边比起点值小的数
                while (i < j && arr[j] >= temp) {
                    j--;
                }
                //再查找左边比起点值大的数
                while (i < j && arr[i] <= temp) {
                    i++;
                }
                //如果右边值比左边小则交换顺序
                if (i < j && arr[j] <= arr[i]) {
                    int t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
            }
            //重新确认临界值
            arr[left] = arr[i];
            arr[i] = temp;
            //开始递归
            System.out.println(Arrays.toString(arr));
            sort(arr, left, i - 1);
            sort(arr, i + 1, right);
        }
    }

    public static void sort2(int arr[], int left, int right){
        if(left < right) {
            // 记录其实元素值
            // 开始节点
            int i = left;
            int j = right;
            int temp = arr[i];
            while (i < j) {
                // 找右边比起点值小的值, 如果比temp大 则j--
                while(i < j && temp <= arr[j]) {
                    j--;
                }
                // 找左边比起点大的值
                while(i < j && temp >= arr[i]) {
                    i++;
                }
                // 如果右边值比左边小则交换顺序
                if(i < j && arr[i] >= arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
            // 重新确认起始值
            arr[left] = arr[i];
            arr[i] = temp;
            // 开始递归
            sort2(arr, left, i-1);
            sort2(arr, i+1, right);
        }
    }

    public static final void sort3(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int temp = arr[left];

            while (i < j) {
                // 找右边比 temp 小的元素
                while (i < j && arr[j] >= temp) {
                    j --;
                }
                // 找左边比 temp 大的元素
                while (i < j && arr[i] <= temp) {
                    i ++;
                }
                if (i < j && arr[i] >= arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
            // 重新确认起始值
            System.out.println(Arrays.toString(arr));
            arr[left] = arr[i];
            arr[i] = temp;
            System.out.println(i);
            System.out.println(Arrays.toString(arr));
            // 递归开始
            sort3(arr, left, i - 1);
            sort3(arr, i+1, right);
        }
    }

    public static final void sort4(int [] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            /* 选出起始节点*/
            int temp = arr[left];
            /* 开始循环*/
            while (i < j){
                /* 因为起始节点是小的，所以先从右边开始找比起点小的值*/
                while (i < j && arr[j] >= temp) {
                    j--;
                }
                while (i < j && arr[i] <= temp) {
                    i ++;
                }
                /*交换位置*/
                if(i < j && arr[i] >= arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
            // 交换起始节点位置
            System.out.println(Arrays.toString(arr));
            arr[left] = arr[i];
            arr[i] = temp;
            System.out.println(i);
            System.out.println(Arrays.toString(arr));
            sort4(arr, left, i - 1);
            sort4(arr, i + 1, right);
        }
    }
}	
