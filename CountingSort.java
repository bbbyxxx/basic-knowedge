package sort;

import java.util.Arrays;
import java.util.Scanner;

//��������
public class CountingSort {
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
        System.out.print("���������鳤�ȣ�");
        int n = in.nextInt();
        System.out.print("����������Ԫ�أ�");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        countingSort(nums);
        System.out.println(Arrays.toString(nums));
	}
	
	  public static void countingSort(int[] nums){
		  //�ҳ�nums�е����ֵ�����ڴ�����������
		  int max = Integer.MIN_VALUE;
		  for (int i = 0; i < nums.length; i++) {
			if (max<nums[i]) {
				max = nums[i];
			}
		  }
		  int[] counts = new int[max+1];
		  for (int i = 0; i < nums.length; i++) {
			counts[nums[i]]++;
		  }
		  
		  for (int i = 0,k = 0; i < max+1; i++) {
			while (counts[i] != 0) {
				nums[k++] = i;
				counts[i]--;
			}
		  }
	  }
}
