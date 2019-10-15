package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14889_스타트와링크_서울8반_정하정 {

	static int N, min;
	static int[][] peo;

	static void sep(int dep, int start, int[] sel) {
		if (dep == N / 2) {
			int[] sum = new int[2];
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (sel[i] == sel[j]) {
						sum[sel[i]] += peo[i][j];
						sum[sel[i]] += peo[j][i];
					}
				}
			}
			int sub = Math.abs(sum[0] - sum[1]);
			min = sub < min ? sub : min;
		} else {
			for (int i = start; i < N; i++) {
				sel[i] = 1;
				sep(dep + 1, i + 1, sel);
				sel[i] = 0;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		peo = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				peo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		sep(0, 0, new int[N]);
		System.out.println(min);
	}
}
