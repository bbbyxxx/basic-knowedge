package again;
import java.awt.print.Printable;
import java.util.*;
//ȫ����
public class QuanPaiLie {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n;
        System.out.print("���������鳤�ȣ�");
        n = in.nextInt();
        int[] nums = new int[n];
        System.out.print("����������Ԫ��:");
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        quanPaiLie(nums,0,n);//ȫ����
	}
	
	public static void quanPaiLie(int[] nums,int left,int right) {
		if (left == right) {
			print(nums);
			return;
		}else{
			for (int i = left; i < right; i++) {
				swap(nums,left,i);
				quanPaiLie(nums, left+1, right);
				swap(nums,i,left);
			}
		}
	}
	
	public static void swap(int[] nums,int left,int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
	
	public static void print(int[] nums) {
		System.out.println(Arrays.toString(nums));
	}
}
