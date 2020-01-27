package sort;

import java.util.Arrays;
import java.util.Scanner;

//��������
public class QuickSort {
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("���������鳤��:");
		int n = in.nextInt();
		int[] list = new int[n];
		System.out.print("����������Ԫ��:");
		for (int i = 0; i < list.length; i++) {
			list[i] = in.nextInt();
		}
		quickSort(list, 0, n-1);
		System.out.println(Arrays.toString(list));
	}
	
	public static void quickSort(int[] list,int p,int q) {
		if (p>=q) {
			return;
		}
		//��ȡ�������±�
		int index = getPivot(list,p,q);
		quickSort(list, p, index-1);
		quickSort(list, index+1, q);
	}
	
	public static int getPivot(int[] list,int p,int q) {
		int flag = list[q];//�����±�Ϊp�ĵ�Ϊ�ָ��㣬��ʣ��Ԫ�ؽ��зָ�������ں�С����ǰ
		int i = p;
		for (int j = p; j < q; j++) {
			if (list[j]<flag) {//����i��j�±��Ӧ��ֵ
				int temp = list[i];
				list[i] = list[j];
				list[j] = temp;
				i++;
			}
		}
		//�����±�Ϊq���±�Ϊi��Ԫ��,�����ָ��õ����������
		int temp = list[i];
		list[i] = list[q];
		list[q] = temp;
		return i;
	}
}
