package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238_파티 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) - 1;

		int[][] map = new int[N][N];

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = Integer
					.parseInt(st.nextToken());

		}

		int[][] dijk = new int[N][2];

		for (int i = 0; i < N; i++) {
			if (i == X)
				continue;
			dijk[i][0] = Integer.MAX_VALUE;// go
			dijk[i][1] = Integer.MAX_VALUE;

		}

		PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return Integer.compare(o1%1000, o2%1000);
			}

			
		});

		q.add(X*1000);

		while (!q.isEmpty()) {
			int tmp = q.poll()/1000;
			
			
			for (int i = 0; i < N; i++) {
				if (map[i][tmp] > 0) {
					if (dijk[i][0] > dijk[tmp][0] + map[i][tmp]) {

						dijk[i][0] = dijk[tmp][0] + map[i][tmp];

						q.add(i*1000+map[i][tmp]);
					}
				}
			}
		}

		q.add(X*1000);

		while (!q.isEmpty()) {
			int tmp = q.poll()/1000;

			for (int i = 0; i < N; i++) {
				if (map[tmp][i] > 0) {
					if (dijk[i][1] > dijk[tmp][1] + map[tmp][i]) {

						dijk[i][1] = dijk[tmp][1] + map[tmp][i];

						q.add(i*1000+map[tmp][i]);
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
		/*
		 * for (int d[] : dijk) { System.out.println(d[0] + " " + d[1]); }
		 */
		// System.out.println(ans);
		System.out.println(dijk[ans][0] + dijk[ans][1]);

	}
}
