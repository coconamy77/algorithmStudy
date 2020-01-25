package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13458_시험감독 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] a = new int[N];
		st =  new StringTokenizer(br.readLine());
		
		for (int i = 0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			
		}

		st =  new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		long ans = N;
		for (int i = 0; i<N; i++) {
			a[i]-= b;
			if (a[i]>0) {
				ans +=a[i]/c;
				if (a[i]%c>0) {
					ans++;
				}
			}
		}
		
		System.out.println(ans);
		
		
	}
}
