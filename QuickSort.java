package sort;

import java.util.Arrays;
import java.util.Scanner;

//快速排序
public class QuickSort {
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("请输入数组长度:");
		int n = in.nextInt();
		int[] list = new int[n];
		System.out.print("请输入数组元素:");
		for (int i = 0; i < list.length; i++) {
			list[i] = in.nextInt();
		}
		quickSort(list, 0, n-1);
		System.out.println(Arrays.toString(list));
	}
	
	public static void quickSort(int[] list,int p,int q) {
		if (p>=q) {
			return;
		}
		//获取分区点下标
		int index = getPivot(list,p,q);
		quickSort(list, p, index-1);
		quickSort(list, index+1, q);
	}
	
	public static int getPivot(int[] list,int p,int q) {
		int flag = list[q];//设置下标为p的点为分隔点，对剩余元素进行分隔，大的在后，小的在前
		int i = p;
		for (int j = p; j < q; j++) {
			if (list[j]<flag) {//交换i和j下标对应的值
				int temp = list[i];
				list[i] = list[j];
				list[j] = temp;
				i++;
			}
		}
		//交换下标为q和下标为i的元素,即将分隔好的数组整理好
		int temp = list[i];
		list[i] = list[q];
		list[q] = temp;
		return i;
	}
}
