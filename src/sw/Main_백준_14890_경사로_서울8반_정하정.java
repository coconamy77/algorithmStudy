package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14890_경사로_서울8반_정하정 {

	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;

		here: for (int i = 0; i < N; i++) {
			int h = map[i][0];
			int n = 1;
			for (int j = 1; j < N; j++) {
				int v = map[i][j] - h;
				if (v == 0)
					n++;
				else if (v == 1) {
					if (n >= L) {
						n = 1;
						h = map[i][j];
					} else {
						continue here;
					}
				} else if (v == -1 && j + L <= N) {
					
						for (int tj = 1; tj < L; tj++) {
							if (map[i][j] != map[i][j + tj]) {
								continue here;
							}
						}
						n = -1;
						h = map[i][j];
						j = j + L - 2;
				} else {
					continue here;
				}
			}
			count++;
		}

		here: for (int j = 0; j < N; j++) {
			int h = map[0][j];
			int n = 1;
			for (int i = 1; i < N; i++) {
				int v = map[i][j] - h;
				if (v == 0)
					n++;
				else if (v == 1) {
					if (n >= L) {
						n = 1;
						h = map[i][j];
					} else {
						continue here;
					}
				} else if (v == -1 && i+L<=N) {
					for (int ti = 1; ti < L; ti++) {
						if (map[i][j] != map[i + ti][j]) {
							continue here;
						}
					}
					n = -1;
					h = map[i][j];
					i = i + L - 2;
				} else {
					continue here;
				}
			}
			count++;
		}

		System.out.println(count);
	}
}
