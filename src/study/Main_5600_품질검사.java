package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5600_품질검사 {

	static int[] p;

	static void check(int a, int b, int c, int r) {
		if (r==1) {
			p[a] = r;
			p[b] = r;
			p[c] = r;
			return;
		}
		if (p[a] == p[b] && p[b] == p[c]) {
			return;
		} else{
			if (p[a] == p[b]) {
				if (p[a]==1) {
					p[c] = r;
				}
			}
			else if (p[a] == p[c]) {
				if (p[a]==1) {
					p[b] = r;
				}
			}
			else if (p[b] == p[c]) {
				if (p[b]==1) {
					p[a] = r;
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		String[] result = new String[N];

		p = new int[a + b + c + 1];

		for (int i = 1; i < a + b + c + 1; i++) {
			p[i] = 2;
		}
		int r = 0;
		for (int n = 0; n < N; n++) {
			result[n] = br.readLine();

			for (int m = 0; m < 4; m++) {
				st = new StringTokenizer(result[n]);
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());

				check(a, b, c, r);
			}

		}
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < 4; m++) {
				st = new StringTokenizer(result[n]);
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());

				check(a, b, c, r);
			}
		}
		
		for (int i = 1; i<p.length; i++) {
			System.out.println(p[i]);
		}

	}
}
