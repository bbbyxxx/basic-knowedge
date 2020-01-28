package search;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//�򵥶��ֲ���
public class BinarySearch {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("���������鳤��:");
		int n = in.nextInt();
		System.out.print("����������Ԫ��:");
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		System.out.print("������Ҫ���ҵ�Ԫ��:");
		int key = in.nextInt();
		Arrays.sort(nums);
		System.out.println(binarySearch(nums, key,0,n-1));
	}
	
	/*public static int binarySearch(int[] nums,int key) {
		int left = 0;
		int right = nums.length-1;
		int mid;
		while(left<=right){
			mid = left+(right-left)/2;
			if (nums[mid] == key) {
				return mid;
			}else if (nums[mid] < key) {
				left = mid + 1;
			}else if (nums[mid] > key) {
				right = mid - 1;
			}
		}
	 return -1;
	}*/
	
	public static int binarySearch(int[] nums,int key,int left,int right) {
		if (left > right) {
			return -1;
		}
		int mid = left+((right-left)>>1);
		
		if (nums[mid] == key) {
			return mid;
		}else if (nums[mid] < key) {
			return binarySearch(nums, key, mid+1, right);
		}else if (nums[mid] > key) {
			return binarySearch(nums, key, left, mid-1);
		}
		return mid;
	}
}
