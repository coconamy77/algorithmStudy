package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13023_ABCDE {

	static int N, M, ans = 0;
	static int[][] map;

	static void getAns(int dep, int y, boolean[] vst) {
		if (dep == 4) {
			ans = 1;
			return;
		}
		if (ans == 1) {
			return;
		}

		for (int j = 0; j < N; j++) {
			if (map[y][j] == 1 && !vst[j]) {
				vst[j] = true;
				getAns(dep + 1, j, vst);
				vst[j] = false;
				
			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		int ti, tj;
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			ti = Integer.parseInt(st.nextToken());
			tj = Integer.parseInt(st.nextToken());

			map[ti][tj] = 1;
			map[tj][ti] = 1;
		}

		/*for (int i = 0; i<N; i++) {
			for (int j = 0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}*/
		boolean[] vst = new boolean[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				vst = new boolean[N];
				if (map[i][j] == 1) {
					vst[i] = true;
					vst[j] = true;
					getAns(1, j, vst);
					vst[i] = false;
					vst[j] = false;
				}
				if (ans==1) {
					i=N;
					break;
				}
			}

		}
		System.out.println(ans);
	}

}
