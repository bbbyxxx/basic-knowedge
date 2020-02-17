package sort;

import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("请输入数组长度:");
		int n = in.nextInt();
		System.out.print("请输入数组元素:");
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = in.nextInt();
		}
		for (int i = 0; i < nums.length; i++) {
			buildHeap(nums,nums.length-i);
			swap(nums, 0,nums.length-1-i);
		}
		System.out.println(Arrays.toString(nums));
	}
	
	//i是当前父节点
	public static void heapify(int[] nums,int i,int size) {
		if (i < size) {
			int leftChild = i*2 + 1;
			int rightChild = i*2 + 2;
			
			int max = i;
			if (leftChild < size) {
				if (nums[max] < nums[leftChild]) {
					max = leftChild;
				}
			}
		
		
			if (rightChild < size) {
				if (nums[max] < nums[rightChild]) {
					max = rightChild;
				}
			}
			
			if (max != i) {
				swap(nums, i, max);	
				heapify(nums, max, size);
			}
		}
	}
	
	public static void buildHeap(int[] nums,int size) {
		for (int i = size-1; i >= 0; i--) {
			heapify(nums, i, size);
		}
	}
	
	public static void swap(int[] nums,int i,int size) {
		int t = nums[i];
		nums[i] = nums[size];
		nums[size] = t;
	}

}
