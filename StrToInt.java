package jianzhioffer;

import java.util.Scanner;

public class StrToInt {
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("ÇëÊäÈë×Ö·û´®£º");
		String number = in.next();
		System.out.print(parseToInt(number));
	}
	
	public static int parseToInt(String number){
		if("".equals(number)||number == null){
			return 0;
		}
		char flag = number.charAt(0);
		if(flag=='+'||flag=='-'){
			number = number.substring(1);
		}
		int cnt = 0;
		long compare = 0;
		if(judge(number)){
			return 0;
		}else{
			for(int i = 0;i<number.length();i++){
				compare = compare*10+number.charAt(i)-'0';
				cnt = cnt*10+number.charAt(i)-'0';
				if(compare>Integer.MAX_VALUE&&flag!='-'){
					return 0;
				}else if(-compare<Integer.MIN_VALUE&&flag=='-'){
					return 0;
				}
			}
		}
		return '-'==flag?-cnt:cnt;
	}
	
	public static boolean judge(String number){
		for (int i = 0; i < number.length(); i++) {
			if(number.charAt(i)>=48&&number.charAt(i)<=57){
				continue;
			}else{
				return true;
			}
		}
		return false;
	}
}
