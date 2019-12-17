package algo_B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_4007_간담회참석 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken()) - 1;

			int[][] map = new int[N][N];

			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = Integer
						.parseInt(st.nextToken());

			}
fdjdkl;
			int[][] dijk = new int[N][2];

			for (int i = 0; i < N; i++) {
				if (i==X) continue;
				dijk[i][0] = Integer.MAX_VALUE;// go
				dijk[i][1] = Integer.MAX_VALUE;

			}

			Queue<Integer> q = new LinkedList();

			q.add(X);

			while (!q.isEmpty()) {
				int tmp = q.poll();

				for (int i = 0; i < N; i++) {
					if (map[i][tmp] > 0) {
						if ( dijk[i][0] > dijk[tmp][0] + map[i][tmp]) {

							dijk[i][0] = dijk[tmp][0] + map[i][tmp];

							q.add(i);
						}
					}
				}
			}

			q.add(X);

			while (!q.isEmpty()) {
				int tmp = q.poll();

				for (int i = 0; i < N; i++) {
					if (map[tmp][i] > 0) {
						if (dijk[i][1] > dijk[tmp][1] + map[tmp][i]) {

							dijk[i][1] = dijk[tmp][1] + map[tmp][i];

							q.add(i);
						}
					}
				}
			}

			int ans = 0;

			for (int i = 0; i < N; i++) {
				if (i == X) {
					if (i == 0) {
						ans = 1;
						i++;
					}
					continue;
				}

				if (dijk[ans][0] + dijk[ans][1] < dijk[i][0] + dijk[i][1]) {
					ans = i;
				}
			}
			System.out.println("#" + t + " " + (dijk[ans][0] + dijk[ans][1]));
		}
	}
}
