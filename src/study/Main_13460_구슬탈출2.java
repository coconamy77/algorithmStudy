package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2 {

	static int[][] map;
	static int N,M;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int rx,ry,bx, by, hx,hy;
	
	static void move(int d) {
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		String s;
		//구멍-2, 빨강-3, 파랑-4
		for (int n = 0; n<N; n++) {
			s = br.readLine();
			for (int m = 0; m<M; m++) {
				switch(s.charAt(m)) {
				case '#':
					map[n][m] = -1;
					break;
				case '0':
					map[n][m] = 2;
					hx = n;
					hy = m;
					break;
				case 'R':
					map[n][m] = 3;
					rx = n;
					ry = m;
					break;
				case 'B':
					map[n][m] = 4;
					bx = n;
					by = m;
					break;
				}
			}
		}
		
		
	}
}
