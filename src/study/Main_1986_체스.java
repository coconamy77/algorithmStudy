package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1986_체스 {
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int[][] map;
	static int N, M;

	static void goQ(int i, int j, int d) {
		i = i + dx[d];
		j = j + dy[d];

		if (i > 0 && j > 0 &&i <= N && j <= M) {
			if (map[i][j] <= 0) {
				map[i][j] = -1;
				goQ(i, j, d);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N= Integer.parseInt(st.nextToken());
		M  = Integer.parseInt(st.nextToken());
		

		map = new int[N + 1][M + 1];

		int x, y;

		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());

				map[x][y] = i;
			}
		}
		
		int[] kx = { -2, -2, 2, 2,-1,-1,1,1 };
		int[] ky = { -1, 1, -1, 1,-2,2,2,-2 };

		for (int n = 1; n <= N; n++) {
			for (int m = 1; m <= M; m++) {
				if (map[n][m] > 0) {
					switch (map[n][m]) {
					case 1:
						for (int d = 0; d < 8; d++) {
							goQ(n, m, d);
						}
						break;
					case 2:
						for (int d = 0; d < 8; d++) {
							x = n + kx[d];
							y = m + ky[d];
							if (x > 0 && y > 0 && x <= N && y <= M && map[x][y]==0) {
								map[x][y] = -1;
							}
						}
						break;
					}
				}
			}
		}

		int ans = 0;

		for (int i = 1; i <= N; i++) {
			
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 0) {
					ans++;
				}
			}
		}
		System.out.println(ans);

	}

}
