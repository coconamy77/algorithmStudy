import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		String[] row = input.split(" ");
		
		int[][] map = new int[row.length][row[0].length()/2+1];
		int idx = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		
		for (int i = 0; i<row.length; i++) {
			idx = 0;
			for (int j= 0;j<row[0].length()/2+1; j++) {
				map[i][j] = row[i].charAt(idx++)-'0';
				idx++;
				if (map[i][j]==1) {
					q.add(new int[] {i,j});
				}
			}
		}
	
		
		int ans = 0;
		int[] xy = new int[2];
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		int nx, ny;
		
		while(!q.isEmpty()) {
			xy = q.poll();
			
			for (int d = 0; d<4; d++) {
				nx = xy[0]+dx[d];
				ny = xy[1]+dy[d];
				
				if (nx>=0 && nx<map.length && ny>=0 && ny<map[0].length && map[nx][ny]==0) {
					ans++;
				}
			}
		}
		System.out.println(ans);
		
	}
}