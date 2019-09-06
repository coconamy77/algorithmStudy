package ssafy;

import java.util.Arrays;

public class BacktrackingPowerSet {
	public static int[] d= {1,3,5};
	public static int N,cnt;
	
	
	public static int candidates(int[] a , int k, int[] c) {
		c[0] = 1;
		c[1] = 0;
		return 2;
	}
	
	public static void backtrack(int[] a, int k) {
		for(int i = 0; i<k ; i++) System.out.print("\t");
		System.out.println(Arrays.toString(a) + " k = " +k);
		int[] c = new int[N];
		if(k == N) {
			cnt++;
//			System.out.print(Arrays.toString(a) + " ");
			for (int i = 0; i < N; i++) {
				if(a[i] ==1) System.out.print(d[i] + " ");
			}
			System.out.println();
		}else {
			int ncands =  candidates(a,k,c);
			for (int i = 0; i < ncands; i++) {
				a[k] = c[i];
				backtrack(a, k+1);
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		int[] a = new int[d.length];
		N = a.length;
		backtrack(a,0);
		System.out.println(cnt);
	}
}
