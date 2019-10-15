package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_14502_연구소_서울8반_정하정 {

	static int[][] map;
	static int N, M, max;
	static int[] virus;
	static int v = 0, s = 0;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static int getSafe() {
		boolean[][] vst = new boolean[N][M];
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i<v; i++) {
			q.add(virus[i]);
		}
		while(!q.isEmpty()) {
			int x = q.poll();
			int y = x%10;
			x = x/10;
			
			for (int d = 0; d<4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if (nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny]==0 && !vst[nx][ny]) {
					vst[nx][ny] = true;
					q.add(nx*10+ny);
				}
			}
		}
		
		int safeZone = 0;
		
		for (int i=0; i<N; i++) {
			for (int j = 0; j<M; j++) {
				if (map[i][j]==0 && !vst[i][j]) {
					safeZone++;
				}
			}
		}
		
		return safeZone;
	}
	
	static void select(int dep, int start,int[] safe) {
		if (dep==3) {
			/*System.out.println();
			for (int[] a: map) {
				System.out.println(Arrays.toString(a));
			}*/
			
			int num = getSafe();
			//System.out.println(num);
			max = max<num?num: max;
			return;
		}
		
		for (int i = start; i<s; i++) {
			int x = safe[i];
			int y = x%10;
			x = x/10;
			
			map[x][y] = 1;
			select(dep+1, i+1, safe);
			map[x][y] = 0;
			
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		virus = new int[10];
		int[] safe = new int[N*M];
		map = new int[N][M];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				int t = Integer.parseInt(st.nextToken());
				if (t==2) {
					virus[v++] = n*10+m;
					map[n][m] = t;
				}else if (t==0) {
					safe[s++] = n*10+m;
				}else {
					map[n][m] = t;
				}
			}
		}
		//System.out.println(Arrays.toString(virus));
		max = 0;
		
		select(0,0,safe);
		
		System.out.println(max);
	}
}
