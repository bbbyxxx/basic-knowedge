package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.String;

public class LeetCode17 {
	public static void main(String[] args) {
		System.out.println(letterCombinations("2"));
	}
	
	public static List<String> letterCombinations(String digits) {
			int flag = 0;
			String tt = "";
			String[] strings = new String[digits.length()];
	        List<String> list = new ArrayList<String>();
	        if("".equals(digits)){
				return list;
			}
	        //创建一个Map对象用于封装各数字对应的英文字母
	        Map<String, String> map = new HashMap<String, String>();
	        map.put("2", "abc");
	        map.put("3", "def");
	        map.put("4", "ghi");
	        map.put("5", "jkl");
	        map.put("6", "mno");
	        map.put("7", "pqrs");
	        map.put("8", "tuv");
	        map.put("9", "wxyz");
	        //通过遍历传入的字符串digits来找到对应的英文字母进行组合
	        for (int i = 0; i < digits.length(); i++) {
				String ch = digits.charAt(i)+"";//得到每一位的对应的字符数字
				strings[i] = map.get(ch);//得到key对应的value值 赋给字符串数组
			}
	        if (strings.length==1) {
	        	for (int i = 0; i < strings[0].length(); i++) {
	        		list.add(strings[0].charAt(i)+"");
				}
				return list;
			}
	        list = getListString(strings,flag,list,tt);
	        return list;
	}
	
	public static List<String> getListString(String[] s,int flag,List<String> list,String tt) {
		if (flag<s.length-1) {//如果所有的字符串没遍历完,往深搜索，然后回溯继续搜索下一个解
			for (int i = 0; i < s[flag].length(); i++) {
				list = getListString(s, flag+1, list, tt+s[flag].charAt(i));
			}
		}else{//到底了，则将一组解封装一下放入list集合中
			for (int i = 0; i < s[flag].length(); i++) {
				String tempString = tt;
				tt += s[flag].charAt(i);
				list.add(tt);
				tt = tempString;
			}
		}
		
		return list;
	}
}
