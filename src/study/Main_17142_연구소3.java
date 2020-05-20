package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17142_연구소3 {
	static int[][] map;
	static int N, M, virus, result;
	static int[] v = new int[10];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int getAns(int[] sel) {
		int answer = 0;
		int[][] ans = new int[N][N];
		Queue<Integer> q = new LinkedList<Integer>();

		int val, x, y, nx, ny;
		for (int i = 0; i < M; i++) {
			x = v[sel[i]];
			q.add(x);
			y = x % 100;
			x = x / 100;
			ans[x][y] = 1;
		}

		while (!q.isEmpty()) {
			x = q.poll();
			y = x % 100;
			x = x / 100;
			val = ans[x][y];
//			if (result > 0 && val > result) {
//				return -1;
//			}
			for (int d = 0; d < 4; d++) {
				nx = x + dx[d];
				ny = y + dy[d];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N && ans[nx][ny] == 0 && map[nx][ny] != 1) {
					ans[nx][ny] = val + 1;
					q.add(nx * 100 + ny);
				}
			}

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					if (ans[i][j] == 0) {
						return -1;
					}
					if (ans[i][j] > answer) {
						answer = ans[i][j];
					}
				}
			}
		}

		return answer;
	}

	static void select(int[] sel, int dep, int s) {

		if (dep == M) {
			//System.out.println(Arrays.toString(sel));
			int ans = getAns(sel);
			if (ans==-1)return;
			if (ans>0)ans-=1;
			if (result < 0 || ans < result) {
				result = ans;
				//System.out.println(result);
			}
			return;
		}
		for (int i = s; i < virus; i++) {
			sel[dep] = i;
			select(sel, dep + 1, i + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		result = -1;
		virus = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					v[virus++] = i * 100 + j;
				}
			}
		}

		// System.out.println(Arrays.toString(v)+" "+virus);
		select(new int[M], 0, 0);

		System.out.println(result);

	}
}
