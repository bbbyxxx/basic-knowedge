package sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("请输入数组大小:");
		int n = in.nextInt();
		int[] list = new int[n];
		System.out.print("请输入数组元素:");
		for (int i = 0; i < n; i++) {
			list[i] = in.nextInt();
		}
		bubbleSort(list);
		System.out.println(Arrays.toString(list));
	}
	
	public static void bubbleSort(int[] list) {//实现冒泡排序
		for (int i = 0; i < list.length-1; i++) {
			for (int j = i+1; j < list.length; j++) {
				if (list[i]>list[j]) {
					int temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
	}
}
