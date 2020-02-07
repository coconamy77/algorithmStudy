package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12100_2048Easy {
	
	static int[][] game;
	static int max = 0;
	static int N;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static void select(int dep, int[] sel) {
		if (dep==5) {
			getMax(sel);
		}
		else {
			for (int i = 0; i<4;i++) {
				sel[dep] = i;
				select(dep+1,sel);			
			}
		}
		
	}
	
	static void getMax(int[] sel) {
		int[][] tmp = new int[N][N];
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<N; j++) {
				tmp[i][j] = game[i][j];
			}
		}
		int d = 0;
		int nx, ny;
		for (int s = 0; s<5; s++) {
			d = sel[s];
				for (int i = 0; i<N-1; i++) {
					for (int j = 0; j<N; j++) {
						nx = i+dx[d];
					}
				}
		}
		
		
	}
	
	static void move(int i,int j, int dx,int dy) {
		
		
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		game = new int[N][N];
		
		for (int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j =0; j<N; j++) {
				game[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
	}
}
