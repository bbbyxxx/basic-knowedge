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
	        //����һ��Map�������ڷ�װ�����ֶ�Ӧ��Ӣ����ĸ
	        Map<String, String> map = new HashMap<String, String>();
	        map.put("2", "abc");
	        map.put("3", "def");
	        map.put("4", "ghi");
	        map.put("5", "jkl");
	        map.put("6", "mno");
	        map.put("7", "pqrs");
	        map.put("8", "tuv");
	        map.put("9", "wxyz");
	        //ͨ������������ַ���digits���ҵ���Ӧ��Ӣ����ĸ�������
	        for (int i = 0; i < digits.length(); i++) {
				String ch = digits.charAt(i)+"";//�õ�ÿһλ�Ķ�Ӧ���ַ�����
				strings[i] = map.get(ch);//�õ�key��Ӧ��valueֵ �����ַ�������
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
		if (flag<s.length-1) {//������е��ַ���û������,����������Ȼ����ݼ���������һ����
			for (int i = 0; i < s[flag].length(); i++) {
				list = getListString(s, flag+1, list, tt+s[flag].charAt(i));
			}
		}else{//�����ˣ���һ����װһ�·���list������
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
