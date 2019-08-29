package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_구슬찾기_2617 {

	static boolean[][] coin;
	static boolean[] vst;
	static int[] nl;

	static void dfs(int i, int j) {
		int tmp = nl[j];
		if (tmp == 0)
			return;
		for (int k = 0; k < coin.length; k++) {
			if (coin[j][k] && !vst[k]) {
				coin[i][k] = true;
				vst[k] = true;
				dfs(j, k);
				tmp--;
			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		coin = new boolean[N][N];
		nl = new int[N];

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken()) - 1;
			coin[h][Integer.parseInt(st.nextToken()) - 1] = true;
			nl[h]++;
		}

		/*
		 * for (boolean[]a : coin) { System.out.println(Arrays.toString(a)); }
		 */

		for (int i = 0; i < N; i++) {
			vst = new boolean[N];
			vst[i] = true;
			for (int j = 0; j < N; j++) {
				if (coin[i][j]) {
					dfs(i, j);
				}
			}
		}

		int count = 0;
		for (int j = 0; j < N; j++) {
			int nh = 0;
			for (int i = 0; i < N; i++) {
				if (coin[i][j]) {
					nh++;
				}
				if (nh >= N / 2 + 1) {
					count++;
					break;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			int nh = 0;
			for (int j = 0; j < N; j++) {
				if (coin[i][j]) {
					nh++;
				}
				if (nh >= N / 2 + 1) {
					count++;
					break;
				}
			}
		}
		System.out.println(count);

	}
}
/*
 *
 * 5 4 2 1 4 3 5 1 4 2
 * 
 * 
 * 7 6 1 2 4 5 5 2 6 3 3 4 7 1
 * 
 */