package ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class PowerSet {
	public static int n, cnt;
	public static int[] d = { 1, 2, 3, 4 };
	public static int[] b;
	
	public static void powerset(int count) {
		if (count == n) {
			cnt++;
			for (int i = 0; i < n; i++) {
				if(b[i] == 1) System.out.print(d[i]+ " ");
				else System.out.print("0" + " ");
			}
			System.out.println(Arrays.toString(b));
		
			return;
		}
		
		b[count] = 0;
		powerset(count + 1);
		b[count] = 1;
		powerset(count + 1);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = d.length;// sc.nextInt();
		b = new int[n];
		powerset(0);

		System.out.println(cnt);
		sc.close();
	}

}
