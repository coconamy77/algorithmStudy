package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_정올_1695_단지번호붙이기_Bfs_서울8반_정하정 {
	static int[][] map;
	static boolean[][] vst;
	static int[] ans;
	static void bfs(int i, int j,int idx) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(i*100+j);
		vst[i][j] = true;
		int count = 1;
		while (!q.isEmpty()) {
			int t = q.poll();
			int x = t/100;
			int y = t%100;
			
			int[] dx = {0,1,0,-1};
			int[] dy = {1,0,-1,0};
			
			for (int d = 0; d<4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if (nx>=0 && ny>=0 && nx<map.length && 
						ny<map.length && !vst[nx][ny] && map[nx][ny]!=0) {
					vst[nx][ny] = true;
					count++;
					q.add(nx*100+ny);
				}
			}
			
		}
		
		ans[idx] = count;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		vst = new boolean[N][N];
		ans = new int[N*N];
		for (int i = 0; i<N; i++) {
			String st = br.readLine();
			for (int j = 0; j<N; j++) {
				map[i][j] = st.charAt(j)-'0';
			}
		}
		
		/*for (int[] a: map) {
			System.out.println(Arrays.toString(a));
		}*/
		int count = 0;
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<N; j++) {
				if (!vst[i][j] && map[i][j]==1) {
					bfs(i,j,count++);
				}
			}
		}
		System.out.println(count);
		Arrays.sort(ans);
		for (int i = 0; i<ans.length; i++) {
			if (ans[i]!=0) {
				System.out.println(ans[i]);
			}
			
		}
		
		
		
	}
}
