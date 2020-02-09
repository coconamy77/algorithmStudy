package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1937_욕심쟁이판다 {
	static int N;
	static int[][] map;
	static int[][] dp;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int getAns(int i, int j) {
		int nx,ny;
		int val = map[i][j];
		int tmp = 0;
		if (dp[i][j]==0) {
			dp[i][j] = 1;
			for (int d = 0; d<4; d++) {
				nx = i+dx[d];
				ny = j+dy[d];
				
				if (nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]>val) {
					tmp = getAns(nx,ny);
					dp[i][j] = tmp+1>dp[i][j]?tmp+1:dp[i][j];					
				}
			}
		}
		
		return dp[i][j];
	}
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N][N];
		
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<N; j++) {
				getAns(i,j);
			}
		}
		int max = 0;
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<N; j++) {
				max = max>dp[i][j]?max:dp[i][j];
			}
		}
		System.out.println(max);
	}
}
