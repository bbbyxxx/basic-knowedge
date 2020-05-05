package practice;

import java.util.Arrays;
import java.util.Scanner;

import com.sun.org.apache.regexp.internal.recompile;

import sun.management.snmp.util.MibLogger;


public class JZOffer012 {
	private static Scanner in = new Scanner(System.in);
	private static int m = 0;
	private static int n = 0;
	private static int[][] flag = null;
	private static int[][] direction = {{0,0},{1,0},{0,1},{-1,0},{0,-1}};
	private static String ttString = null;
	private static String tString = null;
	public static void main(String[] args) {
		int row = in.nextInt();
		int col = in.nextInt();
		m = row;
		n = col;
		char[][] nums = new char[row][col];
		flag = new int[m][n];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				nums[i][j] = in.next().toCharArray()[0];
			}
		}
		String word = in.next();
		ttString = word;
		System.out.println(exist(nums, word));
	}
	
	public static boolean exist(char[][] board, String word) {
        if (board == null || board[0] == null || board.length == 0 || board[0].length == 0 || word == null || word.equals("")) {
            return false;
        }
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        char[] chs = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chs[0]) {
                    if (bfs(board, i, j, isVisited, chs, 0)) return true;
                }
            }
        }
        return false;
    }

    private static boolean bfs(char[][] board, int i, int j, boolean[][] isVisited, char[] chs, int index) {

        if (index == chs.length) {
            return true;
        }
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || isVisited[i][j] || board[i][j] != chs[index]) {
            return false;
        }
        isVisited[i][j] = true;
        boolean res = bfs(board, i + 1, j, isVisited, chs, index + 1)
                || bfs(board, i - 1, j, isVisited, chs, index + 1)
                || bfs(board, i, j + 1, isVisited, chs, index + 1)
                || bfs(board, i, j - 1, isVisited, chs, index + 1);
        isVisited[i][j] = false;
        return res;
    }
	
	/*public static boolean miGongLike(int i,int j,char[][] board,int index) {
		boolean u = false;
		if(index == ttString.length()){
			return true;
		}else {
			for (int k = 0; k < 5; k++) {
				int x = i + direction[k][0];
				int y = j + direction[k][1];
				if (x >= 0 && y>=0 && x < m && y < n && index < ttString.length() && board[x][y] == ttString.charAt(index) && flag[x][y] == 0) {//ÄÜÌ¤
					flag[x][y] = 1;//±ê¼Ç
					//tString += board[x][y]+"";
					u = miGongLike(x, y, board,index+1);
					flag[x][y] = 0;
					//tString = tString.substring(0,tString.length()-1);
				}
			}
		}
		return u;
	}
	
	public static boolean exists(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
			 if (board[i][j] == word.charAt(0)) {
				if (miGongLike(i,j,board,0)) {
					return true;
				}
			}
			}
		}
		return false;
	}*/
}
