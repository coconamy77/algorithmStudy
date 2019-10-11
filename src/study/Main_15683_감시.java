package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15683_감시 {
	
	static int[][] map;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static int[] check = {4,2,4,4,1};
	static int[] cctv;
	static int N, M, count, min;
	
	static void watch(int i, int start, int[][] tmp) {
		int cctvnum = cctv[i]%10;
		int x = cctv[i]/100;
		int y = (cctv[i]%100)/10;
		int nx = x;
		int ny = y;
		int nstart = start;
		switch(cctvnum) {
		case 5:
			nx = x;
			ny = y;
			nstart = (start+3)%4;
			while(true) {
				nx = nx+dx[nstart];
				ny = ny+dy[nstart];
				if (nx<0 || ny<0 || nx>=N || ny>=M || tmp[nx][ny]==6) {
					break;
				}else {
					tmp[nx][ny] =8;
				}
			}
		case 4: 
			nx = x;
			ny = y;
			nstart = (start+2)%4;
			while(true) {
				nx = nx+dx[nstart];
				ny = ny+dy[nstart];
				if (nx<0 || ny<0 || nx>=N || ny>=M || tmp[nx][ny]==6) {
					break;
				}else {
					tmp[nx][ny] =8;
				}
			}
		case 3:
			nx = x;
			ny = y;
			nstart = (start+1)%4;
			while(true) {
				nx = nx+dx[nstart];
				ny = ny+dy[nstart];
				if (nx<0 || ny<0 || nx>=N || ny>=M || tmp[nx][ny]==6) {
					break;
				}else {
					tmp[nx][ny] =8;
				}
			}
		case 1: 
			nx = x;
			ny = y;
			while(true) {
				nx = nx+dx[start];
				ny = ny+dy[start];
				if (nx<0 || ny<0 || nx>=N || ny>=M || tmp[nx][ny]==6) {
					break;
				}else {
					tmp[nx][ny] =8;
				}
			}
			break;
		case 2:
			nx = x;
			ny = y;
			while(true) {
				nx = nx+dx[start];
				ny = ny+dy[start];
				if (nx<0 || ny<0 || nx>=N || ny>=M || tmp[nx][ny]==6) {
					break;
				}else {
					tmp[nx][ny] =8;
				}
			}
			nstart = (start+2)%4;
			nx = x;
			ny = y;
			while(true) {
				nx = nx+dx[nstart];
				ny = ny+dy[nstart];
				if (nx<0 || ny<0 || nx>=N || ny>=M || tmp[nx][ny]==6) {
					break;
				}else {
					tmp[nx][ny] =8;
				}
			}
		}
	}
	
	public static void cctv(int dep, int[] sel) {
		if (dep==count) {
			int[][] tmp = new int[N][M];
			for (int i = 0; i<N; i++) {
				for (int j = 0; j<M; j++) {
					tmp[i][j] = map[i][j];
				}
			}
			for (int i = 0; i<sel.length; i++) {
				watch(i,sel[i],tmp);
			}
			int countn = 0; 
			for (int i = 0; i<N; i++) {
				for (int j = 0; j<M; j++) {
					if (tmp[i][j] == 0){
						countn++;
						if (countn>min) return;
					}
				}
			}
			min = countn;
			return;
			
		}
		else {
			int cctvnum = cctv[dep]%10-1;
			for (int i = 0; i<check[cctvnum]; i++) {
				sel[dep] = i;
				cctv(dep+1,sel);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cctv = new int[8];
		
		map = new int[N][M];
		
		min = N*M;
		count = 0;
		for (int n = 0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m<M; m++) {
				int tmp = Integer.parseInt(st.nextToken());
				
				if (tmp!= 0 && tmp!=6) {
					cctv[count++] = n*100+m*10+tmp;
				}
				
				map[n][m] = tmp;
			}
		}
		
		cctv(0, new int[count]);
		
		System.out.println(min);
		
	}
}
