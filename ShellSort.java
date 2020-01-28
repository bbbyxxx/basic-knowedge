package sort;

import java.util.Arrays;
import java.util.Scanner;

public class ShellSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        System.out.print("���������鳤�ȣ�");
        int length = in.nextInt();
        System.out.print("����������Ԫ�أ�");
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = in.nextInt();
        }
        shellSort(nums);
        System.out.println(Arrays.toString(nums));
	}
	
	public static void shellSort(int[] nums) {
		int step = nums.length/2;//������������
		for (int i = step; i > 0; i /= 2) {//�����±�Ϊͬһ���������ݣ�ÿһ����С����
			/*for (int j = i; j < nums.length; j++) {//��������
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
