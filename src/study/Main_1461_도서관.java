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
		int idx = cnt;

		if (cnt == 0 || map[0] * -1 >= map[N - 1]) {
			int ncnt = cnt + (N - cnt) % M;
			if (ncnt>cnt) {
				ans += map[idx];
			}
			for (int i = cnt; i < ncnt; i++) {
				ans+= map[i]-map[idx];
				idx = i;
			}
			ans += map[idx];
			idx = ncnt;
			for (int i = ncnt+1; i < N; i++) {
				ans+=map[i]-map[idx];
				idx = i;
			}
			if(cnt!=0) {
				ans += map[idx];
			}
			
			
		}

	}

}
