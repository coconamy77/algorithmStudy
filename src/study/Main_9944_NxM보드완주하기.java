package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9944_NxM보드완주하기 {
	static char[][] map;
	static int N, M;
	static int ans;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static void go(int i, int j, int d, int v) {
		if (v >= ans) {
			return;
		}
		int nx, ny;
		nx = i + dx[d];
		ny = j + dy[d];
		if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == '.') {
			map[nx][ny] = '1';
			go(nx, ny, d, v);
			map[nx][ny] = '.';
			return;
		}

		v = v + 1;
		boolean c = false;
		for (int nd = 0; nd < 4; nd++) {
			nx = i + dx[nd];
			ny = j + dy[nd];
			if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == '.') {
				c = true;
				map[nx][ny] = '1';
				go(nx, ny, nd, v);
				map[nx][ny] = '.';
			}
		}
		if (!c) {
			if (check()) {
				ans = v > ans ? ans : v;
			}
		}
	}

	static boolean check() {

//		System.out.println();
//
//		for (int i = 0; i < N; i++) {
//			System.out.println(map[i]);
//		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '.') {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 1;
		while (true) {
			String input = br.readLine();
			if (input==null) {
				break;
			}
			st = new StringTokenizer(input);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new char[N][M];

			ans = N * M + 1;
			int count = 0;

			for (int n = 0; n < N; n++) {
				map[n] = br.readLine().toCharArray();
				for (int m = 0; m < M; m++) {
					if (map[n][m] == '.') {
						count++;
					}
				}
			}
			if (count == 1) {
				ans = 0;
			} else {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (map[i][j] == '.') {
							map[i][j] = '1';
							for (int d = 0; d < 4; d++) {
								go(i, j, d, 1);
							}

							map[i][j] = '.';
						}
					}
				}
				if (ans == N * M + 1)
					ans = 0;
				ans--;
			}
			System.out.println("Case " + (T++) + ": " + ans);
			
		}

	}
}
