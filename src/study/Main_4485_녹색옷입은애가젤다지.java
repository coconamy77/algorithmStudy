package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지 {

	static int[][] map;
	static int N, INF = Integer.MAX_VALUE;
	static int[][] dp;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = 1;
		N = Integer.parseInt(st.nextToken()); 
		
		while(N!=0) {
			map = new int[N][N];
			dp = new int[N][N];
			
			for (int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dp[i][j] = INF;
					
				}
			}
			dp[0][0] = map[0][0];
			
			PriorityQueue<int[]> q= new PriorityQueue<int[]>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					
					return 0;
				}
				
				
			}) ;
			
			
			
			System.out.println("Problem "+(T++)+": ");
			
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
		}
		
		
		
		
	}
}
