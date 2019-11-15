package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1733_오목_서울8반_정하정 {
	
	public static int r, ri, rj, si, sj, ar[][];
	public static int[] di = {0, 1, 1, -1};
	public static int[] dj = {1, 1, 0, 1};
	
	public static void dfs(int i, int j, int cnt, int way, int color) {
		if(cnt == 5 && ar[i][j] == color) {
			if((0 <= si-di[way] && si-di[way] < 19 && 0 <= sj-dj[way] && sj-dj[way] < 19 && ar[si-di[way]][sj-dj[way]] == color)
					|| (0 <= i+di[way] && i+di[way] < 19 && 0 <= j+dj[way] && j+dj[way] < 19 && ar[i+di[way]][j+dj[way]] == color)) {
				return;
			}
			else {
				r = color;
				return;
			}
		}
		
		int ni = i + di[way];
		int nj = j + dj[way];
		
		if(0 <= ni && ni < 19 && 0 <= nj && nj < 19 && ar[ni][nj] == color) {
			dfs(ni, nj, cnt+1, way, color);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ar = new int[19][19];
		r = 0;
		ri = 0;
		rj = 0;
		
		for(int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 19; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				if(ar[i][j] == 1) {
					for(int k = 0; k < 4; k++) {
						si = i;
						sj = j;
						dfs(i, j, 1, k, 1);
						if(r == 1) {
							ri = si;
							rj = sj;
							break;
						}
					}
					if(r != 0) break;
					
				} else if(ar[i][j] == 2) {
					for(int k = 0; k < 4; k++) {
						si = i;
						sj = j;
						dfs(i, j, 1, k, 2);
						if(r == 2) {
							ri = i;
							rj = j;
							break;
						}
					}
					if(r != 0) break;
				}
			}
			if(r != 0) break;
		}
		
		if(r == 0) {
			System.out.println(r);
		} else {
			System.out.println(r + "\n" + (ri+1) + " " + (rj+1));
		}
	}
}

	
	/*static int[][] map;
	static int[] dx = {-1,0,1,1};
	static int[] dy = {1,1,1,0};
	static int ax, ay;
	
	static int dfs(int dep, int od, int x, int y,int ox, int oy) {
		int col = map[x][y];
		if (dep>=5) {
			int nx = x+dx[od];
			int ny = y+dy[od];
			if (nx>=0 && ny>=0 && nx<19 && ny<19 && map[nx][ny]==col) {
				return 0;
			}
			nx = ox - dx[od];
			ny = oy -dy[od];
			
			if (nx>=0 && ny>=0 && nx<19 && ny<19 && map[nx][ny]==col) {
				return 0;
			}
			ax = ox;
			ay = oy;
			return col;
		}
		
		int t = 0;
		for (int d = 0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if (nx>=0 && ny>=0 && nx<19 && ny<19 && map[nx][ny]==col) {
				if (d==od) {
					 t = dfs(dep+1, d, nx, ny,ox, oy);
					
				}
				else {
					t = dfs(2, d, nx,ny,x, y);
				}
			}
			
		}
		
		return t;
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[19][19];
		ax = 0; ay =0;
		
		for (int i = 0; i<19; i++) {
			StringTokenizer st = new StringTokenizer( br.readLine());
			
			for (int j = 0; j<19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				
			}
		}
		int x = 0; int y = 0;
		for (int i = 0; i<19; i++) {
			for (int j = 0; j<19; j++) {
				if (map[i][j]!=0) {
					x= i;
					y = j;
					for (int d = 0; d<4; d++) {
						int nx = x+dx[d];
						int ny = y+dy[d];
						if (nx>=0 && ny>=0 && nx<19 && ny<19 && map[nx][ny]==map[x][y] ) {
							int t = dfs(2, d, nx, ny,x,y);
							if (t!=0) {
								System.out.println(t);
								System.out.println((ax+1)+" "+(ay+1));
								return;
							}
						}
						
					}
				}
			}
		}
		
		System.out.println(0);
		
		
	}
}*/
