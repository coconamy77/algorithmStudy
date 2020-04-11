package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018_체스판다시칠하기 {
	static int[][] map;
	static int N,M,ans=64;
	static int getMin(int x,int y, int col) {
		int count=0;
		for (int i =x; i<x+8; i++) {
			for (int j = y; j<y+8; j++) {
				if (map[i][j]!=col) {
					count++;
					if (ans<=count) {
						return 100;
					}
				}
				col = (col+1)%2;
			}
			col = (col+1)%2;
		}
		
		return count;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int n = 0; n<N; n++) {
			String s = br.readLine();
			for (int m = 0; m<M; m++) {
				switch(s.charAt(m)) {
				case 'B':
					map[n][m] = 1;
					break;
				case 'W':
					map[n][m] = 0;
				}
			}
		}
		/*
		 * for (int i =0; i<N; i++) { for (int j =0; j<M; j++) {
		 * System.out.print(map[i][j]); } System.out.println(); }
		 */
		
		int tmp = 0;
		for (int n =0; n<=N-8; n++) {
			for (int m = 0; m<=M-8; m++) {
				tmp = getMin(n,m,0);
				if (tmp<ans) {
					ans = tmp;
				}
				tmp = getMin(n,m,1);
				if (tmp<ans) {
					ans = tmp;
				}
			}
		}
		System.out.println(ans);
	}
}
