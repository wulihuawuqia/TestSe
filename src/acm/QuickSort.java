package acm;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int []a = {1,6,20,8,9,10,15,2}; 
		sort(a,0,a.length-1);
		System.out.println(Arrays.toString(a));
	}
	public static void sort(int []arr,int left,int right){
		//判断是否需要排序
		if(left<right){
			int i=left;//开始节点
			int j=right;
			//保存起点值
			int temp = arr[i];
			//开始循环
			while(i < j){
				//先查找右边比起点值小的数
				while (i<j && arr[j] >= temp){
					j--;
				}
				//再查找左边比起点值大的数
				while (i<j && arr[i] <= temp){
					i++;
				}
				//如果右边值比左边小则交换顺序
				if(i<j && arr[j] <= arr[i]){
					int t = arr[j];
					arr[j] = arr[i];
					arr[i] =t;
				}
			}
			//重新确认临界值
			arr[left]=arr[i];
			arr[i]=temp;
			//开始递归
			System.out.println(Arrays.toString(arr));
			sort(arr,left,i-1);
			sort(arr,i+1,right);
		}
	}
}	
