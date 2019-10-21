package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_11559_PuyoPuyo {

	static char[][] game;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static void down() {
		for (int j = 0; j < 6; j++) {
			int c = 0;
			for (int i = 11; i >= 0; i--) {
				if (game[i][j]=='.') {
					c++;
				}else {
					if (c>0) {
						for (int x = i+c;x>=c; x--) {
							game[x][j] = game[x-c][j];
						}
						for(int x = c-1; x>=0; x--) {
							game[x][j] = '.';
						}
						i = i+c;
						c=0;
					}
				}
				
			}
		}
	}

	static boolean puyo(int x, int y) {
		boolean[][] vst = new boolean[12][6];
		int c = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(x * 100 + y);
		vst[x][y] = true;

		while (!q.isEmpty()) {
			int ox = q.poll();
			int oy = ox % 100;
			ox = ox / 100;
			for (int d = 0; d < 4; d++) {
				int nx = ox + dx[d];
				int ny = oy + dy[d];

				if (nx >= 0 && ny >= 0 && nx < 12 && ny < 6 && !vst[nx][ny] && game[nx][ny] == game[x][y]) {
					q.add(nx * 100 + ny);
					vst[nx][ny] = true;
					c++;
				}

			}

		}

		if (c >= 4) {
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (vst[i][j]) {
						game[i][j] = '.';
					}
				}
			}
			return true;

		}

		return false;
	}

	static boolean find() {
		int found = 0;

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (game[i][j] != '.') {
					if (puyo(i, j))
						found++;
				}
			}
		}
		if (found > 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		game = new char[12][6];

		for (int i = 0; i < 12; i++) {
			game[i] = br.readLine().toCharArray();
		}

		int ans = 0;
		while (true) {
			if (find()) {
				ans++;
				down();
			} else {
				break;
			}
		}

		System.out.println(ans);

	}
}
