package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LinkedNode_11724 {

	static int count = 0;
	static int[][] a;
	static boolean[] vst;
	static void dfs(int x,int y) {
		vst[y] = true;
		for (int i = x; i<a.length;i++) {
			if (!vst[i] && a[y][i] ==1) {
				dfs(y,i);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		a = new int[N][N];
		vst = new boolean[N];
		for (int m =0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
		
			a[x-1][y-1] = 1;
			a[y-1][x-1] = 1;
			
			
		}
		
		for (int i = 0; i<N; i++) {
			if (vst[i])continue;
			for (int j = i; j<N; j++) {
				if (!vst[j] && a[i][j] == 1 ) {
					dfs(i,j);
					
				}
			}
			count++;
			vst[i] = true;
			
		}
		System.out.println(count);
	}
}
