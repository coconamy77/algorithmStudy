package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2617_구슬찾기 {

	static int[][] map;
	static int N,M,ans, mid;
	static int[][] dp;
	
	static int getBig(int i) {
		if (dp[1][i]==-1) {
			int cnt = 0;
			for (int j = 1; j<=N; j++) {
				if (map[j][i]==1) {
					cnt++;
					cnt+=getBig(j);
					if (cnt>=mid) {
						ans++;
						dp[1][i] = cnt;
						return cnt;
					}
				}
			}
			dp[1][i] = cnt;
		}
		return dp[1][i];
	}
	static int getSmall(int i) {
		System.out.println();
		if (dp[0][i]==-1) {
			int cnt = 0;
			for (int j = 1; j<=N; j++) {
				if (map[i][j]==1) {
					cnt++;
					cnt+=getSmall(j);
					if (cnt>=mid) {
						ans++;
						
						dp[0][i] = cnt;
						return cnt;
					}
				}
			}
			dp[0][i] = cnt;
		}
		return dp[0][i];
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		mid = (N+1)/2;
		ans = 0;
		dp = new int[2][N+1];
		
		for (int m = 0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		
		for (int i = 1; i<=N; i++) {
			dp[0][i] = -1;
			dp[1][i] = -1;
			
		}
		
		for (int i = 1; i<=N; i++) {
			getBig(i);
			getSmall(i);
		}
		System.out.println(ans);
	}
}

/*
 * 7 5 5 2 5 7 4 5 6 7 3 1
 * 
 */

//	static int[][] map;
//	static int N, M;
//	static int[][] dp;
//	static int ans,mid;
//
//	static int getSmall(int i) {
//		if (dp[i][0] >= 0) {
//			return dp[i][0];
//		}
//		int cnt = 0;
//		for (int j = 1; j <= N; j++) {
//			if (map[i][j] == 1) {
//				cnt++;
//				cnt += getSmall(j);
//			}
//			if (cnt>=mid) {
//				ans++;
//				dp[i][0] = cnt;
//				return cnt;
//			}
//
//		}
//		dp[i][0] = cnt;
//		return cnt;
//	}
//
//	static int getBig(int i) {
//		if (dp[i][1] >= 0) {
//			return dp[i][1];
//		}
//		int cnt = 0;
//		for (int j = 1; j <= N; j++) {
//			if (map[j][i] == 1) {
//				cnt++;
//				cnt += getBig(j);
//			}
//			if (cnt>=mid) {
//				ans++;
//				dp[i][1] = cnt;
//				return cnt;
//			}
//
//		}
//		dp[i][1] = cnt;
//		return cnt;
//	}
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//
//		map = new int[N + 1][N + 1];
//		dp = new int[N + 1][2];
//		ans = 0;
//		mid = (N + 1) / 2;
//
//		for (int m = 0; m < M; m++) {
//			st = new StringTokenizer(br.readLine());
//			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
//		}
//
//		for (int i = 1; i <= N; i++) {
//			dp[i][0] = -1;
//			dp[i][1] = -1;
//		}
//
//
//		for (int i = 1; i <= N; i++) {
//			getSmall(i);
//			getBig(i);
//			System.out.println(dp[i][0]+" "+dp[i][1]);
//		}
//		
//		
//		System.out.println(ans);
//
//	}