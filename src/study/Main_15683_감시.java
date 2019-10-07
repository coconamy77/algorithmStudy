package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15683_감시 {
	
	static int[][] map;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static int[] cctv;
	static int N, M, count, min;
	
	public static void cctv(int dep) {
		if (dep==count) {
			
		}
		else {
			//for (int i = ; i<)
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cctv = new int[8];
		
		map = new int[N][M];
		
		min = N*M;
		count = 0;
		for (int n = 0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m<M; m++) {
				int tmp = Integer.parseInt(st.nextToken());
				
				if (tmp!= 0 && tmp!=6) {
					cctv[count++] = m*100+n*10;
				}
				
				map[n][m] = tmp;
			}
		}
		
		cctv(0);
		
		
	}
}
