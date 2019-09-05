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
			int nd = (td+d)%4;
			x = x+dx[nd];
			y = y+dy[nd];
			map[y][x] = true;
		}
	}

	static int[] getDir(int g) {
		if (dp.size()>g) {
			return dp.get(g);
		}
		int[] dir = new int[(int) Math.pow(2, g)];
		int[] dirbefore = getDir(g - 1);
		int len = dirbefore.length;
		for (int i = 0; i < len; i++) {
			dir[i] = dirbefore[i];
			dir[i + len] = (dirbefore[len-1-i]+1)%4;
		}
		dp.add(dir);
		return dp.get(g);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		dp.add(new int[] { 0 });

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			draw(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

		}
		int count = 0;
		for (int i = 0; i<100; i++) {
			for (int j = 0; j<100;j++) {
				if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}