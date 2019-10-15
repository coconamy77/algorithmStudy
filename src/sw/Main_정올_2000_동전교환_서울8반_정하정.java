package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_2000_동전교환_서울8반_정하정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] coin = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int n = 0; n < N; n++) {
			coin[n] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(coin);
		st = new StringTokenizer(br.readLine());

		int W = Integer.parseInt(st.nextToken());
		int[] dp = new int[W + 1];
		for (int w = 1; w <= W; w++) {
			int min = W + 1;
			for (int n = 0; n < N; n++) {
				if (coin[n] > w) {
					break;
				}
				int t = dp[w - coin[n]] + 1;
				min = min > t ? t : min;
			}

			dp[w] = min;

		}

		if (dp[W] > W)
			System.out.println("impossible");
		else
			System.out.println(dp[W]);

	}
}
