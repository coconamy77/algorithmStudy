package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2931_가스관 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int mx = 0, my = 0, zx = 0, zy = 0;

		char[][] map = new char[N][M];

		for (int n = 0; n < N; n++) {
			String s = br.readLine();
			for (int m = 0; m < M; m++) {
				char c = s.charAt(m);
				if (c == 'M') {
					mx = n;
					my = m;
				} else if (c == 'Z') {
					zx = n;
					zy = m;
				}
				map[n][m] = c;
			}
		}

		Queue<int[]> q = new LinkedList<int[]>();

		q.add(new int[] { mx, my });

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];

			if (x == zx && y == zy) {
				break;
			}

			int nx = 0, ny = 0;

			switch (map[x][y]) {
			case 'M':
				stop: for (int d = 0; d < 4; d++) {
					nx = x + dx[d];
					ny = y + dy[d];
					if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
						if (map[nx][ny] == '.') {
							q.add(new int[] { nx, ny, d });
						} else {
							switch (d) {
							case 0:
								if (map[nx][ny] == '-' || map[nx][ny] == '+' || map[nx][ny] == '3'
										|| map[nx][ny] == '4') {
									q.clear();
									q.add(new int[] { nx, ny, d });
									break stop;
								}
								break;
							case 1:
								if (map[nx][ny] == '|' || map[nx][ny] == '+' || map[nx][ny] == '3'
										|| map[nx][ny] == '2') {
									q.clear();
									q.add(new int[] { nx, ny, d });
									break stop;
								}
								break;
							case 2:
								if (map[nx][ny] == '-' || map[nx][ny] == '+' || map[nx][ny] == '1'
										|| map[nx][ny] == '2') {
									q.clear();
									q.add(new int[] { nx, ny, d });
									break stop;
								}
								break;
							case 3:
								if (map[nx][ny] == '|' || map[nx][ny] == '+' || map[nx][ny] == '3'
										|| map[nx][ny] == '2') {
									q.clear();
									q.add(new int[] { nx, ny, d });
									break stop;
								}
								break;
							}
						}
					}
				}
			break;
			case '-':
				int d = tmp[2];
				
			}

		}

	}
}
