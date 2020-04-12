package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1966_프린터큐 {
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		
		for (int t = 1; t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] num = new int[N];
			int ans = 0;
			
			st = new StringTokenizer(br.readLine());
			
			for (int n = 0; n<N; n++) {
				num[n] = Integer.parseInt(st.nextToken());
			}
			
			int idx = 0; 
			
			while(true) {
				if (idx>=N) {
					idx = 0;
				}
				
				if (num[idx]>=0) {
					int i = 0;
					for (; i<N; i++) {
						if (num[i]>num[idx]) {
							break;
						}
					}
					if (i==N) {
						ans++;
						if (idx==M) {
							break;
						}
						num[idx] = -1;
					}
				}
				
				idx++;
				
			}
			System.out.println(ans);
		}
	
	}
}
