package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_정올_2074_홀수마방진_서울8반_정하정 {

	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] ans = new int[N][N];
		int x = 0; 
		int y = N/2;
		for (int i = 1; i<=N*N; i++) {
			ans[x][y] = i;
			x = (x-1+N)%N;
			y = (y-1+N)%N;
			if (i%N==0) {
				x = (x+2+N)%N;
				y = (y+1+N)%N;
			}
		}
		
		for (int[] a: ans) {
			for (int b: a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}
	
}
