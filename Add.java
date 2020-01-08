package jianzhioffer;
/**
 * 两个二进制的相加结果是用一个异或门实现的；
	两个二进制的进位结果是用一个与门来实现的。
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
			result = a^b;//相加结果，不带进位
			jinwei = (a&b)<<1;//进位
			a = result;
			b = jinwei;
		}while(jinwei!=0);
		return result;
	}
}
