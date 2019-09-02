package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_큐빙_5373 {

	static char[] color = {'w','y','g','b','r','o'};
	static int[][][] cube = new int[6][3][3];
	static int[][] w = { { 4, 3, 5, 2 }, { 0, 5, 1, 4 }, { 0, 2, 1, 3 } };

	// 0:위(흰) 1:아래(노) 2:왼쪽(초) 3:오른쪽(파) 4:앞(빨) 5:뒤(오)
	static void spin(int i, int d) {
		System.out.println("돌리기 전");
		for (int[] a: cube[i]) {
			for ( int aa: a) {
				System.out.print(color[aa]);
			}
			System.out.println();
		}
		// d = 방향? -> -1 or 1
		switch (i * d) {
		case 0:
			if (d > 0) {
				System.out.println(" 위 시계");
				int[] tmpa = cube[w[0][0]][0];
				cube[w[0][0]][0] = cube[w[0][1]][0];
				cube[w[0][1]][0] = cube[w[0][2]][2];
				cube[w[0][2]][2] = cube[w[0][3]][0];
				cube[w[0][3]][0] = tmpa;

				for (int j = 0; j < 2; j++) {
					int tmp = cube[i][j][0];
					cube[i][j][0] = cube[i][2][j];
					cube[i][2][j] = cube[i][2 - j][2];
					cube[i][2 - j][2] = cube[i][0][2 - j];
					cube[i][0][2 - j] = tmp;
				}
			} else {
				System.out.println(" 위 반시계");
				int[] tmpa = cube[w[0][3]][0];
				cube[w[0][3]][0] = cube[w[0][2]][2];
				cube[w[0][2]][2] = cube[w[0][1]][0];
				cube[w[0][1]][0] = cube[w[0][0]][0];
				cube[w[0][0]][0] = tmpa;
				for (int j = 0; j < 2; j++) {
					int tmp = cube[i][0][2 - j];
					cube[i][0][2 - j] = cube[i][2 - j][2];
					cube[i][2 - j][2] = cube[i][2][j];
					cube[i][2][j] = cube[i][j][0];
					cube[i][j][0] = tmp;
				}
			}
			break;
		case 1:
			System.out.println("아래 시계");
			int[] tmpa = cube[w[0][3]][2];
			cube[w[0][3]][2] = cube[w[0][2]][0];
			cube[w[0][2]][0] = cube[w[0][1]][2];
			cube[w[0][1]][2] = cube[w[0][0]][2];
			cube[w[0][0]][2] = tmpa;
			for (int j = 0; j < 2; j++) {
				int tmp = cube[i][j][0];
				cube[i][j][0] = cube[i][2][j];
				cube[i][2][j] = cube[i][2 - j][2];
				cube[i][2 - j][2] = cube[i][0][2 - j];
				cube[i][0][2 - j] = tmp;
			}
			break;
		case -1:
			System.out.println("아래  반시계");
			tmpa = cube[w[0][0]][2];
			cube[w[0][0]][2] = cube[w[0][1]][2];
			cube[w[0][1]][2] = cube[w[0][2]][0];
			cube[w[0][2]][0] = cube[w[0][3]][2];
			cube[w[0][3]][2] = tmpa;
			for (int j = 0; j < 2; j++) {
				int tmp = cube[i][0][2 - j];
				cube[i][0][2 - j] = cube[i][2 - j][2];
				cube[i][2 - j][2] = cube[i][2][j];
				cube[i][2][j] = cube[i][j][0];
				cube[i][j][0] = tmp;
			}
			break;
		case 2:
			System.out.println("왼 시계");
			for (int j = 0; j < 3; j++) {
				int tmp = cube[w[1][0]][j][0];
				cube[w[1][0]][j][0] = cube[w[1][1]][j][0];
				cube[w[1][1]][j][0] = cube[w[1][2]][j][0];
				cube[w[1][2]][j][0] = cube[w[1][3]][j][0];
				cube[w[1][3]][j][0] = tmp;
			}
			for (int j = 0; j < 2; j++) {
				int tmp = cube[i][j][0];
				cube[i][j][0] = cube[i][2][j];
				cube[i][2][j] = cube[i][2 - j][2];
				cube[i][2 - j][2] = cube[i][0][2 - j];
				cube[i][0][2 - j] = tmp;
			}
			break;
		case -2:
			System.out.println("왼 반시계");
			for (int j = 0; j < 3; j++) {
				int tmp = cube[w[1][3]][j][0];
				cube[w[1][3]][j][0] = cube[w[1][2]][j][0];
				cube[w[1][2]][j][0] = cube[w[1][1]][j][0];
				cube[w[1][1]][j][0] = cube[w[1][0]][j][0];
				cube[w[1][0]][j][0] = tmp;
			}
			for (int j = 0; j < 2; j++) {
				int tmp = cube[i][0][2 - j];
				cube[i][0][2 - j] = cube[i][2 - j][2];
				cube[i][2 - j][2] = cube[i][2][j];
				cube[i][2][j] = cube[i][j][0];
				cube[i][j][0] = tmp;
			}
			break;
		case 3:
			System.out.println("오른 시계");
			for (int j = 0; j < 3; j++) {
				int tmp = cube[w[1][3]][j][2];
				cube[w[1][3]][j][2] = cube[w[1][2]][j][2];
				cube[w[1][2]][j][2] = cube[w[1][1]][j][2];
				cube[w[1][1]][j][2] = cube[w[1][0]][j][2];
				cube[w[1][0]][j][2] = tmp;
			}
			for (int j = 0; j < 2; j++) {
				int tmp = cube[i][j][0];
				cube[i][j][0] = cube[i][2][j];
				cube[i][2][j] = cube[i][2 - j][2];
				cube[i][2 - j][2] = cube[i][0][2 - j];
				cube[i][0][2 - j] = tmp;
			}
			break;
		case -3:
			System.out.println("오른 반시계");
			for (int j = 0; j < 3; j++) {
				int tmp = cube[w[1][0]][j][2];
				cube[w[1][0]][j][2] = cube[w[1][1]][j][2];
				cube[w[1][1]][j][2] = cube[w[1][2]][j][2];
				cube[w[1][2]][j][2] = cube[w[1][3]][j][2];
				cube[w[1][3]][j][2] = tmp;
			}
			for (int j = 0; j < 2; j++) {
				int tmp = cube[i][0][2 - j];
				cube[i][0][2 - j] = cube[i][2 - j][2];
				cube[i][2 - j][2] = cube[i][2][j];
				cube[i][2][j] = cube[i][j][0];
				cube[i][j][0] = tmp;
			}
			break;
		case 4:
			System.out.println("앞 시계");
			for (int j = 0; j < 3; j++) {
				int tmp = cube[w[2][0]][2][j];
				cube[w[2][0]][2][j] = cube[w[2][1]][2 - j][2];
				cube[w[2][1]][2 - j][2] = cube[w[2][2]][0][2 - j];
				cube[w[2][2]][0][2 - j] = cube[w[2][3]][j][0];
				cube[w[2][3]][j][0] = tmp;
			}
			for (int j = 0; j < 2; j++) {
				int tmp = cube[i][j][0];
				cube[i][j][0] = cube[i][2][j];
				cube[i][2][j] = cube[i][2 - j][2];
				cube[i][2 - j][2] = cube[i][0][2 - j];
				cube[i][0][2 - j] = tmp;
			}
			break;
		case -4:
			System.out.println("앞 반시계");
			for (int j = 0; j < 3; j++) {
				int tmp = cube[w[2][3]][j][0];
				cube[w[2][3]][j][0] = cube[w[2][2]][0][2 - j];
				cube[w[2][2]][0][2 - j] = cube[w[2][1]][2 - j][2];
				cube[w[2][1]][2 - j][2] = cube[w[2][0]][2][j];
				cube[w[2][0]][2][j] = tmp;
			}
			for (int j = 0; j < 2; j++) {
				int tmp = cube[i][0][2 - j];
				cube[i][0][2 - j] = cube[i][2 - j][2];
				cube[i][2 - j][2] = cube[i][2][j];
				cube[i][2][j] = cube[i][j][0];
				cube[i][j][0] = tmp;
			}
			break;
		case 5:
			System.out.println("뒤 시계");
			for (int j = 0; j < 3; j++) {
				int tmp = cube[w[2][3]][j][2];
				cube[w[2][3]][j][2] = cube[w[2][2]][2][2 - j];
				cube[w[2][2]][2][2 - j] = cube[w[2][1]][2 - j][0];
				cube[w[2][1]][2 - j][0] = cube[w[2][0]][0][j];
				cube[w[2][0]][0][j] = tmp;
			}
			for (int j = 0; j < 2; j++) {
				int tmp = cube[i][j][0];
				cube[i][j][0] = cube[i][2][j];
				cube[i][2][j] = cube[i][2 - j][2];
				cube[i][2 - j][2] = cube[i][0][2 - j];
				cube[i][0][2 - j] = tmp;
			}
			break;
		case -5:
			System.out.println("뒤 반시계");
			for (int j = 0; j < 3; j++) {
				int tmp = cube[w[2][0]][0][j];
				cube[w[2][0]][0][j] = cube[w[2][1]][2 - j][0];
				cube[w[2][1]][2 - j][0] = cube[w[2][2]][2][2 - j];
				cube[w[2][2]][2][2 - j] = cube[w[2][3]][j][2];
				cube[w[2][3]][j][2] = tmp;
			}
			for (int j = 0; j < 2; j++) {
				int tmp = cube[i][0][2 - j];
				cube[i][0][2 - j] = cube[i][2 - j][2];
				cube[i][2 - j][2] = cube[i][2][j];
				cube[i][2][j] = cube[i][j][0];
				cube[i][j][0] = tmp;
			}
			break;
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
			int mm  = 0;
			st = new StringTokenizer(br.readLine());
			
			for (int n = 0; n < N; n++) {
				String order = st.nextToken();
				
				switch (order.charAt(0)) {
				case 'U':
					mm = 0;
					if (order.charAt(1) == '+') {
						spin(0, 1);
					} else
						spin(0, -1);
					break;
				case 'D':
					mm = 1;
					if (order.charAt(1) == '+') {
						spin(1, 1);
					} else
						spin(1, -1);
					break;
				case 'L':
					mm = 2;
					if (order.charAt(1) == '+') {
						spin(2, 1);
					} else
						spin(2, -1);
					break;
				case 'R':
					mm = 3;
					if (order.charAt(1) == '+') {
						spin(3, 1);
					} else
						spin(3, -1);
					break;
				case 'F':
					mm = 4;
					if (order.charAt(1) == '+') {
						spin(4, 1);
					} else
						spin(4, -1);
					break;
				case 'B':
					mm = 5;
					if (order.charAt(1) == '+') {
						spin(5, 1);
					} else
						spin(5, -1);
					break;
				}
				System.out.println(order);
				for (int[] a: cube[mm]) {
					for ( int aa: a) {
						System.out.print(color[aa]);
					}
					System.out.println();
				}
			}
			
			
			
		}

	}
}

/*
4
1
L-
2
F+ B+
4
U- D- L+ R+
10
L- U- L+ U- L- U- U- L+ U+ U+

6
4
L+ R+ U+ U-
4
L+ R+ D+ D-
4
U+ D+ L+ L-
4
U+ D+ R+ R-
4
L+ R+ F+ F-
4
L+ R+ B+ B-


*/
