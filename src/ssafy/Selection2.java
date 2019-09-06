package ssafy;

import java.util.Arrays;

public class Selection2 {
	
	public static int n =5;
	public static int[] a = {64,25,10,22,11};
	
	public static int minidx(int i, int j) {
		if(i == j) return i;
		int min = minidx(i+1, j);
		return a[i]< a[min]? i: min;
	}
	
	public static void selection(int index) {
		if(index == n ) return;
		int k = minidx(index,n-1);
		
		if(index != k ) {
			int T  = a[index] ; a[index] = a[k]; a[k] = T;
			System.out.println(Arrays.toString(a));
		}
		selection(index+1);
	}
	 
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(a));
		System.out.println();
		
		selection(0);
		System.out.println();
		
//		for (int i = 0; i < a.length-1; i++) {
//			int min = i;
//			for (int j = i+1; j < a.length; j++) {
//				if(a[j] < a[min]) min =j;
//			}
//			int temp = a[i];
//			a[i] = a[min];
//			a[min] = temp;
//			System.out.println(Arrays.toString(a));
//		}
//		
	}

}
