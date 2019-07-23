package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5215_hamburger{
	
	static int L,max=0;
	
	static void getScore(int[][] arr, int sBefore,int kBefore, int i) {
		System.out.print("i = "+i+", ");
		int score = sBefore+arr[i][0];
		int kal = kBefore+arr[i][1];
		if (kal>L) {
			max = max>sBefore? max: sBefore;
			return;
		}else if (i==arr.length-1) {
			max = max>score? max: score;
			return;
		}
		for (int j = i+1; j<arr.length;j++) {
			
			getScore(arr, score, kal, j);
			
		}System.out.println();
		return;
	}
 
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_5215.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for ( int t = 1; t<=T;t++) {
			
			st = new StringTokenizer(br.readLine());
		
			int N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			int[][] f = new int[N][2];
			
		
			
			for (int n = 0; n<N;n++) {
				st = new StringTokenizer(br.readLine());
				f[n][0] = Integer.parseInt(st.nextToken());
				f[n][1] = Integer.parseInt(st.nextToken());
				
			}
			max = f[0][0];
			for (int i = 0; i<N; i++) {
				
				getScore(f, 0, 0, i);
				
				
			}
			
			System.out.println("#"+t+" "+max); 
		}
		
		
	}

}
