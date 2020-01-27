package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BucketSort {
	int bucketSize = 10;
	int arraySize = 100;
	
	public static void main(String[] args) {
		BucketSort bSort = new BucketSort();
		int[] array = bSort.getArray();
		bSort.bucketSort(array);
	}
	
	public int[] getArray(){
		int[] arr = new int[arraySize];
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(10000);
		}
		return arr;
	}
	
	public void bucketSort(int[] a) {
		List<Integer>[] bucketList = new ArrayList[bucketSize];
		for (int i = 0; i < a.length; i++) {
			int temp = a[i]/1000;
			if (bucketList[temp] == null) {
				bucketList[temp] = new ArrayList<Integer>();
			}
			bucketList[temp].add(a[i]);
		}
		for (int j = 0; j < bucketSize; j++) {
			Collections.sort(bucketList[j]);
			System.out.println(bucketList[j]);
		}
	}
}
