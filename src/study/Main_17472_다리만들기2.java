package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17472_다리만들기2 {
	static int[][] map;
	static List<Integer> bri;
	static int[] island;
	static int num;
	static int N, M;
	static int[][] graph;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static void makeIs(int x, int y, int idx) {
		map[x][y] = -idx;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 1) {
				makeIs(nx, ny, idx);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		bri = new ArrayList<Integer>();
		island = new int[8];
		num = 1;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					makeIs(i, j, num++);
				}
			}
		}

		graph = new int[num][num];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					int idx = map[i][j];
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						int distance = 0;
						while (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] != idx) {
							if (map[nx][ny]==0) {
								distance++;
							}
							else {
								if (distance>1) {
									graph[-idx][-map[nx][ny]] = 
											graph[-idx][-map[nx][ny]]>distance?graph[-idx][-map[nx][ny]]:distance;
								}
								break;
							}
							nx = nx+ dx[d];
							ny = ny+ dy[d];
						}

					}
				}
			}
		}
		
		for (int[] a: map) {
			System.out.println(Arrays.toString(a));
		}
		
		System.out.println();
		for (int[] a: graph) {
			System.out.println(Arrays.toString(a));
		}

	}
}
