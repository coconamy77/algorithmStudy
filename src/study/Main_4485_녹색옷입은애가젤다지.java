package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지 {

	static int[][] map;
	static int N;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		while(T!=0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			dp = new int[N][N];
			
			for (int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j<N; j++) {
					
				}
				
			}
			
			
			
			
			
			
			st = new StringTokenizer(br.readLine());
			T = Integer.parseInt(st.nextToken());
		}
		
		
		
		
	}
}
