package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_미세먼지안녕_17144 {

	static int[][] map;
	static int upx = 0;
	static int upy = 0;
	static int downx = 0;
	static int downy = 0;

	static void upMove() {
		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { -1, 0, 1, 0 };

		int x = upx;
		int y = upy;
		boolean finish = false;
		int d = 0;

		while (d<4) {
			int tmpx = x + dx[d];
			int tmpy = y + dy[d];
			if (tmpx >= 0 && tmpy >= 0 && tmpx <= upy && tmpy < map[0].length) {
				x = tmpx;
				y = tmpy;
				break;
			}
			d++;
		}

		while (!finish) {

			if (tmpx >= 0 && tmpy >= 0 && tmpx <= upy && tmpy < map[0].length) {

			}

			x = x + dx[d];
			y = y + dy[d];

			if (x >= 0 && y >= 0 && x <= upy && y < map[0].length) {
				if (x == upx && y == upy)
					break;
				else {

				}

			} else
				d++;

		}

	}

	static void downMove() {

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");

		int R = Integer.parseInt(st[0]);
		int C = Integer.parseInt(st[1]);
		int T = Integer.parseInt(st[1]);

		int[][] map = new int[R][C];

		Queue<int[]> q = new LinkedList<>();

		for (int r = 0; r < R; r++) {
			st = br.readLine().split(" ");
			for (int c = 0; c < C; c++) {
				int t = Integer.parseInt(st[c]);
				if (t == -1) {
					if (map[r - 1][c] == -1) {
						downx = r;
						downy = c;
					} else {
						upx = r;
						upy = c;
					}
				}
				map[r][c] = t;
			}
		}
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		for (int t = 0; t < T; t++) {
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (t > 0) {
						int[] tmp = { r, c, map[r][c] };
						q.add(tmp);
					}
				}
			}

			while (!q.isEmpty()) {
				int[] tmp = q.poll();
				int x = tmp[0];
				int y = tmp[1];
				int v = tmp[2];
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != -1) {
						map[nx][ny] += v / 5;
						map[x][y] -= v / 5;
					}

				}

			}

			upMove();
			downMove();

		}
		for (int[] a : map) {
			System.out.println(Arrays.toString(a));
		}

	}
}
