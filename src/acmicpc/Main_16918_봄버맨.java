package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16918_봄버맨 {
	static int[][] map;
	static int R,C, time;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static void boom(int x, int y, int n) {
		int nx= 0, ny = 0;
		for(int d = 0; d<4; d++) {
			nx = x+dx[d];
			ny = y+dy[d];
			if(nx>=0 && ny>=0 && nx<R && ny<C) {
				if(map[nx][ny]==n) {
					map[nx][ny] = 0;
					boom(nx,ny,n);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		char[] tmp;
		
		for(int r = 0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			tmp = st.nextToken().toCharArray();
			for(int c = 0; c<C; c++) {
				if(tmp[c]=='0') {
					map[r][c] = 3;
				}
			}
		}
		
		System.out.println();
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(map[i][j]==0) {
					System.out.print(".");
				}else {
					System.out.print("0");
				}
			}
			System.out.println();
		}
		
		time = 2;
		while(N>=time) {
			if(time%2==0) {
				for(int r = 0; r<R; r++) {
					for(int c = 0; c<C; c++) {
						if(map[r][c]==0) {
							map[r][c] = time+3;
						}
					}
				}
			}else {
				for(int r = 0; r<R; r++) {
					for(int c = 0; c<C; c++) {
						if(map[r][c]==time) {
							map[r][c] = 0;
							boom(r,c,time);
						}
					}
				}
			}
			time++;
			System.out.println();
			for(int i = 0; i<R; i++) {
				for(int j = 0; j<C; j++) {
					if(map[i][j]==0) {
						System.out.print(".");
					}else {
						System.out.print("0");
					}
				}
				System.out.println();
			}
			System.out.println("["+time+"초 후]");
		}
		
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(map[i][j]==0) {
					System.out.print(".");
				}else {
					System.out.print("0");
				}
			}
			System.out.println();
		}
	}
}
