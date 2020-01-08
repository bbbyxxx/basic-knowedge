package jianzhioffer;

public class Solution {
	public static void main(String[] args) {
		System.out.print(Sum_Solution(5));
	}
	
	/*public static int Sum_Solution(int n) {
        if(n == 1){
            return 1;
        }else{
        	return n+Sum_Solution(n-1);
        }
	}*/
	
	public static int Sum_Solution(int n) {
        int result = (int) ((Math.pow(n, 2)+n)/2);
        return result;
	}
}
