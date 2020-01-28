package practice;

import java.util.Scanner;

public class LeetCode33 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("���������鳤��:");
		int n = in.nextInt();
		System.out.print("����������Ԫ��:");
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		System.out.print("��������Ҫ���ҵ�Ԫ��:");
		int key = in.nextInt();
		System.out.println(search(nums, key));
	}
	
	public static int search(int[] nums, int target) {
		int flag = nums.length-1;
		for (int i = 0; i < nums.length-1; i++) {//��ȡ��ѭ����
			if (nums[i]>nums[i+1]) {
				flag = i;
				break;
			}
		}
		if (flag == nums.length-1) {//˵�������������õ����飬ֱ�Ӷ��ֲ���
			return binarySearch(nums, 0, nums.length-1, target);
		}else{//˵��������ת�ˣ�������Ҫ�ж���targetֵλ���ĸ����䣬Ȼ����ж��ֲ���
			if (target<nums[flag]&&target<nums[0]) {//С�ڱ߽�ֵ��˵��������һ����������,��[flag+1,nums.length-1]
				return binarySearch(nums, flag+1, nums.length-1, target);
			}else{//˵���ڱ����䣬��[0,flag]
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
