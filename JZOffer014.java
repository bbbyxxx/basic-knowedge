package practice;

import java.util.Scanner;

public class JZOffer014 {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		System.out.println(cuttingRope(n));
	}
	public static int cuttingRope(int n) {
        int[] nums = new int[n+1];
        nums[1] = 1;
        nums[2] = 1;

        for(int i = 3;i < n+1;i++){//枚举绳子长度
            for(int j = 2;j < i;j++){//分割绳子
                nums[i] = Math.max(nums[i],Math.max(j*(i-j),nums[i-j]*j));
            }
        }
        return nums[n];
    }
}
