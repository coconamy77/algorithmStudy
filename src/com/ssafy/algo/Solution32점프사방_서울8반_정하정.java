package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution32점프사방_서울8반_정하정 {
/*	3
	6 6 2
	34 42 22 32 21 24
	22 32 21 33 33 33
	13 11 12 21 43 13
	34 23 22 24 32 11
	22 24 21 41 41 42
	31 42 34 32 15 32
	2 3 2
	2 6 6
	3 3 4 4 2 6 5
	2 2 3  
	11 21
	41 31
	1 1 2
	2 1 2
	1 2 1
	1 2 2
	5 6 2
	22 32 21 33 33 33
	13 11 12 21 43 13
	34 23 22 24 32 11
	22 24 21 41 41 42
	31 42 34 32 15 32
	5 4 2
	1 3 1
	2 3 4 4 2*/
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution32점프사방.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int t = 1; t <= T; t++) {
			int minI = 0;

			st = new StringTokenizer(br.readLine());

			int Y = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int price = -1000 * N;

			int[][] jump = new int[Y][X];
			//int[][] player = new int [N][3];
			
			int[][] player = new int[Y][X];

			for (int y = 0; y < Y; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < X; x++) {
					jump[y][x] = Integer.parseInt(st.nextToken());

				}
			}
			
			/*for (int i = 0; i<N; i++) {
				player[i][0] = sc.nextInt();
				player[i][1] = sc.nextInt();
				player[i][2] = sc.nextInt();
			}*/

			for (int p = 0; p < N; p++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken()) - 1;
				minI = minI > i ? i : minI;
				player[i][Integer.parseInt(st.nextToken()) - 1] = Integer.parseInt(st.nextToken());

			}
			st = new StringTokenizer(br.readLine());
			int trap = Integer.parseInt(st.nextToken());
			for (int i = 0; i < trap; i++) {
				jump[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 0;
			}

			for (int i = minI; i < jump.length; i++) {
				for (int j = 0; j < jump[0].length; j++) {
					if (player[i][j] != 0) {
						int time = player[i][j];
						int ny = i;
						int nx = j;
						for (int jt = 0; jt < time; jt++) {

							int vx = nx;
							int vy = ny;
							ny = vy + (dy[(jump[vy][vx] / 10) - 1] * (jump[vy][vx] % 10));

							nx = vx + (dx[(jump[vy][vx] / 10) - 1] * (jump[vy][vx] % 10));
							if (ny >= 0 && ny < jump.length && nx >= 0 && nx < jump.length) {
								if (jump[ny][nx] == 0) {
									break;
								} else if (jt == time - 1) {
									price += jump[ny][nx] * 100;
								}
							} else {
								break;
							}

						}
					}
				}
			}

			System.out.println("#" + t + " " + price);

		}
	}
}
