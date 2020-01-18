package practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*
 * ��һ��ջ������������
 * 	һ��ջ������ȡ����
 * 	����ͨ������������������������������ų�ջ
 * 		���ջΪ�գ���˵��ȫ��ƥ��
 * 		���ջ���գ�����ջ���Ѿ����˶��ַ���û�գ���ƥ��
 */
public class leetcode20 {
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		String string = in.nextLine();
		System.out.println(isValid(string));
	}
	
	public static boolean isValid(String s) {
		Deque<Character> arrayDeque = new ArrayDeque<Character>();//����һ��ջ
		if (s.length()==1&&"".equals(s)) {//�ǿ��ַ�����true
			return true;
		}else if (s.length()==1&&!"".equals(s)) {
			return false;
		}
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);//�õ�ÿһ���ַ�
			//�Եõ���ÿһ���ַ������жϣ��Ƿ��������Ż��߿��ַ�
			if (c=='('||c=='{'||c=='[') {//��ջ
				arrayDeque.addFirst(c);
			}else if(arrayDeque.size()!=0){//�������ţ�ֱ�ӳ�ջ
				Character judge = arrayDeque.pop();
				//���������Ҳ�պ�ƥ��,����ѭ�������򣬷���ʧ��.
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
