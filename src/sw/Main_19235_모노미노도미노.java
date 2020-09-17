package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19235_모노미노도미노 {
	static int score = 0;
	static int[][][] map;
	static int rx = 0;

	public static void newB(int mapnum, int type, int y) {
		int x = 1;
		if (type == 1) {
			while (x + 1 < 6 && map[mapnum][x + 1][y] == 0) {
				x++;
			}
			map[mapnum][x][y] = 1;
		} else if (type == 2) {
			while (x + 1 < 6 && map[mapnum][x + 1][y] == 0 && map[mapnum][x + 1][y + 1] == 0) {
				x++;
			}
			map[mapnum][x][y] = 21;
			map[mapnum][x][y + 1] = 22;
		} else {
			while (x + 2 < 6 && map[mapnum][x + 2][y] == 0) {
				x++;
			}
			map[mapnum][x][y] = 1;
			map[mapnum][x + 1][y] = 1;
		}
//		System.out.println("map: " + mapnum);
//		for (int i = 0; i < 6; i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.print(map[mapnum][i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		while (check(mapnum)) {
			goDown(mapnum, 5);
//			System.out.println("여기는 while문");
//			System.out.println("map: " + mapnum);
//			for (int i = 0; i < 6; i++) {
//				for (int j = 0; j < 4; j++) {
//					System.out.print(map[mapnum][i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("여기까지 while문");

		}
		goDown(mapnum, checklast(mapnum));

	}

	public static void goDown(int mapnum, int dx) {
		if (dx == -1) {
			return;
		} else if (dx <= 2) {
//			System.out.println("넘었다");
			for (int y = 0; y < 4; y++) {
				for (int x = 5; x >= 2; x--) {
					map[mapnum][x][y] = map[mapnum][x - dx][y];
				}
				map[mapnum][0][y] = 0;
				map[mapnum][1][y] = 0;
			}
//			System.out.println("map: " + mapnum);
//			for (int i = 0; i < 6; i++) {
//				for (int j = 0; j < 4; j++) {
//					System.out.print(map[mapnum][i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		} else {
			int nx = rx;
			for (int x = rx - 1; x > 0; x--) {
				for (int y = 0; y < 4; y++) {
					if (map[mapnum][x][y] == 1) {
						nx = getnx(mapnum, x, y);
						map[mapnum][nx][y] = map[mapnum][x][y];
						map[mapnum][x][y] = 0;
					} else if (map[mapnum][x][y] == 21) {
						nx = Math.min(getnx(mapnum, x, y), getnx(mapnum, x, y + 1));
						map[mapnum][nx][y] = map[mapnum][x][y];
						map[mapnum][nx][y + 1] = map[mapnum][x][y + 1];
						map[mapnum][x][y] = 0;
						map[mapnum][x][++y] = 0;
					}
				}
			}
		}
	}

	public static int getnx(int mapnum, int x, int y) {
		int nx = x + 1;
		while (nx < 6 && map[mapnum][nx][y] == 0) {
			nx++;
		}
		return nx - 1;
	}

	public static int checklast(int mapnum) {
//		System.out.println("마지막 확인");
		int last = 0;
		for (int y = 0; y < 4; y++) {
			if (map[mapnum][1][y] != 0) {
				last++;
				break;
			}
		}
		if (last == 0) {
			return -1;
		}
		for (int y = 0; y < 4; y++) {
			if (map[mapnum][0][y] != 0) {
				last++;
				break;
			}
		}
		return last;
	}

	public static boolean check(int mapnum) {
		boolean full, check = false;
		for (int x = 2; x < 6; x++) {
			full = true;
			for (int y = 0; y < 4; y++) {
				if (map[mapnum][x][y] == 0) {
					full = false;
				}
			}
			if (full) {
				rx = x;
				check = true;
				score++;
				for (int y = 0; y < 4; y++) {
					map[mapnum][x][y] = 0;
				}
			}
		}
		return check;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		map = new int[2][6][4];

		int N = Integer.parseInt(st.nextToken());

		int t, x, y;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());

			t = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			newB(0, t, y);
			if (t == 3) {
				t = 2;
			} else if (t == 2) {
				t = 3;
			}
			newB(1, t, x);

		}

		int count = 0;
		for (x = 2; x < 6; x++) {
			for (y = 0; y < 4; y++) {
				if (map[0][x][y] != 0) {
					count++;
				}
				if (map[1][x][y] != 0) {
					count++;
				}
			}
		}
		System.out.println(score);
		System.out.println(count);
	}
}
