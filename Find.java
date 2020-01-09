package jianzhioffer;

import java.util.Scanner;

public class Find {
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int[][] array = new int[5][5];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = in.nextInt();
			}
		}
		System.out.print(Find2(5,array));
	}
	public static boolean Find(int target,int[][] array) {//暴力法搜索
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if(array[i][j]==target){
					return true;
				}
			}
		}
		return false;
	}
	public static boolean Find2(int target,int[][] array) {//从左下开始往上搜
		/*for (int i = array.length-1; i >=0; i--) {
			for (int j = 0; j < array[i].length; j++) {
				if (target==array[i][j]) {
					return true;
				}else if(target<array[i][j]){
					break;
				}
			}
		}
		return false;*/
		
		int i = array.length-1;
		int j = 0;
		while (i >= 0 && j < array[i].length) {
			if (target==array[i][j]) {
				return true;
			}else if (target<array[i][j]) {
				i--;
			}else if (target>array[i][j]) {
				j++;
			}
		}
		return false;
	}
}
