package sw;

import java.util.Arrays;

public class BacktrackingPermutation {
	public static int[] d= {1,3,5};
	public static int N,cnt;
	
	
	public static int candidates(int[] a , int k, int[] c) {
		boolean[] perm = new boolean[a.length];
		for (int i = 0; i < k; i++)	perm[a[i]] = true;
		int ncands = 0;
		for (int i = 0; i < perm.length; i++) {
			if(!perm[i])	c[ncands++] = i;
		}
		return ncands;
	}
	
	public static void backtrack(int[] a, int k) {
		for(int i = 0; i<k ; i++) System.out.print("\t");
		System.out.println(Arrays.toString(a) + " k = " +k);
		int[] c = new int[N];
		if(k == N) {
			cnt++;
//			System.out.print(Arrays.toString(a) + " ");
			for (int i = 0; i < N; i++) {
				System.out.print(d[a[i]] + " ");
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
