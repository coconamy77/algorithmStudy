package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_4963_섬의개수_서울8반_정하정_dfs {
	
	static int[][] map;
	static boolean[][] vst;
	static int N,M;
	static int[] dx = { 0, 0, 1, -1, 1, 1, -1, -1 };
	static int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };
	
	static void dfs(int x, int y) {
		vst[x][y] = true;
		for (int d = 0; d < 8; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
		  if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 1 && !vst[nx][ny]) {
			  vst[nx][ny] = true;
			  dfs(nx, ny);
		  }
			 
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			 M = Integer.parseInt(st.nextToken());
			 N = Integer.parseInt(st.nextToken());

			if (N == 0)
				break;

			map = new int[N][M];
			vst = new boolean[N][M];
			
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
						dfs(n, m);
						count++;
					}
				}
			}
			System.out.println(count);

		}

	}
}
