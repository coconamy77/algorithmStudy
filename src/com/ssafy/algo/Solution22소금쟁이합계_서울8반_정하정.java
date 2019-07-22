package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution22소금쟁이합계_서울8반_정하정 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution22소금쟁이합계.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int x = 0;
			int y = 0;
			int jump = 0;
			int count = 0;
			int[][] ws = new int[N][N];
			for (int n = 0; n < W; n++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				jump = Integer.parseInt(st.nextToken());
				int nx = x;
				int ny = y;
				for (int time = 3; time > 0; time--) {
					nx = nx + (time * dx[jump - 1]);
					ny = ny + (time * dy[jump - 1]);

					if (nx < ws.length && nx >= 0 && ny < ws.length && ny >= 0) {
						if (ws[nx][ny] == 3) {
							break;
						} else {
							if (time == 1)
								count++;
							ws[nx][ny] = 4 - time;
						}
					} else {
						break;
					}

				}

			}
			System.out.println("#" + t + " " + count);
		}

	}
}
