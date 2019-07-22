package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D3_5215_hamburger{
	
	static int getScore(int[][] arr, Stack vst, int score,int i) {
		
		
		
		
		
		
		return score;
	}
 
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_5215.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for ( int t = 1; t<=T;t++) {
			
			st = new StringTokenizer(br.readLine());
		
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] f = new int[N][2];
			
			Stack vst;
			
			for (int n = 0; n<N;n++) {
				st = new StringTokenizer(br.readLine());
				f[n][0] = Integer.parseInt(st.nextToken());
				f[n][1] = Integer.parseInt(st.nextToken());
				
			}
			
			for (int i = 0; i<N; i++) {
				vst = new Stack();
				int score = 0;
				int max = 0;
				vst.add(i);
				
				score  = getScore(f,vst, score, i);
				
				
			}
		}
		
		
	}

}
