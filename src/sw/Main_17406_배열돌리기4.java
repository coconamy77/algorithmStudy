package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {

	static int[][] arr, tmparr;
	static int[][] c;
	static int K, N, M;
	static List<Integer> get;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static void cir(int[] cc) {
		int sx = cc[0];
		int sy = cc[1];
		int ex = cc[2];
		int ey = cc[3];
		// System.out.println(sx + " " + sy + " " + ex + " " + ey);
		int tmp = tmparr[sx][sy];
		int tmpx = sx;
		int tmpy = sy;
		int d = 0;
		while (tmpx != sx || tmpy != sy + 1) {
			int nx = tmpx + dx[d];
			int ny = tmpy + dy[d];
			if (nx >= sx && ny >= sy && nx <= ex && ny <= ey) {

				tmparr[tmpx][tmpy] = tmparr[nx][ny];
				tmpx = nx;
				tmpy = ny;
			} else {
				d++;
			}
		}
		tmparr[tmpx][tmpy] = tmp;
		if (ex - sx > 2 && ey - sy > 2) {
			cir(new int[] { sx + 1, sy + 1, ex - 1, ey - 1 });
		}

	}

	static int getG(int i) {

		if (i == K) {
			tmparr = new int[N][M];
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					tmparr[n][m] = arr[n][m];
				}
			}

			for (int j : get) {

				cir(c[j]);

			}
			int min = 5000;
			for (int[] a : tmparr) {
				int sum = 0;
				for (int aa : a) {
					sum += aa;
				}
				min = min > sum ? sum : min;
			}
			return min;
		}
		int min = 5000;
		for (int j = 0; j < K; j++) {
			if (!get.contains(j)) {
				get.add(j);
				int tmpans = getG(i + 1);
				get.remove(get.size() - 1);
				min = min > tmpans ? tmpans : min;
			}

		}
		return min;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		c = new int[K][4];
		arr = new int[N][M];
		get = new ArrayList<>();

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());

			}
		}

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int ce = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());

			int sx = r - s;
			int sy = ce - s;
			int ex = r + s;
			int ey = ce + s;
			c[k] = new int[] { sx, sy, ex, ey };
		}

		int ans = getG(0);

		System.out.println(ans);
	}

}
