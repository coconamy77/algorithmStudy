package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chicken_1765 {
	
	static int count = 0;
	void getNum() {
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] s = new int[n][n];

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			char r = String.valueOf(st.nextToken()).charAt(0);

			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());

			s[s1 - 1][s2 - 1] = r == 'E' ? -1 : 1;
			s[s2 - 1][s1 - 1] = s[s1 - 1][s2 - 1];
		}

		for (int[] a : s) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (s[k][i] == s[k][j] && s[k][i] != 0) {
						s[i][j] = 1;
						s[j][i] = 1;
					}
				}
			}
		}
		for (int[] a : s) {
			System.out.println(Arrays.toString(a));
		}

	}

}
