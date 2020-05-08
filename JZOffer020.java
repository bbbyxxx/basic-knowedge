package practice;

import java.lang.*;
import java.util.*;

public class JZOffer020 {
	public static void main(String[] args) {
		System.out.println(isNumber("5."));
	}
	
	public static boolean isNumber(String s) {
        if(s.equals(" ")){
            return false;
        }
        int cnt = 0;
        char[] charTemp = {'+','-','e','.',' '};
        List<Character> chars = new ArrayList<>();
        for(int m = 0;m < 5;m++){
            chars.add(charTemp[m]);
        }
        char[] flag = {'0','1','2','3','4','5','6','7','8','9'};
        List<Character> list = new ArrayList<>();
        for(int m = 0;m < 10;m++){
            list.add(flag[m]);
        }
        List<Character> tt = new ArrayList<>();
        for(int i = 0;i < s.length();i++){
            char temp = s.charAt(i);
            if(list.contains(temp)){
                continue;
            }else{
                if(tt.contains(temp) || !chars.contains(temp)){
                    return false;
                }else{
                    if((i == s.length() - 1 && s.charAt(i) != ' ' && s.charAt(i) != '.') || s.charAt(0) == 'e'){
                        return false;
                    }
                    tt.add(temp);
                    cnt++;
                }
            }
            if(cnt > 1){
                return false;
            }
        }
        return true;
    }
}

