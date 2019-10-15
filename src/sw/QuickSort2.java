package sw;

import java.util.Arrays;

public class QuickSort2 {
//	public static int[] a = {69, 10, 30, 2, 16, 8, 31, 22};
	public static int[] a = {69, 19, 40, 2, 16, 8, 31, 22};
	
	public static int hoare(int begin, int end) { // hoare: 왼쪽을 기준으로 잡음
		int pivot = a[begin];
		int L = begin;
		int R = end;
		
		while(L < R) {
			while(a[L] <= pivot && L < end)	L++;
			while(a[R] >= pivot && begin < R) R--;
			
			if(L < R) {
				int tmp = a[R];
				a[R] = a[L];
				a[L] = tmp;
			}
		}
		
		int tmp = a[R];
		a[R] = a[begin];
		a[begin] = tmp;
		
		return R;
	}
	
	public static void quick(int begin, int end) {
		if(begin < end) {
			int pivot = hoare(begin, end);
			quick(begin, pivot-1);
			quick(pivot+1, end);
			
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(a));
		quick(0, a.length-1);
		System.out.println(Arrays.toString(a));
	}

}
