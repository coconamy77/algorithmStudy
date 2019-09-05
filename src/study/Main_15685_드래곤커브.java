package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15685_드래곤커브 {

	static boolean[][] map = new boolean[101][101];
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static List<int[]> dp = new ArrayList<>();

	static void draw(int x, int y, int d, int g) {
		int[] dir = getDir(g);
		
		map[y][x] = true;
		for (int td: dir) {
			int nd = td+d;
			int nx = x+dx[nd];
			int ny = y+dy[nd];
			
			map[ny][nx] = true;
			
			System.out.println("x = " + x + ", y = " + y);
			for (int i = 0; i <= 6; i++) {
				for (int j = 0; j <= 6; j++) {
					if (map[i][j])
						System.out.print(1 + " ");
					else
						System.out.print(0 + " ");
				}
				System.out.println();
			}
		}
	}

	static int[] getDir(int g) {
		System.out.println(g);
		if (dp.size()>g) {
			return dp.get(g);
		}
		System.out.println("왜?"+((int) Math.pow(2, g)+1));
		int[] dir = new int[(int) Math.pow(2, g)+1];
		int[] dirbefore = getDir(g - 1);

		for (int i = 0; i < dirbefore.length; i++) {
			dir[i] = dirbefore[i];
			dir[i + dirbefore.length-1] = (dirbefore[dirbefore.length-1-i]+1)%4;
		}
		
		dp.add(dir);
		return dp.get(g);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			dp.add(new int[] { 0 });
			draw(x, y, d, g);

		}

		for (int i = 0; i < 6; i++) {
			System.out.println();
			for (int j = 0; j < 6; j++) {
				System.out.print(map[i][j]);
			}
		}

	}
}
