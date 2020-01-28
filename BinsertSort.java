package sort;

import java.util.Arrays;
import java.util.Scanner;

//折半插入排序
public class BinsertSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        System.out.print("请输入数组长度：");
        int length = in.nextInt();
        System.out.print("请输入数组元素：");
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = in.nextInt();
        }
        binsertSort(nums);
        System.out.println(Arrays.toString(nums));
	}
	
	public static void binsertSort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			int t = nums[i];
			int low = 0,high = i;
			while (low<=high) {
				int mid = (low+high)/2;
				if (t<nums[mid]) {
					high = mid - 1;
				}else{
					low = mid + 1;
				}
			}
			int j;
			for (j = i-1; j >= high+1; j--) {
				nums[j+1] = nums[j];
			}
			nums[j+1] = t;
		}
	}
}
