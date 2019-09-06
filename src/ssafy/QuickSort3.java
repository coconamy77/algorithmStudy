package ssafy;

import java.util.Arrays;

public class QuickSort3 {
//	public static int[] a = {69, 10, 30, 2, 16, 8, 31, 22};
	public static int[] a = {69, 19, 40, 2, 16, 8, 31, 22};
	
	public static int lomuto(int begin, int end) { // 오른쪽 중심
		int x = a[end];
		int i = begin - 1;
		
		for(int j = begin; j <= end-1; j++) {
			if(a[j] <= x) {
				i++;
				int T = a[i]; a[i] = a[j]; a[j] = T;
			}
		}
		int T = a[i+1]; a[i+1] = a[end]; a[end] = T;
		return i+1;
	}
	
	public static void quick(int begin, int end) {
		if(begin < end) {
			int pivot = lomuto(begin, end);
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
