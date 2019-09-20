package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12100_2048Easy {
	
	static int[][] game;
	static int max = 0;
	static int N;
	
	static void select(int dep, int[] sel) {
		if (dep==5) {
			getMin(sel);
		}
		else {
			for (int i = 0; i<4;i++) {
				sel[dep] = i;
				select(dep+1,sel);			
			}
		}
		
	}
	
	static void getMin(int[] sel) {
		int[][] tmp = new int[N][N];
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<N; j++) {
				tmp[i][j] = game[i][j];
			}
		}
		for (int s = 0; s<5; s++) {
			switch(sel[s]) {
			case 0:
				
			
			
			
			
			
			
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
