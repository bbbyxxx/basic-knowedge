package sort;

import java.awt.image.Kernel;
import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("请输入数组大小:");
		int n = in.nextInt();
		int[] list = new int[n];
		System.out.print("请输入数组元素:");
		for (int i = 0; i < n; i++) {
			list[i] = in.nextInt();
		}
		selectionSort(list);
		System.out.println(Arrays.toString(list));
	}
	
	public static void selectionSort(int[] list) {//实现选择排序
		for (int i = 0; i < list.length-1; i++) {
			int k = i;
			for (int j = i+1; j < list.length; j++) {
				if (list[k]>list[j]) {
					k = j;
				}
			}
			int temp = list[i];
			list[i] = list[k];
			list[k] = temp;
		}
	}
}
