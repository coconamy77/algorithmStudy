package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20057_마법사상어와토네이도 {
	static int[][] map;
	static int N, answer, x, y;
	static int[][] da = {{ -2, -1, -1, -1, 0, 1, 1, 1, 2, 0 },{ 0, -1, 0, 1, -2, -1, 0, 1, 0, -1 }};
	static double[] dm = { 0.02, 0.1, 0.07, 0.01, 0.05, 0.1, 0.07, 0.01, 0.02 };

	public static void moveS(int dx, int dxd, int dy, int dyd) {
		int now = map[x][y];
		map[x][y] = 0;
		int moved = 0;
		int nx, ny, nm;
		for (int d = 0; d < 9; d++) {
			nx = x + da[dx][d]*dxd;
			ny = y + da[dy][d]*dyd;
			nm = (int) (now * dm[d]);
			//System.out.println("x ="+nx+" y = "+ny+" nm = "+nm);
			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				map[nx][ny] += nm;
			} else {
				answer += nm;
			}
			moved += nm;
		}
		nx = x + da[dx][9]*dxd;
		ny = y + da[dy][9]*dyd;
		nm = now - moved;
		if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
			map[nx][ny] += nm;
		} else {
			answer += nm;
		}
		//System.out.println("x ="+nx+" y = "+ny+" nm = "+nm);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		x = N / 2;
		y = N / 2;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };
		int[][] da = {{0,1,1,1},{1,-1,0,1},{0,-1,1,-1},{1,1,0,-1}};

		for (int t = 1; t < N; t = t + 2) {
			for (int d = 0; d < 4; d++) {
				for (int l = 1; l <= t + d / 2; l++) {
					x = x + dx[d];
					y = y + dy[d];
					moveS(da[d][0],da[d][1],da[d][2],da[d][3]);
//					for(int i = 0; i<N; i++) {
//						System.out.println();
//						for(int j = 0; j<N; j++) {
//							if(i==x && j==y) {
//								System.out.print("* ");
//							}
//							else{
//								System.out.print(map[i][j]+" ");
//								
//							}
//						}
//					}
				}
			}
		}

		for(int t = 1;t<N; t++) {
			x = x + dx[0];
			y = y + dy[0];
			moveS(da[0][0],da[0][1],da[0][2],da[0][3]);
		}
		
		System.out.println(answer);
	}
}
