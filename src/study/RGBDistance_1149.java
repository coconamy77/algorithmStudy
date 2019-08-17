package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGBDistance_1149 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[][] house = new int[N][3];
		
		st = new StringTokenizer(br.readLine());
		house[0][0] = Integer.parseInt(st.nextToken());
		house[0][1] = Integer.parseInt(st.nextToken());
		house[0][2] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<3;j++) {
				int p = Integer.parseInt(st.nextToken());
				house[i][j] = 1000*N+1;
				for (int k = 0; k<3; k++) {
					if (j==k) continue;
					house[i][j] = house[i][j]>house[i-1][k]+p?house[i-1][k]+p:house[i][j];
				}
				
			}
			
		}
		int min = house[N-1][0];
		for (int a: house[N-1]) {
			min = min>a? a: min;
		}
		
		System.out.println(min);
		
		
		
	}
}
