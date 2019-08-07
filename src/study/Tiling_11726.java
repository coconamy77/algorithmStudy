package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tiling_11726 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		/*
		 * int[] fin = new int[n + 1];
		 * 
		 * fin[0] = 0; fin[1] = 1; fin[2] = 2; for (int i = 3; i <= n; i++) { fin[i] =
		 * (fin[i - 1] + fin[i - 2])%10007;
		 * 
		 * } System.out.println(fin[n]);
		 */

		int past = 0;
		int cur = 1;
		int next = 0;
		for (int i = 0; i < n; i++) {
			next = (cur + past) % 10007;
			past = cur;
			cur = next;
		}
		System.out.println(next);
	}
}
