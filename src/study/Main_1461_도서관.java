package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1461_도서관 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] map = new int[N];

		st = new StringTokenizer(br.readLine());

		int cnt = 0;
		for (int n = 0; n < N; n++) {
			map[n] = Integer.parseInt(st.nextToken());
			if (map[n] < 0)
				cnt++;
		}

		Arrays.sort(map);

		int ans = 0;

		if (cnt == 0 || map[0] * -1 >= map[N - 1]) {
			int ncnt = cnt + (N - cnt) % M;
			ans += map[ncnt];
			for (int i = cnt+1; i < ncnt; i++) {
				//ans+=
			}

			for (int i = ncnt; i < N; i++) {

			}
		}

	}

}
