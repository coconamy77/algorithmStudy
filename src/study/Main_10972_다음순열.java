package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10972_다음순열 {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int[] n = new int[N+1];
		int[] l = new int[N+1];
		
		int t = 0;
		boolean c = true;
		int ans = -1;
		
		for (int i = 1; i<=N;i++) {
			t = Integer.parseInt(st.nextToken());
			
			n[i] = t;
			l[t] = i;
			
			if (i+t!=N+1) {
				c = false;
			}
		}
		if (!c) {
			if (l[N] == N) {
				t = n[N-1];
				n[N-1] = N;
				n[N] = t;
			}else {
				
			}
			
		}
		
		
	}
}
