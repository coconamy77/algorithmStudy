package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3709_레이저빔은어디로 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		for (int t = 1; t<=T; t++) {
			st =new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N+2][N+2];
			
			int x,y;
			for (int r = 0; r<R; r++) {
				st =new StringTokenizer(br.readLine());
				
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				map[x][y] = 1;
			}
			st =new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			int d = 0;
			
			if (x==0) {
				d = 2;
			}else if (x==N+1) {
				d = 0;
			}else if (y==0) {
				d = 1;
			}else if (y==N+1) {
				d = 3;
			}
			
			while(true) {
				x = x+dx[d];
				y = y+dy[d];
				
				if (x==0 || y==0 || x==N+1 || y==N+1) {
					break;
				}
				
				if (map[x][y] == 1) {
					d = ((d+1)+4)%4;
				}
			}
			
			System.out.println(x+" "+y);
		}
	}

}
