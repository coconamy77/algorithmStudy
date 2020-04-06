package study;

import java.io.*;
import java.util.*;

public class Solution_8382_방향전환 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int T, x1, x2, y1, y2;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());

			x1 = Integer.parseInt(st.nextToken()) + 100;
			y1 = Integer.parseInt(st.nextToken()) + 100;
			x2 = Integer.parseInt(st.nextToken()) + 100;
			y2 = Integer.parseInt(st.nextToken()) + 100;

			int[][][] vst = new int[201][201][2];

			vst[x1][y1][0] = 1;
			vst[x1][y1][1] = 1;

			Queue<int[]> q = new LinkedList<int[]>();

			// System.out.println(x1+" "+y1+" "+x2+" "+y2);
			int nx = x1, ny = y1;
			int[] que = new int[3];
			int ans = 0;
			if (x1 != x2 || y1 != y2) {
				for (int d = 0; d < 4; d++) {

					nx = x1 + dx[d];
					ny = y1 + dy[d];
					if (nx >= 0 && nx <= 200 && ny >= 0 && ny <= 200) {
						if (nx == x2 && ny == y2) {
							ans = 1;
							break;
						}
						vst[nx][ny][d % 2] = 1;
						q.add(new int[] { nx, ny, d });
					}
				}
			}

			// System.out.println(q.size());
			int v = 0;
			while (!q.isEmpty() && (ans == 0)) {
				que = q.poll();
				v = vst[que[0]][que[1]][que[2] % 2];
				// System.out.println("새로 나온 큐"+que[0]+" "+que[1]);
				for (int d = 0; d < 4; d++) {
					if (d % 2 == que[2] % 2) {
						// System.out.println(d);
						continue;
					}
					nx = que[0] + dx[d];
					ny = que[1] + dy[d];

					if (nx == x2 && ny == y2) {
						ans = v + 1;
						break;
					}
					if (nx >= 0 && nx <= 200 && ny >= 0 && ny <= 200 && vst[nx][ny][d % 2] == 0) {

						// System.out.println(que[3]+" "+ nx+" "+ ny+" "+d);

						q.add(new int[] { nx, ny, d });
						vst[nx][ny][d % 2] = v + 1;
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}