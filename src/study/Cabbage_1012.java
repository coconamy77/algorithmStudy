package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cabbage_1012 {

	static int count = 0;

	static void safeZone(int[][] a, int y, int x) {
		if (a[y][x] == 0) {
			return;
		}
		a[y][x] = 0;
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		for (int i = 0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<a[0].length && nx>=0 && ny<a.length && ny>=0) {
				safeZone(a, y+dy[i],x+dx[i]);
			}
		}
	}

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/cabbage_1012.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] cab = new int[N][M];

			count = 0;

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				cab[y][x] = 1; 
			}
			
			 

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cab[i][j] == 1) {
						safeZone(cab, i, j);
						count++;
					}

				}

			}

			System.out.println(count);

		}

	}

}
