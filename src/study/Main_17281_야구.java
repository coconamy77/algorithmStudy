package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17281_야구 {
	
	static int[][] result;
	static int N,max;
	
	
	static void getAns(int dep, int[] sel, boolean[] vst) {
		if (dep==0) {
			
			
			
			return;
		}
		
		
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		result = new int[N][9];
		
		for (int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int p = 0; p<9; p++) {
				result[i][p] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
	}
}
