package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465_스티커 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		int dp[][];
		int map[][];
		for (int t = 1; t<=T;t++) {
			int n = Integer.parseInt(br.readLine());
			map = new int[2][n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i<n; i++) {
				map[0][i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i<n; i++) {
				map[1][i] = Integer.parseInt(st.nextToken());
			}
			
			dp = new int[3][n];
			
			dp[1][0] = map[0][0];
			dp[2][0] = map[1][0];
			
			for (int i = 1; i<n; i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[2][i-1]);
				dp[1][i] = Math.max(dp[0][i-1], dp[2][i-1])+map[0][i];
				dp[2][i] = Math.max(dp[1][i-1], dp[0][i-1])+map[1][i];
				
			}
			
			int ans = dp[0][n-1];
			ans = Math.max(dp[2][n-1], dp[1][n-1]);
			System.out.println(ans);
			
		}
	}
}
