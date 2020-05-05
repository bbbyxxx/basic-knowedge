package practice;

import java.util.Scanner;

import jdk.nashorn.internal.ir.Flags;

public class JZOffer013 {
	private static int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int m = in.nextInt();
		int n = in.nextInt();
		int k = in.nextInt();
		int[][] flag = new int[m][n];
		int result = movingCount(0,0,m, n, k,flag);
		System.out.println(result);
	}
	
	public static int movingCount(int x,int y,int m, int n, int k,int[][] flag) {
		if (x < 0 || y < 0 || x >= m || y >= n || ((x%10 + x/10 + y%10 + y/10)) > k || flag[x][y] == 1){
			return 0;
		}
		flag[x][y] = 1;
		return 1+movingCount(x+ direction[0][0], y + direction[0][1], m, n, k,flag)
				+movingCount(x + direction[1][0], y + direction[1][1], m, n, k,flag)
				+movingCount(x + direction[2][0], y + direction[2][1], m, n, k,flag)
				+movingCount(x + direction[3][0], y + direction[3][1], m, n, k,flag);
	}
}
