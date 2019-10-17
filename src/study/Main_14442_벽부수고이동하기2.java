package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14442_벽부수고이동하기2 {

	static int[][] map;
	static int N, M, K, min;
	static List<int[]> w;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int go() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { 0, 0, 0, 1 });

		boolean[][][] vst = new boolean[K + 1][N][M];

		while (!q.isEmpty()) {

			int[] tmp = q.poll();
			int count = tmp[3];
			int wc = tmp[2];
			for (int d = 0; d < 4; d++) {
				int nx = tmp[0] + dx[d];
				int ny = tmp[1] + dy[d];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (nx == N - 1 && ny == M - 1) {
						return count;
					}
					if (count >= min-1) {
						continue;
					}
					if (map[nx][ny] == 0 && !vst[wc][nx][ny]) {
						q.add(new int[] { nx, ny, wc, count + 1 });
						vst[wc][nx][ny] = true;
					} else if (map[nx][ny] == 1 && wc+1<=K && !vst[wc + 1][nx][ny]) {
						wc++;
						q.add(new int[] { nx, ny, wc, count + 1 });
						vst[wc][nx][ny] = true;
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		w = new ArrayList<int[]>();
		map = new int[N][M];

		min = Integer.MAX_VALUE;

		for (int n = 0; n < N; n++) {
			String s = br.readLine();
			for (int m = 0; m < M; m++) {
				map[n][m] = s.charAt(m) - '0';
			}
		}
		int t = go();

		if (t != -1)
			min = min > t ? t : min;
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
}
