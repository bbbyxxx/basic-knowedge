package sort;

import java.util.Arrays;
import java.util.Scanner;
//�鲢����
public class MergeSort {
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("���������鳤��:");
		int n = in.nextInt();
		System.out.print("����������Ԫ��:");
		int[] list = new int[n];
		for (int i = 0; i < list.length; i++) {
			list[i] = in.nextInt();
		}
		mergeSort(list,0,n);
		System.out.println(Arrays.toString(list));
	}
	
	public static void mergeSort(int[] list,int p,int q) {
			if (q-p == 1) {//ʣһ��Ԫ�� �����ٷ�
				return ;
			}else{
				int center = (p + q) / 2;
				mergeSort(list, p, center);//ǰ�벿��  ���֣�
				mergeSort(list, center, q);//��벿�� ���֣�
				mergeSortFighting(list,p,center,q);//(��)
			}
	}
	
	public static void mergeSortFighting(int[] list,int p,int center,int q) {//�ϲ�
		int[] temp = new int[q-p];
		int i = p,j = center,k = 0;
		while (i<center&&j<q) {//��������������ݺϲ�
				if (list[i]<list[j]) {
					temp[k++] = list[i++];
				}else {
					temp[k++] = list[j++];
				}
		}
		//�ж��ĸ������黹������
		while(i<center) {//˵��ǰ�벿�ֻ�������
			temp[k++] = list[i++];
		}
		
		while (j<q) {//˵����벿�ֻ�������
			temp[k++] = list[j++];
		}
		
		//�ϲ���󣬽�ԭ�������ݸ���
		for (int l = 0,m = p; m < q; m++) {
			list[m] = temp[l++];
		}
	}
}
