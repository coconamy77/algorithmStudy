package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stairs_2579 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] max = new int[N+1][2];
		int x = Integer.parseInt(br.readLine());
		max[1][1] = x;
		max[1][0] = x;
		for (int i = 2; i<=N; i++) {
			x = Integer.parseInt(br.readLine());
			max[i][0] = max[i-2][0]>max[i-2][1]? max[i-2][0]+x:max[i-2][1]+x;
			max[i][1] = max[i-1][0]+x;
		}
		int ans = max[N][0]>max[N][1]? max[N][0]:max[N][1];
		
		System.out.println(ans);
	}
}
