
package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_3055_탈출_서울8반_정하정 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int tx = 0, ty = 0;

		char[][] map = new char[N][M];

		Queue<int[]> q = new LinkedList<>();

		for (int n = 0; n < N; n++) {
			String s = br.readLine();
			for (int m = 0; m < M; m++) {
				char t = s.charAt(m);
				if (t == 'S') {
					tx = n;
					ty = m;
				} else if (t == '*') {
					q.add(new int[] { 1, n, m });
				}
				map[n][m] = t;
			}
		}
		q.add(new int[] {2, tx, ty });

		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };

		boolean w = true;
		int c = 0;
		boolean finish = false;
		boolean dead = true;

		while (!q.isEmpty() && !finish) {
			int[] tmp = q.poll();
			int v = tmp[0];
			int x = tmp[1];
			int y = tmp[2];
			switch (v) {
			case 1:
				if (!w) {
					w = true;
					if (dead)
						break;
					else
						dead = true;
				}
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
						if (map[nx][ny] == '.' || map[nx][ny] == 'S') {
							map[nx][ny] = '*';
							q.add(new int[] { 1, nx, ny });
						}
					}

				}
				break;
			case 2:
				if (w) {
					c++;
					w = false;
				}
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
						if (map[nx][ny] == '.') {
							q.add(new int[] { 2, nx, ny });
							dead = false;
						} else if (map[nx][ny] == 'D') {
							dead = false;
							finish = true;
							break;
						}
					}

				}

				break;
			}
		}
		if (finish)
			System.out.println(c);
		else
			System.out.println("KAKTUS");

	}

}