package HW;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_5431_민석이의과제체크하기_서울8반_정하정 {

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/input_d3_5431.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int N = 0;
		int K = 0;

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();

			int[] a = new int[N];
			Arrays.fill(a, 0);
			for (int k = 0; k < K; k++) {
				a[sc.nextInt() - 1] = 1;
				System.out.println(Arrays.toString(a));
			}
			System.out.print("#" + t);

			for (int i = 0; i < N; i++) {
				if (a[i] == 0) {
					System.out.print(" " + (i + 1));
				}
				
			}
			System.out.println();
		}
	}
}