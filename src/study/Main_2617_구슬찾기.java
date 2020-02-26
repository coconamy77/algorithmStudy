package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2617_구슬찾기 {

	static int[][] map;
	static int N, M;
	static int[][] dp;

	static int getSmall(int i) {
		if (dp[i][0] > 0) {
			return dp[i][0];
		}
		int cnt = 1;
		for (int j = 1; j <= N; j++) {
			if (map[i][j] == 1) {
				cnt++;
				cnt += getSmall(j);
			}

		}
		dp[i][0] = cnt;
		return cnt;
	}

	static int getBig(int i) {
		if (dp[i][1] > 0) {
			return dp[i][1];
		}
		int cnt = 1;
		for (int j = 1; j <= N; j++) {

			if (map[j][i] == 1) {
				cnt++;
				cnt += getBig(j);
			}

		}
		dp[i][1] = cnt;
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		dp = new int[N + 1][2];

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}

		int mid = (N + 1) / 2;
		int ans = 0;

		for (int i = 1; i <= N; i++) {
			if (getSmall(i)>mid) ans++;
			if (getBig(i)>mid) ans++;
			// 0은 나보다 가벼운 것 찾기, 1은 무거운 것 찾기
		}
		System.out.println(ans);

	}

}
