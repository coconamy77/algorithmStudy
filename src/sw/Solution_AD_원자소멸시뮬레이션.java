package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_AD_원자소멸시뮬레이션 {

	static int[][] map;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_ad.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		for (int t = 1; t <= T; t++) {
			int maxx = 0, maxy = 0, minx = 4001, miny = 4001;

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			map = new int[4001][4001];
			int[][] nu = new int[N][5];

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				int y = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int x = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int d = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());

				nu[n] = new int[] { x, y, d, k, 1 };
				map[x][y] = n + 1;
				if (maxx < x)
					maxx = x;
				if (minx > x)
					minx = x;

				if (maxy < y)
					maxy = y;
				if (miny > y)
					miny = y;
				//System.out.println("max = " + maxx + " " + maxy + ", min = " + minx + " " + miny);
			}
			/*System.out.println();
			for (int i = minx; i <= maxx; i++) {
				System.out.println();
				for (int j = miny; j <= maxy; j++) {
					System.out.print(map[i][j] + " ");
				}
			}*/
			int num = N;
			int ans = 0;
			while (num > 1) {
				List<Integer> distroy = new ArrayList<>();
				for (int i = 0; i < N; i++) {
					if (nu[i] == null || distroy.contains(i))
						continue;
					int x = nu[i][0];
					int y = nu[i][1];
					int d = nu[i][2];
					int time = nu[i][4];

					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx >= minx && ny >= miny && nx <= maxx && ny <= maxy) {
						// System.out.println("여기");
						if (map[nx][ny] > 0) {
							//System.out.println("큰거");
							int tmp = map[nx][ny] - 1;
							if (nu[tmp][4] == time + 1) {
								distroy.add(i);
								distroy.add(tmp);
							}

						}
						map[nx][ny] = i + 1;
						nu[i][0] = nx;
						nu[i][1] = ny;
						nu[i][4] = time + 1;
					} else {
						nu[i] = null;
						num--;
					}
					if (map[x][y] - 1 == i) {
						map[x][y] = 0;
					}
				}
				// System.out.println(distroy);
				for (int i = 0; i < distroy.size(); i++) {
					int tmp = distroy.get(i);
					if (nu[tmp] == null)
						continue;
					int x = nu[tmp][0];
					int y = nu[tmp][1];
					int k = nu[tmp][3];
					num--;
					map[x][y] = 0;
					ans += k;
					//System.out.println("사라져! = " + distroy.get(i) + " 에너지 = " + k);
					nu[tmp] = null;
				}
				/*System.out.println();
				for (int i = minx; i <= maxx; i++) {
					System.out.println();
					for (int j = miny; j <= maxy; j++) {
						System.out.print(map[i][j] + " ");
					}
				}*/

			}

			System.out.println("#" + t + " " + ans);

		}

	}
}
