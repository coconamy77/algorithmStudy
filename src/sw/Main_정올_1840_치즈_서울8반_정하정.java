package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정올_1840_치즈_서울8반_정하정 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] ch = new int[N][M];
		
		
		for (int n = 0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m<M; m++) {
				 ch[n][m] =Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 0; i<N; i++) {
			ch[i][M-1] = -1;
			ch[i][0] = -1;
			q.add(new int[] {i,M-1,0});
			q.add(new int[] {i,0,0});	
		}
		for (int i = 0; i<M; i++) {
			ch[N-1][i] = -1;
			ch[0][i] = -1;
			q.add(new int[] {N-1,i,0});
			q.add(new int[] {0,i,0});	
		}
		
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			int v = tmp[2];
			
			for (int d = 0; d<4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if (nx>=0 && ny>=0 && nx<N && ny<M ) {
					if (ch[nx][ny]==v) {
						
					}
				}
			}
			
			
			
			
		}
		
		
		
	}
}
