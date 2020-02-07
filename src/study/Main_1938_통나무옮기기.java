package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//7:10
public class Main_1938_통나무옮기기 {
	static int[][] dx = { { 0, 0, 0 }, { 0, 0, 0 }, { 1, 1, 1 }, { -1, -1, -1 }, { 1, 0, -1 } };
	static int[][] dy = { { 1, 1, 1 }, { -1, -1, -1 }, { 0, 0, 0 }, { 0, 0, 0 }, { 1, 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N][N];
		String s;
		int[] start = new int[3];
		int si = 0;
		int ei = 0;
		int[] end = new int[3];
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			for (int j = 0; j < N; j++) {
				char tmp = s.charAt(j);
				if (tmp == 'B') {
					start[si++] = i * 100 + j;

				} else if (tmp == 'E') {
					end[ei++] = i * 100 + j;
				} else if (tmp == '1') {
					map[i][j] = -1;
				}
			}
		}

		Queue<int[]> q = new LinkedList<int[]>();

		q.add(start);
		int[] nloc = new int[3];
		int tx, ty, nx, ny;
		int val = 0;
		while (!q.isEmpty()) {
			int[] loc = q.poll();
			for (int d = 0; d < 4; d++) {
				for (int i = 0; i < 3; i++) {
					tx = loc[i];
					ty = tx % 100;
					tx = tx / 100;

					nx = tx + dx[d][i];
					ny = ty + dy[d][i];

					if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0) {
						nloc[i] = nx * 100 + ny;
					} else {
						nloc[0] = -1;
					}
				}
				if (nloc[0] != -1) {
					for (int i = 0; i < 3; i++) {
						nx = nloc[i];
						ny = nx % 100;
						nx = ny / 100;

						map[nx][ny] = val + 1;
					}
				}
				if (loc[2] - loc[0] > 100) {
					for (int i = -1; i < 2; i++) {
						if (loc[0] / 100 + i<0) {
							
						}
						for (int j = 0; j < 3; j++) {
							if (map[loc[0] / 100 + i][loc[0] % 100 + j] == -1) {
								val = -1;
								break;
							}
						}

					}
				}else {
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							if (map[loc[0] / 100 + i][loc[0] % 100 + j] == -1) {
								val = -1;
								break;
							}
						}
						
					}
					
				}
				if (val > -1) {
					for (int i = 0; i < 3; i++) {
						tx = loc[i];
						ty = tx % 100;
						tx = tx / 100;

						nx = tx + dx[4][i];
						ny = ty + dy[4][i];
						
						map[nx][ny] = val+1;
						
						nloc[i] = nx*100+ny;
						
						
					}
					q.add(nloc);
				}
			}
		}

	}

}
