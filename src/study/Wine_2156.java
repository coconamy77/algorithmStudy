package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Wine_2156 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int max = 0;
		int[][] w = new int[n + 1][3];
		int l = Integer.parseInt(br.readLine());
		w[1][0] = l;
		w[1][1] = l;
		w[1][2] = l;
		max = l;
		if (n >= 2) {
			l = Integer.parseInt(br.readLine());
			w[2][0] = l;
			w[2][1] = w[1][0] + l;
			w[2][2] = w[2][1];
			max = max > w[2][2] ? max : w[2][2];
		}

		for (int i = 3; i <= n; i++) {
			l = Integer.parseInt(br.readLine());
			w[i][0] = w[i - 3][2] > w[i - 2][2] ? w[i - 3][2] + l : w[i - 2][2] + l;
			w[i][1] = w[i - 1][0] + l;
			// w[i][2] = w[i-1][1]+l;
			w[i][2] = w[i][0] > w[i][1] ? w[i][0] : w[i][1];

			max = max > w[i][2] ? max : w[i][2];
		}
		System.out.println(max);

	}
}
