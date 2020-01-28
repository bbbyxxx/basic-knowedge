package practice;

import java.util.Scanner;

public class LeetCode33 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("请输入数组长度:");
		int n = in.nextInt();
		System.out.print("请输入数组元素:");
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		System.out.print("请输入你要查找的元素:");
		int key = in.nextInt();
		System.out.println(search(nums, key));
	}
	
	public static int search(int[] nums, int target) {
		int flag = nums.length-1;
		for (int i = 0; i < nums.length-1; i++) {//获取到循环点
			if (nums[i]>nums[i+1]) {
				flag = i;
				break;
			}
		}
		if (flag == nums.length-1) {//说明本身就是排序好的数组，直接二分查找
			return binarySearch(nums, 0, nums.length-1, target);
		}else{//说明经过旋转了，首先需要判断其target值位于哪个区间，然后进行二分查找
			if (target<nums[flag]&&target<nums[0]) {//小于边界值，说明在另外一个区间里面,即[flag+1,nums.length-1]
				return binarySearch(nums, flag+1, nums.length-1, target);
			}else{//说明在本区间，即[0,flag]
				return binarySearch(nums, 0, flag, target);
			}
		}
	}
	
	public static int binarySearch(int[] nums,int left,int right,int target) {
		int mid;
		while (left<=right) {
			mid = left + ((right-left)>>2);
			if (nums[mid] == target) {
				return mid;
			}else if(nums[mid] > target){
				right = mid -1;
			}else if (nums[mid] < target) {
				left = mid + 1;
			}
		}
		return -1;
	}
}
