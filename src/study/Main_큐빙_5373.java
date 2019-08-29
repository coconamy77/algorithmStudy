package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_큐빙_5373 {

	static int[][][] cube = new int[6][3][3];
	static int[][] w = { { 4, 3, 5, 2 }, { 0, 5, 1, 4 }, { 0, 2, 1, 3 } };

	// 0:위(흰) 1:아래(노) 2:왼쪽(초) 3:오른쪽(파) 4:앞(빨) 5:뒤(오)
	static void spin(int i, int d) {
		// i = 바꾸는 면-> w[i/2], 어느쪽? -> (i%2)*2(0 or 2)
		// d = 방향? -> -1 or 1
		int[] tmp = null;
		switch (i / 2) {
		case 0:
			if (d > 0) {
				int j = (i % 2) * 3;
				tmp = cube[w[i / 2][j]][(i % 2) * 2];
				cube[w[i / 2][j]][(i % 2) * 2] = cube[w[i / 2][j + 1]][(i % 2) * 2];
				j += i*-1;
				cube[w[i / 2][j]][(i % 2) * 2] = cube[w[i / 2][j + 1]][(i % 2) * 2];
				j += i*-1;
				cube[w[i / 2][j]][(i % 2) * 2] = cube[w[i / 2][j + 1]][(i % 2) * 2];
				j += i*-1;
				cube[w[i / 2][j]][(i % 2) * 2] = tmp;

			} else {
				int j = (i % 2-1) * -3;
				tmp = cube[w[i / 2][j]][(i % 2) * 2];
				cube[w[i / 2][j]][(i % 2) * 2] = cube[w[i / 2][j + 1]][(i % 2) * 2];
				j += i*-1;
				cube[w[i / 2][j]][(i % 2) * 2] = cube[w[i / 2][j + 1]][(i % 2) * 2];
				j += i*-1;
				cube[w[i / 2][j]][(i % 2) * 2] = cube[w[i / 2][j + 1]][(i % 2) * 2];
				j += i*-1;
				cube[w[i / 2][j]][(i % 2) * 2] = tmp;
			}

			/*
			 * for (int j = 0; j<4;j++) { if (j==0) { tmp = cube[w[i/2][j]][0];
			 * cube[w[i/2][j]][0] = cube[w[i/2][j+1]][0]; }else if (j==3) {
			 * cube[w[i/2][j]][0] = tmp; }else { cube[w[i/2][j]][0] = cube[w[i/2][j+1]][0];
			 * } }
			 */
			break;
		case 1:
			for (int j = 3; j <= 0; j--) {
				if (j == 3) {
					tmp = cube[w[i / 2][j]][0];
					cube[w[i / 2][j]][0] = cube[w[i / 2][j - 1]][0];
				} else if (j == 0) {
					cube[w[i / 2][j]][0] = tmp;
				} else {
					cube[w[i / 2][j]][0] = cube[w[i / 2][j - 1]][0];
				}
			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					cube[i][j][0] = i;
					cube[i][j][1] = i;
					cube[i][j][2] = i;
				}
			}
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				String order = st.nextToken();

				switch (order.charAt(0)) {
				case 'U':
					if (order.charAt(1) == '+') {

					}

				case 'D':
				case 'L':
				case 'R':
				case 'F':
				case 'B':

				}

			}

		}

	}
}
