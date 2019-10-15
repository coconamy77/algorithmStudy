package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {
	static int N, M, D, fien, max = 0;
	static int[][] eni;
	static int[] selected;

	public static void getSel(int dept, int start) {
		if (max >= fien)
			return;
		if (dept == 3) {
			int t = getMax();
			max = t > max ? t : max;
		} else {

			for (int i = start; i < M; i++) {
				selected[dept] = i;
				getSel(dept + 1, i + 1);
			}

		}
	}

	static int getMax() {

		int count = 0;
		int d = 0;
		int left = fien;
		int[] vst = new int[fien];
		while (left > 0) {

			for (int i = 0; i < 3; i++) {
				if (left == 0)
					break;
				int min = 0, mindis = D + 1, miny = M;
				for (int j = 0; j < fien; j++) {
					if (vst[j] != 0 && vst[j] != d + 1)
						continue;
					int tmpx = eni[j][0] + d;
					int tmpy = eni[j][1];
					if (tmpx + D < N)
						continue;
					if (tmpx == N && vst[j] == 0) {
						vst[j] = d;
						left--;
						continue;
					}
					int dis = Math.abs(tmpy - selected[i]) + (N - tmpx);
					if ((dis < mindis) || (dis == mindis && tmpy < miny)) {
						min = j;
						mindis = dis;
						miny = tmpy;
					}
				}
				if (mindis <= D && vst[min] == 0) {
					vst[min] = d + 1;
					left--;
					count++;
				}
			}
			d++;
		}
		return count;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		// map = new int[N][M];
		eni = new int[N * M][2];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					eni[fien++] = (new int[] { n, m });
					// map[n][m] = 1;
				}

			}
		}
		selected = new int[3];
		getSel(0, 0);

		System.out.println(max);
	}
}
