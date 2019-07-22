package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution13빌딩_서울8반_정하정 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/Solution13빌딩.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		int N = 0;

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			char[][] area = new char[N][N];
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int ni = 0; ni < N; ni++) {
					area[n][ni] = st.nextToken().charAt(0);
				}
			}
			int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
			int[] dy = { 1, 1, 1, 0, -1, -1, -1, 0 };
			int max = 0;
			for (int i = 0; i < area.length; i++) {
				con: for (int j = 0; j < area.length; j++) {
					if (area[i][j] == 'B') {
						for (int x = 0; x < dx.length; x++) {

							if (i + dx[x] < 0 || i + dx[x] >= area.length || j + dy[x] < 0
									|| j + dy[x] >= area.length) {

							} else {
								if (area[i + dx[x]][j + dy[x]] != 'B') {
									max = max < 2 ? 2 : max;
									continue con;
								}
							}
						}
						int count = -1;
						for (int b = 0; b < area.length; b++) {

							if (area[i][b] == 'B')
								count++;
							if (area[b][j] == 'B')
								count++;

						}
						max = max < count ? count : max;
					}

				}
			}

			System.out.println("#" + t + " " + max);
		}

	}
}
