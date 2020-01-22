package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {

	static int map[][] = new int[502][502];
	static boolean vst[][] = new boolean[502][502];
	static int N, M, ans = 0;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static int nx, ny;

	static void fun(int c, int sum, int i, int j) {
		if (c == 4) {
			System.out.println(i + ", " + j + " = " + map[i][j] + " |");
			ans = ans > sum ? ans : sum;
			return;
		}
		for (int d = 0; d < 4; d++) {
			nx = i + dx[d];
			ny = j + dy[d];
			if (map[nx][ny] > 0 && !vst[nx][ny]) {
				vst[nx][ny] = true;
				fun(c + 1, sum + map[nx][ny], nx, ny);
				vst[nx][ny] = false;
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				vst[i][j] = true;
				fun(1, map[i][j], i, j);
				vst[i][j] = false;
			}
		}

		System.out.println(ans);
	}

}
