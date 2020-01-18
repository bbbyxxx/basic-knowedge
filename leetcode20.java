package practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*
 * 用一个栈来解决这道问题
 * 	一个栈用来存取括号
 * 	另外通过：如果遍历出有括号则立马将左括号出栈
 * 		如果栈为空，则说明全部匹配
 * 		如果栈不空，或者栈中已经空了而字符串没空，则不匹配
 */
public class leetcode20 {
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		String string = in.nextLine();
		System.out.println(isValid(string));
	}
	
	public static boolean isValid(String s) {
		Deque<Character> arrayDeque = new ArrayDeque<Character>();//声明一个栈
		if (s.length()==1&&"".equals(s)) {//是空字符返回true
			return true;
		}else if (s.length()==1&&!"".equals(s)) {
			return false;
		}
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);//得到每一个字符
			//对得到的每一个字符进行判断，是否是左括号或者空字符
			if (c=='('||c=='{'||c=='[') {//入栈
				arrayDeque.addFirst(c);
			}else if(arrayDeque.size()!=0){//是右括号，直接出栈
				Character judge = arrayDeque.pop();
				//如果有括号也刚好匹配,继续循环；否则，返回失败.
				if ((judge.equals('(')&&c==')')||(judge.equals('[')&&c==']')||(judge.equals('{')&&c=='}')) {
						continue;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}
		if (arrayDeque.size()!=0) {
			return false;
		}
		return true;
	}
}
