package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lab3_17142 {
	static int[][] lab;
	static int N;
	static int[] virus;
	static int M;
	
	public static int bfs(int[] v) {
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int[][] tmp = new int[N][N];
		for (int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				tmp[i][j] = lab[i][j];
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i<M; i++) {
			q.add(v[i]);
		}

		
		while (!q.isEmpty()) {
			int t = q.poll();
			//System.out.println(t);
			
			for (int d = 0; d<4; d++) {
				int nx = t/100+dx[d];
				int ny = t%100+dy[d];
				
				if (nx>=0 && ny>=0 && nx<N && ny<N && tmp[nx][ny]==0) {
					//System.out.println(t);
					tmp[nx][ny] = tmp[t/100][t%100]+1;
					
					if (nx*100+ny>0)
					q.add(nx*100+ny);
					
				}
			}
		}
		System.out.println();
		int max = 0;
		
		/*for (int i = 0; ;i++) {
			if (virus[i]==-1) {
				break;
			}
			int p = virus[i];
			tmp[p/100][p%100] = 1;
		}*/
		
		for (int[] a: tmp) {
			System.out.println(Arrays.toString(a));
			for (int b : a) {
				if (b==0) {
					return -1;
				}
				max = max>b?max:b;
			}
		}

		return max;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		lab = new int[N][N];
		int M = Integer.parseInt(st.nextToken());
		virus = new int[N*N];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int t = Integer.parseInt(st.nextToken());
				if (t == 2) {
					virus[idx++] = i * 100 + j;
					
				} else if (t == 1) {
					lab[i][j] = -1;
				}
			}
		}
		
		virus[idx] = -1;
		int min = N*N;
		for (int i = 0; i < idx - (M-1); i++) {
			int[] v = new int[M];
			int tmp = dfs(i,v,0);
			if (tmp!=-1)
			min = min > tmp ? tmp : min;
		}
		
		//int tmp = bfs(virus[0], virus[1], virus[2]);
		System.out.println(min);
	}
	static int dfs(int i,int[] v, int d) {
		v[d] = virus[i];
		if (d==M-1) {
			
			return bfs(v);
		}
			for (int j = i+1; j<N-((M-1)-d);j++) {
				
				
			}
		
		
	}
}
