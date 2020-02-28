package study;

public class Main_2617_구슬찾기 {

}
//	static int[][] map;
//	static int N,M,ans, mid;
//	static int[][] dp;
//	
//	static int getBig(int i,boolean[] vst) {
//		if (dp[1][i]==-1) {
//			int cnt = 0;
//			for (int j = 1; j<=N; j++) {
//				if (map[j][i]==1 && !vst[j]) {
//					cnt++;
//					vst[j] = true;
//					cnt+=getBig(j,vst);
//					if (cnt>=mid) {
//						ans++;
//						dp[1][i] = cnt;
//						return cnt;
//					}
//				}
//			}
//			dp[1][i] = cnt;
//		}
//		return dp[1][i];
//	}
//	static int getSmall(int i,boolean[] vst) {
//		if (dp[0][i]==-1) {
//			int cnt = 0;
//			for (int j = 1; j<=N; j++) {
//				if (map[i][j]==1 && !vst[j]) {
//					cnt++;
//					vst[j] = true;
//					cnt+=getSmall(j,vst);
//					if (cnt>=mid) {
//						ans++;
//						
//						dp[0][i] = cnt;
//						return cnt;
//					}
//				}
//			}
//			dp[0][i] = cnt;
//		}
//		return dp[0][i];
//	}
//	
//	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		
//		map = new int[N+1][N+1];
//		mid = (N+1)/2;
//		ans = 0;
//		dp = new int[2][N+1];
//		
//		for (int m = 0; m<M; m++) {
//			st = new StringTokenizer(br.readLine());
//			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
//		}
//		
//		for (int i = 1; i<=N; i++) {
//			dp[0][i] = -1;
//			dp[1][i] = -1;
//			
//		}
//		
//		boolean[] vst;
//		for (int i = 1; i<=N; i++) {
//			vst = new boolean[N+1];
//			vst[i] = true;
//			getSmall(i,vst);
//		}	
//		
//		for (int i = 1; i<=N; i++) {
//			vst = new boolean[N+1];
//			vst[i] = true;
//			getBig(i,vst);
//		}	
//		System.out.println(ans);
//	}