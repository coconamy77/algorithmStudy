package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_종이자르기_2628 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean[] nl = new boolean[N];
		boolean[] ml = new boolean[M];
		int cut = Integer.parseInt(br.readLine());
		
		for (int c = 0; c<cut; c++) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "0":
				nl[Integer.parseInt(st.nextToken())] = true;
				break;
			case "1":
				ml[Integer.parseInt(st.nextToken())] = true;
				break;
			}
		}
		
		int maxn = 0;
		int maxm = 0;
		int ni = 0;
		int mi = 0;
		for (int n=0; n<N; n++) {
			if (nl[n]==true) {
				maxn = maxn>n-ni?maxn:n-ni;
				ni = n;
			}
		}
		maxn = maxn>N-ni?maxn:N-ni;
		for (int m=0; m<M; m++) {
			if (ml[m]==true) {
				maxm = maxm>m-mi?maxm:m-ni;
				mi = m;
			}
		}
		maxm = maxm>M-mi?maxm:M-mi;
		System.out.println(maxn*maxm);
	}
}

/*
10 8
3
0 3
1 4
0 2

50 50
4
0 45
0 30
0 29
0 48

*/