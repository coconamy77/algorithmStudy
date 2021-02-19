package programmers;

public class Solution_등굣길 {
	static int[][] dp;
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };
	static int M, N;

	public int dp(int x, int y) {
		if (x == M - 1 && y == N - 1) {
			return 1;
		}

		int count = 0;
		for (int d = 0; d < 2; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= 0 && ny >= 0 && nx < M && ny < N && dp[nx][ny] > -1) {
				if (dp[nx][ny] == 0) {
					count += dp(nx, ny);
				} else {
					count += dp[nx][ny];
				}
			}
		}
		count %= 1000000007;
		dp[x][y] = count;
		return count;
	}

	public int solution(int m, int n, int[][] puddles) {
		M = m;
		N = n;

		dp = new int[M][N];

		for (int[] mn : puddles) {
			dp[mn[0] - 1][mn[1] - 1] = -1;
		}

		return dp(0, 0);
	}
}
