package swtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9613_gcd합 {

	static int getGcd(int a, int b) {
		int r = a % b;
		while (r > 0) {
			a = b;
			b = r;
			r = a % b;
		}
		return b;
	}
	
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int N;
		long gcd;
		int a[];
		for (int t = 1; t <= T; t++) {
			gcd = 0;
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			a = new int[N];
			
			for (int i=0; i<N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i= 0; i<N-1; i++) {
				for (int j = i+1;j<N;j++) {
					
					if (a[i] > a[j]) {
						gcd += getGcd(a[i], a[j]);
						
					} else {
						gcd += getGcd(a[j], a[i]);
					}
					
				}
			}
			System.out.println(gcd);
		}
	}
}
