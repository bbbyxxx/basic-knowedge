package jianzhioffer;
/**
 * ���������Ƶ���ӽ������һ�������ʵ�ֵģ�
	���������ƵĽ�λ�������һ��������ʵ�ֵġ�
 * @author xuan
 *
 */
public class Add {
	public static void main(String[] args) {
		System.out.print(addTwoNum(10, 9));
	}
	
	public static int addTwoNum(int a,int b){
		int result = 0;
		int jinwei = 0;
		do{
			result = a^b;//��ӽ����������λ
			jinwei = (a&b)<<1;//��λ
			a = result;
			b = jinwei;
		}while(jinwei!=0);
		return result;
	}
}
