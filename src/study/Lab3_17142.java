package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lab3_17142 {
	static int[][] lab;
	public static int  bfs(int v1, int v2, int v3) {
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v1);
		q.add(v2);
		q.add(v3);
		
		while (!q.isEmpty()) {
			
		}
		
		return -1;
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		lab = new int[N][N];
		int M = Integer.parseInt(st.nextToken());
		int[] virus = new int[M];
		int idx = 0;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j<N; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if (lab[i][j]==2) {
					virus[idx++] = i*100+j;
				}
			}
		}
		int max = -1;
		for (int i=0; i<N-2; i++) {
			for (int j = i+1; j<N-1; j++) {
				for (int k = j+1; k<N; k++) {
					int tmp = bfs(virus[i], virus[j], virus[k]);
					max = max>tmp?max:tmp;
				}
			}
		}
		System.out.println(max);
	}
}
