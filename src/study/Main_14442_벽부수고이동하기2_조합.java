package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14442_벽부수고이동하기2_조합 {

	static int[][] map;
	static int N, M, K, min;
	static List<int[]> w;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int go() {
		int a = 0;

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { 0, 0 });

		boolean[][] vst = new boolean[N][M];
		
		boolean finish = false;

		while (!q.isEmpty() && !finish) {
			int size = q.size();
			while (size>0 && !finish) {
				size--;
				int[] tmp = q.poll();
				if (tmp[0]==N-1 && tmp[1]==M-1) {
					finish = true;
					break;
				}

				for (int d = 0; d < 4; d++) {
					int nx = tmp[0] + dx[d];
					int ny = tmp[1] + dy[d];

					if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0 && !vst[nx][ny]) {
						q.add(new int[] {nx,ny});
						vst[nx][ny] = true;
					}
					
				}

			}
			a++;
            if (a>=min) break;
		}
		if (!finish) a = -1;
		return a;
	}

	static void get(int dep, int s, int[] sel) {
		if (dep == K) {
			int t = go();
			//System.out.println("t"+t);
			if (t!=-1) min = min>t?t:min;
		} else {
			for (int i = s; i < w.size(); i++) {
				int x = w.get(i)[0];
				int y = w.get(i)[1];
				map[x][y] = 0;
				get(dep + 1, i + 1, sel);
				map[x][y] = 1;
			}

		}

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
				if (s.charAt(m) == '1') {
					w.add(new int[] { n, m });
					map[n][m] = 1;
				}
			}
		}

		get(0, 0, new int[w.size()]);
		if (min==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
}
