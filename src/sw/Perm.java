
package sw;

import java.util.Arrays;
import java.util.Scanner;

//순열 nPr = n*(n-1)*...*(n-r)    ex) 5 P 3  = 5*4*3 = 60


public class Perm {
	public static int n, cnt;
	public static int[] d = { 1, 2, 3};
	public static int[] a;

	public static void swap(int i, int j) {
		if(i == j) return;
		int T = d[i]; d[i] = d[j]; d[j] =T;
		
	}
	public static void perm(int count) {
		if (count == n) {
			cnt++;
			System.out.println(Arrays.toString(d));
			return;
		}
		for (int i = count; i < n; i++) {
			swap(i, count);
			System.out.println("1");
			perm(count+1);
			swap(i,count);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = d.length;// sc.nextInt();

		perm(0);

		System.out.println(cnt);
		sc.close();
	}

}
