package sort;

import java.util.Arrays;
import java.util.Scanner;

public class ShellSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        System.out.print("请输入数组长度：");
        int length = in.nextInt();
        System.out.print("请输入数组元素：");
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = in.nextInt();
        }
        shellSort(nums);
        System.out.println(Arrays.toString(nums));
	}
	
	public static void shellSort(int[] nums) {
		int step = nums.length/2;//步伐（增量）
		for (int i = step; i > 0; i /= 2) {//挑出下标为同一步伐的数据，每一次缩小增量
			/*for (int j = i; j < nums.length; j++) {//插入排序
				int t = nums[j];
				int k;
				for (k = j; k >= i&&nums[k-i] > t;nums[k]=nums[k-i],k -= i);
				nums[k] = t;	
			}*/
			for (int j = i; j < nums.length; j++) {
				int k = j-1;
				int temp = nums[j];
				for (; k >= 0&&temp<nums[k]; nums[k+1]=nums[k],k--);
				nums[k+1] = temp;
			}
		}
	}
}
