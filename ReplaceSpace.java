package jianzhioffer;

import java.util.Scanner;

/*
 * ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 */
public class ReplaceSpace {
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("We Are Happy");
		System.out.println(replaceSpace(str));
	}
	public static String replaceSpace(StringBuffer str) {
    	for (int i = 0; i < str.length(); i++) {
			if (' '==str.charAt(i)) {
				str.replace(i, i+1, "%20");
			}
		}
    	return str.toString();
    }
}
