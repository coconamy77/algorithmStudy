package HW;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_2817_부분수열의합_서울8반_정하정 {
	public static int[] data;
	public static int N, hap, cnt;
	
	public static void solve(int sum, int pos) {
		if (sum>hap) return;
		if (sum==hap) {
			cnt++;
			return;
		}
		if (pos>N-1) return;
		solve(sum, pos+1);
		solve(sum+data[pos],pos+1);
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d3_부분수열의합.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			data = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {

				data[n] = Integer.parseInt(st.nextToken());
			}

			int count = 0;
			for (int i = 0; i < (1 << data.length); i++) {
				int sum = 0;
				for (int j = 0; j < data.length; j++) {
					if (data[j]>K)break;
					if ((i & (1 << j)) > 0) {
						
						sum = sum + data[j];
						if (sum>K) break;
					}
				}
				if (sum == K) {
					count++;
					continue;
				}

			}
			System.out.println("#" + t + " " + count);

		}

	}

}
