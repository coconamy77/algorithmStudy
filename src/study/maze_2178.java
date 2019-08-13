package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class maze_2178 {
	static int min;
	static int[][] map;

	/*static void go(int x, int y) {

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int num = map[x][y];
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < map.length && nx >= 0 && ny < map[0].length && ny >= 0) {
				if (nx == map.length - 1 && ny == map[0].length - 1) {
					map[nx][ny] = num + 1;
					min = min > map[nx][ny] ? map[nx][ny] : min;
					return;
				}
				if (map[nx][ny] == 1) {
					map[nx][ny] = num + 1;
					go(nx, ny);
				}
			}
		}

	}*/

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int n = 0; n < N; n++) {
			String s = br.readLine();
			for (int m = 0; m < M; m++) {
				map[n][m] = s.charAt(m) - '0';
			}
		}
		
		
		min = N * M;

		Queue<int[]> q = new LinkedList<int[]>();
		
		
		int[] t = {0,0};
		q.add(t);
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		while (q.peek()[0]!=N-1 ||q.peek()[1]!=M-1 ) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];

				if (nx < map.length && nx >= 0 && ny < map[0].length && ny >= 0) {
					if (map[nx][ny] == 1) {
						map[nx][ny] = map[tmp[0]][tmp[1]] + 1;
						int[] ntmp = {nx,ny};
						q.add(ntmp);
					}
				}
			}
		 
		}
		
		
		//go(0, 0);

		System.out.println(map[N-1][M-1]);
	}

}
