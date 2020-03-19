package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2814_최장경로{
	
	static int T,N,M,ans;
	static int[][] map;
	
	static void dfs(int v, int sum, boolean[] vst){
		if (ans==N){
			return;
		}
		if (sum==N){
			ans = sum;
			return;
		}
		boolean chk;
		ans = sum>ans?sum:ans;
		for (int i = 1; i<=N; i++){
			if (!vst[i] && map[v][i]==1){
				chk = true;
				sum += 1;
				vst[i] = true;
				dfs(i, sum, vst);
				vst[i] = false;
				sum -= 1;
			}
		}
	}
	
    public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
   		
		T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t<=T; t++){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N+1][N+1];
			
			ans = 0;
			
			int x,y;
			
			for (int m = 0; m<M; m++){
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				map[x][y] = 1;
				map[y][x] = 1;	
				
			}
			
			boolean[] vst = new boolean[N+1];
			
			for (int i = 1; i<N+1;i++){
				vst[i] = true;
					
				dfs(i,1,vst);
				
				vst[i] = false;
				
			}
			
			
			System.out.println("#"+t+" "+ans);
			
		}
		
	
	}

}



