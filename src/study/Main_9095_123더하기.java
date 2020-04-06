package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9095_123더하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] dp;
		int N;
		for (int t = 1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			dp = new int[N+1];
			
			for (int i = 1; i<=N; i++) {
				if(i>3) {
					break;
				}
				switch(i) {
				case 1: 
					dp[i] = 1;
					break;
				case 2:
					dp[i] = 2;
					break;
				case 3: 
					dp[i] = 4;
					break;
				}
			}
			for (int i = 4; i<=N; i++) {
				dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
			}
			
			System.out.println(dp[N]);
		}
		
	
	}
}
