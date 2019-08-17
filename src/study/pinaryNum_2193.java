package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pinaryNum_2193 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[][] ans = new long[n + 1][2];

		if (n >= 1) {
			ans[1][0] = 0;
			ans[1][1] = 1;
		}
		for (int i = 2; i <= n; i++) {

			ans[i][0] = ans[i - 1][0] + ans[i - 1][1];
			ans[i][1] = ans[i - 1][0];
		}
		System.out.println(ans[n][0] + ans[n][1]);
	}
}
