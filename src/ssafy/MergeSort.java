package ssafy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
	public static int[] a = { 69, 10, 30, 2, 16, 8, 31, 22 };
	public static int[] s;

	private static void merge(int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int k = left;
		while (i <= mid && j <= right) {
			if (a[i] <= a[j])
				s[k++] = a[i++];
			else
				s[k++] = a[j++];
		}
		if (i > mid)
			for (int l = j; l <= right; l++)
				s[k++] = a[l];
		else
			for (int l = i; l <= mid; l++)
				s[k++] = a[l];

		for (int l = left; l <= right; l++)
			a[l] = s[l];

	}

	private static void mergesort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergesort(left, mid);
			mergesort(mid + 1, right);
			merge(left, mid, right);
			System.out.println(Arrays.toString(a));
		}
	}
	
	  public static void main(String[] args) {
	  
	  System.out.println(Arrays.toString(a));
	  
	  List<Integer> list = new ArrayList<>();
	  
	  System.out.println(); s = new int[a.length]; mergesort(0, a.length-1);
	  System.out.println(); System.out.println(Arrays.toString(a));
	  
	  }
	 
}



