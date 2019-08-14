package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Robot_14503 {
	
	static int[][] room;
	static int count = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int way = Integer.parseInt(st.nextToken());
		
		room = new int[N][M]; 
		
		for (int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m=0; m<M; m++) {
				room[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		goRobot(x,y,way);
		
		System.out.println(count);
	}
	
	static void goRobot(int x, int y, int w) {
		room[x][y]=-1;
		count++;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		int nw = w;
		boolean chk = true;
		
		for (int i =1; i<5; i++) {
			nw = nw==0?3:nw-1;
			int nx = x+dx[nw];
			int ny = y+dy[nw];
			
			if ( room[nx][ny]==-1|| room[nx][ny]==1) {
				continue;
			}
			
			if (room[nx][ny]==0) {
				goRobot(nx, ny,nw);
				chk = false;
				break;
			}
		}
		if (chk) {
			if (room[x+dx[(w+2)%4]][y+dy[(w+2)%4]]==1) {
				return;
			}else {
				count--;
				goRobot(x+dx[(w+2)%4],y+dy[(w+2)%4],w);
			}
			
		}
		
	}
}
