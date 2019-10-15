package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_4963_섬의개수_서울8반_정하정_bfs {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dx = { 0, 0, 1, -1, 1, 1, -1, -1 };
		int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			if (N == 0)
				break;

			int[][] map = new int[N][M];
			boolean[][] vst = new boolean[N][M];
			Queue<Integer> q = new LinkedList<Integer>();

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					map[n][m] = Integer.parseInt(st.nextToken());
				}
			}
			
			int count = 0;

			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (map[n][m] == 1 && !vst[n][m]) {
						q.add(n * 100 + m);
						vst[n][m] = true;
						count++;
						while (!q.isEmpty()) {
							int x = q.poll();
							int y = x % 100;
							x = x / 100;
							
							for (int d = 0; d < 8; d++) {
								int nx = x + dx[d];
								int ny = y + dy[d];
							  if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 1 && !vst[nx][ny]) {
								  vst[nx][ny] = true;
								  q.add(nx*100+ny);
							  }
								 
							}

						}
					}
				}
			}
			System.out.println(count);

		}

	}
}
