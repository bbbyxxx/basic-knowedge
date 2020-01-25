package sort;

import java.util.Arrays;
import java.util.Scanner;
//归并排序
public class MergeSort {
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("请输入数组长度:");
		int n = in.nextInt();
		System.out.print("请输入数组元素:");
		int[] list = new int[n];
		for (int i = 0; i < list.length; i++) {
			list[i] = in.nextInt();
		}
		mergeSort(list,0,n);
		System.out.println(Arrays.toString(list));
	}
	
	public static void mergeSort(int[] list,int p,int q) {
			if (q-p == 1) {//剩一个元素 不用再分
				return ;
			}else{
				int center = (p + q) / 2;
				mergeSort(list, p, center);//前半部分  （分）
				mergeSort(list, center, q);//后半部分 （分）
				mergeSortFighting(list,p,center,q);//(合)
			}
	}
	
	public static void mergeSortFighting(int[] list,int p,int center,int q) {//合并
		int[] temp = new int[q-p];
		int i = p,j = center,k = 0;
		while (i<center&&j<q) {//将给定区间的数据合并
				if (list[i]<list[j]) {
					temp[k++] = list[i++];
				}else {
					temp[k++] = list[j++];
				}
		}
		//判断哪个子数组还有数据
		while(i<center) {//说明前半部分还有数据
			temp[k++] = list[i++];
		}
		
		while (j<q) {//说明后半部分还有数据
			temp[k++] = list[j++];
		}
		
		//合并完后，将原数组数据更改
		for (int l = 0,m = p; m < q; m++) {
			list[m] = temp[l++];
		}
	}
}
