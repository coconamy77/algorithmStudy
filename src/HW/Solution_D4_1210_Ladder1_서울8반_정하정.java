package HW;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1210_Ladder1_서울8반_정하정 {

	static int[] dx = { 0, -1, 0 };
	static int[] dy = { 1, 0, -1 };

	static int getWay(int[][] a, int x, int y, int w) {
		if (x == 0)
			return y;
		switch (w) {
		case 1:

			if (y + dy[0] < a.length && a[x + dx[0]][y + dy[0]] == 1)
				return getWay(a, x + dx[0], y + dy[0], 0);
			else if (y + dy[2] > 0 && a[x + dx[2]][y + dy[2]] == 1)
				return getWay(a, x + dx[2], y + dy[2], 2);
			else
				return getWay(a, x + dx[1], y + dy[1], 1);
		case 0:
		case 2:
			if (y + dy[w] > 0 && y + dy[w] < a.length&& a[x + dx[w]][y + dy[w]] == 1) {
				return getWay(a, x + dx[w], y + dy[w], w);

			} else
				return getWay(a, x + dx[1], y + dy[1], 1);
		}
		return 0;

	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1210_Ladder1.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 0;

		for (; T < 10;) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T = Integer.parseInt(st.nextToken());
			int[][] lad = new int[100][100];
			int y2 = 0;
			
			for (int x = 0; x < 99; x++) {
				st = new StringTokenizer(br.readLine());
				
				for (int y = 0; y < 100; y++) {
					lad[x][y] = Integer.parseInt(st.nextToken());
					
				}
			}
			st = new StringTokenizer(br.readLine());
			for (int y = 0; y < 100; y++) {
				lad[99][y] = Integer.parseInt(st.nextToken());

				if (lad[99][y] == 2) {
					y2 = y;
				}
			}
			int ans = getWay(lad, 98, y2, 1);

			System.out.println("#" + T + " " + ans);

		}

	}

}
