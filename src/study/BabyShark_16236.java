package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BabyShark_16236 {
	static int[][] map;
	static int[] fish;
	static int x;
	static int y;
	static int size = 2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		fish = new int[7];//물고기 크기별 마리수
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp != 0) {
					if (tmp == 9) {
						x = i;
						y = j;
					} else {
						fish[tmp]++;
					}
					map[i][j] = tmp;
				}
			}
		}

		int edible = fish[1];
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int distance = 0;
		int eat = 0;
		while (edible > 0) {

			int[][] vst = new int[map.length][map.length];
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(x * 50 + y);
			vst[x][y] = 1;
			int gox = 0;
			int goy = 0;
			int tmpd = 0;
			while (!q.isEmpty()) {
				int tmp = q.poll();
				int px = tmp / 50;
				int py = tmp % 50;
				if (tmpd != 0 && tmpd <= vst[px][py]) {
					break;
				}

				for (int d = 0; d < 4; d++) {
					int nx = px + dx[d];
					int ny = py + dy[d];

					if (nx >= 0 && ny >= 0 && nx < map.length && ny < map.length && vst[nx][ny] == 0
							&& map[nx][ny] <= size) {

						vst[nx][ny] = vst[px][py] + 1;

						if (map[nx][ny] != 0 && map[nx][ny] < size) {
							if (tmpd == 0) {
								tmpd = vst[nx][ny];
								gox = nx;
								goy = ny;

							} else {
								if (nx < gox) {
									gox = nx;
									goy = ny;
								} else if (nx == gox) {
									if (ny < goy) {
										goy = ny;
									}
								}
							}

						} else {
							q.add(nx * 50 + ny);
						}

					}
				}
			}
			if (tmpd != 0) {
				map[x][y] = 0;
				x = gox;
				y = goy;
				fish[map[x][y]]--;
				map[x][y] = 9;
				edible--;
				eat++;
				distance += tmpd - 1;
				if (size <= 6 && eat == size) {
					eat = 0;
					size++;
					edible += fish[size - 1];
				}
			} else 	break;
			
		}
		System.out.println(distance);

	}
}
