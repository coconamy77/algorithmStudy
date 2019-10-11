package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17472_다리만들기2 {
	static int[][] map;
	static List<int[]> bri;
	static int[] island;
	static int num;
	static int N, M;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	
	static int findSet(int x) {
		if (island[x]==0) {
			island[x] = x;
		}else {
			island[x] = island[island[x]];
		}
		return island[x];
	}
	
	static boolean union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		
		if (x==y) {
			return false;
		}
		
		if (x>y) {
			island[island[x]] = y;
		}else {
			island[island[y]] = x;
		}
		return true;
	}

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
		bri = new ArrayList<int[]>();
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
									bri.add(new int[] {-idx,-map[nx][ny],distance});
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
		
		Collections.sort(bri,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});

		
		int sum = 0;
		for (int i = 0; i<bri.size(); i++) {
			if (union(bri.get(i)[0], bri.get(i)[1])) {
				sum+=bri.get(i)[2];
			}
		}
		
		System.out.println(Arrays.toString(island));
		for (int i = 1; i<num; i++) {
			if (findSet(i)!=findSet(i+1)) {
				System.out.println(i+", "+ (i+1));
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(sum);
		
		
		
		
		/*
		
		
		
		for (int[] a: map) {
			System.out.println(Arrays.toString(a));
		}
		
		System.out.println();
		for (int[] a: graph) {
			System.out.println(Arrays.toString(a));
		}
*/
	}
}
