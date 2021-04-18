package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20058_마법사상어와파이어스톰 {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] map,cMap;

	public static void move(int n, int x, int y) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cMap[i][j] = map[i+x][j+y];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[j+x][(n-1)-i+y] = cMap[i][j];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int len = (int) Math.pow(2, N);
		map = new int[len][len];
		int[] fs = new int[Q];

		for (int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < len; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int q = 0; q < Q; q++) {
			fs[q] = Integer.parseInt(st.nextToken());
		}

		cMap = new int[len][len];
		for (int s : fs) {
			int n = (int) Math.pow(2, s);
			for (int i = 0; i < len; i = i + n) {
				for (int j = 0; j < len; j = j + n) {
					move(n, i, j);
				}
			}

			for(int i = 0; i<len; i++) {				
				cMap[i] = map[i].clone();
			}
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					if (cMap[i][j] == 0) {
						continue;
					}
					int num = 0;
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (nx >= 0 && ny >= 0 && nx < len && ny < len) {
							if (cMap[nx][ny] > 0) {
								num++;
							}
						}
					}
					if (num < 3) {
						map[i][j]--;
					}
				}
			}
		}
		
		int max = 0;
		int sum = 0, count = 0;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (map[i][j] > 0) {
					sum += map[i][j];
					count = 1;
					map[i][j] = 0;
					q.add(new int[] { i, j });

					while (!q.isEmpty()) {
						int[] xy = q.poll();
						for (int d = 0; d < 4; d++) {
							int nx = xy[0] + dx[d];
							int ny = xy[1] + dy[d];
							if (nx >= 0 && ny >= 0 && nx < len && ny < len) {
								if (map[nx][ny] > 0) {
									sum += map[nx][ny];
									count++;
									map[nx][ny] = 0;
									q.add(new int[] { nx, ny });
								}
							}
						}
					}
				}
				if (count > max) {
					max = count;
				}
			}
		}
		System.out.println(sum);
		System.out.println(max);
	}
}
