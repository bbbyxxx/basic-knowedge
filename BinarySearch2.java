package search;

import java.util.Arrays;
import java.util.Scanner;
//二分查找变形
public class BinarySearch2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("请输入数组长度:");
		int n = in.nextInt();
		System.out.print("请输入数组元素:");
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		System.out.print("请输入要查找的元素:");
		int key = in.nextInt();
		Arrays.sort(nums);
		System.out.println(binarySearch(nums, key));
	}
	
	//变体一：查找第一个值等于给定值的元素
	/*public static int binarySearch(int[] nums,int key) {
		int left = 0;
		int right = nums.length-1;
		int mid;
		while(left<=right){
			mid = left+(right-left)/2;
			if (nums[mid] < key) {
				left = mid + 1;
			}else if (nums[mid] > key) {
				right = mid - 1;
			}else{
				if ((mid==0)||(nums[mid-1]!=key)) {
					return mid;
				}else{
					right = mid - 1;
				}
			}
		}
		return -1;
	}*/
	
	//变体二：查找最后一个值等于给定值的元素
	/*public static int binarySearch(int[] nums,int key) {
		int left = 0;
		int right = nums.length-1;
		int mid;
		while(left<=right){
			mid = left+(right-left)/2;
			if (nums[mid] < key) {
				left = mid + 1;
			}else if (nums[mid] > key) {
				right = mid - 1;
			}else{
				if ((mid==nums.length-1)||(nums[mid+1]!=key)) {
					return mid;
				}else{
					left = mid + 1;
				}
			}
		}
		return -1;
	}*/
	
	//变体三：查找第一个大于等于给定值的元素
	/*public static int binarySearch(int[] nums,int key) {
		int left = 0;
		int right = nums.length-1;
		int mid;
		while(left<=right){
			mid = left+(right-left)/2;
			if (nums[mid] >= key) {
				if ((mid==0)||(nums[mid-1]<key)) {
					return mid;
				}else{
					right = mid - 1;
				}
			}else{
				left = mid + 1;
			}
		}
		return -1;
	}*/
	
	//变体四：查找最后一个小于等于给定值的元素
	public static int binarySearch(int[] nums,int key) {
		int left = 0;
		int right = nums.length-1;
		int mid;
		while(left<=right){
			mid = left+(right-left)/2;
			if (nums[mid] <= key) {
				if ((mid==nums.length)||(nums[mid+1]>key)) {
					return mid;
				}else{
					left = mid + 1;
				}
			}else{
				right = mid - 1;			
				}
		}
		return -1;
	}
	
}
