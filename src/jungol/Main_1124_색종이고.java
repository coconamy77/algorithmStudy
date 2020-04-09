package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1124_색종이고 {
	
	static int getRec(int x, int y) {
		int w=1, h=1;
		
		for (int i = x; i<100; i++) {
			
		}
		
		
		return w*h;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[100][100];
		
		int x,y;
		
		for (int n = 0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			for (int i = x; i<x+10;i++) {
				for (int j = y;j<y+10;j++) {
					map[i][j] = 1;
				}
			}
		}
		
		for (int i = 0; i<100; i++) {
			for (int j = 0; j<100; j++) {
				if (map[i][j]==1) {
					
				}
			}
		}
		
		
	}

}
