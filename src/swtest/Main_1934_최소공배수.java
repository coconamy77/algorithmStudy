package swtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1934_최소공배수 {

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

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int gcd = 0;

			if (a > b) {
				gcd = getGcd(a, b);

			} else {
				gcd = getGcd(b, a);
			}

			System.out.println(a * b / gcd);
		}
	}
}
