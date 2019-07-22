package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution21소금쟁이중첩_서울8반_정하정 {
	
/*	3
	9 5
	6 2 2
	1 5 1
	0 0 2
	1 0 1
	2 4 2
	11 6
	0 0 2
	1 0 1
	2 4 2
	6 2 2
	1 5 1
	8 3 2
	7 5
	6 2 2
	1 6 1
	0 0 2
	1 0 1
	2 4 2*/
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution21소금쟁이중첩.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		int[] dx = { 1, 0 };
		int[] dy = { 0, 1 };

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int x = 0;
			int y = 0;
			int jump = 0;
			int[][] ws = new int[N][N];
			boolean check = false;
			for (int n = 1; n <= W; n++) {
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
						if (ws[nx][ny] != 0) {
							check = true;
							System.out.println("#" + t + " " + n);
							break;
						} else {
							ws[nx][ny]++;
						}
					} else {
						break;
					}
					
				}
				

			}
			if (!check) System.out.println("#" + t + " " + 0);
		}

	}
}
