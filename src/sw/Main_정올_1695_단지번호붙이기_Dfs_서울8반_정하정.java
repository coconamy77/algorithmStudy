package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_정올_1695_단지번호붙이기_Dfs_서울8반_정하정 {
	static int[][] map;
	static boolean[][] vst;
	static int[] ans;

	static int dfs(int i, int j) {
		int count = 1;
		vst[i][j] = true;
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];

			if (nx >= 0 && ny >= 0 && nx < map.length && ny < map.length && !vst[nx][ny] && map[nx][ny] != 0) {

				count += dfs(nx, ny);
			}
		}
		return count;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		vst = new boolean[N][N];
		ans = new int[N * N];
		for (int i = 0; i < N; i++) {
			String st = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = st.charAt(j) - '0';
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!vst[i][j] && map[i][j] == 1) {
					ans[count++] = dfs(i, j);
				}
			}
		}

		System.out.println(count);
		Arrays.sort(ans);
		for (int i = 0; i < ans.length; i++) {
			if (ans[i] != 0) {
					System.out.println(ans[i]);

			}

		}

	}
}
