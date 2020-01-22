package sort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("请输入数组大小:");
		int n = in.nextInt();
		int[] list = new int[n];
		System.out.print("请输入数组元素:");
		for (int i = 0; i < n; i++) {
			list[i] = in.nextInt();
		}
		insertionSort(list);
		System.out.println(Arrays.toString(list));
	}
	
	public static void insertionSort(int[] list) {//进行插入排序
		for (int i = 1; i < list.length; i++) {
			int j = i-1;
			int temp = list[i];
			for (; j >= 0&&temp<list[j]; list[j+1]=list[j],j--);
			list[j+1] = temp;
		}
	}
}
