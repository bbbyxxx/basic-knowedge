package sort;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//基数排序
public class RadixSort {
	public static void main(String[] args) {
		int max = Integer.MIN_VALUE;
		Scanner in = new Scanner(System.in);
		System.out.print("请输入数组长度:");
		int n = in.nextInt();
		System.out.print("请输入数组元素:");
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		for (int j = 0; j < nums.length; j++) {
			if (nums[j]>max) {
				max = nums[j];
			}
		}
		int cnt = 0;
		while (max!=0) {//计算最大值是多少位
			cnt++;
			max /= 10;
		}
		radixSort(nums,cnt);
		System.out.println(Arrays.toString(nums));
	}
	
	public static void radixSort(int[] n,int num) {
		ArrayList<Integer>[] list = new ArrayList[10];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int pos = 0; pos < num; pos++) {
			for (int i = 0; i < list.length; i++) {
				list[i].clear();
			}
			for (int i = 0; i < n.length; i++) {
				int key = key(n[i],pos);//第几个数，第几位
				list[key].add(n[i]);
			}
			int index = 0;
			for (int i = 0; i < list.length; i++) {
				if (list[i]!=null) {
					for (int j = 0; j < list[i].size(); j++) {
						n[index++] = list[i].get(j);
					}
				}
			}
		}
	}
	
	public static int key(int n,int pos) {
		while(pos-- != 0){
			n /= 10;
		}
		return n%10;
	}
}
