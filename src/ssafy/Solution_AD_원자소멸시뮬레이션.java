package ssafy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_AD_원자소멸시뮬레이션 {

	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		int maxx = 0,maxy = 0,minx = 2001, miny = 2001;
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			map = new int[2001][2001];
			List<int[]> nu = new ArrayList<>();
			

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken()) + 1000;
				int x = Integer.parseInt(st.nextToken()) + 1000;
				int d = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());

				nu.add(new int[] { x, y, d, k, 1 });
				map[x][y] = n * 1000 + 1;
				
				if (maxx<x) maxx = x;
				else if (minx>x) minx = x;
				
				if (maxy<y) maxy = y; 
				else if (miny>y) miny = y;

			}
			
			/*for (int i = minx;i<=maxx;i++) {
				
				for (int j = miny; j<maxy; j++) {
					System.out.print(map[i][j]/N+" ");
				}
				System.out.println();
			}
			*/
			
			/*System.out.println();
			for (int[] a : nu) {
				System.out.println(Arrays.toString(a));
			}*/

			int num = N;
			int ans = 0;
			while (num > 0) {
				List<Integer> distroy = new ArrayList<>();
				for (int i = 0; i < nu.size(); i++) {
					if (nu.get(i) == null)
						continue;
					int x = nu.get(i)[0];
					int y = nu.get(i)[1];
					int d = nu.get(i)[2];
					int k = nu.get(i)[3];
					int time = nu.get(i)[4];

					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx >= minx && ny >= miny && nx <= maxx && ny <=maxy) {
						if (map[nx][ny] > 0) {
							System.out.println("i = "+map[nx][ny]);
							if (map[nx][ny] % 1000 == time + 1 || 
									(nu.get(map[nx][ny] / 1000)!=null && (dx[nu.get(map[nx][ny] / 1000)[2]] == dx[d] * -1) && (dx[nu.get(map[nx][ny] / 1000)[2]] == dx[d] * -1)) ) {
								distroy.add(i);
								distroy.add(map[nx][ny] / 1000);
							}

						}
						map[nx][ny] = i * 1000 + (time + 1);
						nu.set(i, new int[] { nx, ny, d, k, time + 1 });
					} else {
						nu.set(i, null);
						num--;
					}
					if (map[x][y] == i * 1000 + time) {
						map[x][y] = 0;
					}
				}

				for (int i = 0; i < distroy.size(); i++) {
					if (nu.get(distroy.get(i)) == null)
						continue;
					//System.out.println(distroy.get(i));
					int[] tmp = nu.get(distroy.get(i));
					int x = tmp[0];
					int y = tmp[1];
					int k = tmp[3];
					num--;
					map[x][y] = 0;
					ans += k;
					nu.set(distroy.get(i), null);
				}

					/*System.out.println();
				for (int i = minx;i<=maxx;i++) {
					
					for (int j = miny; j<maxy; j++) {
						System.out.print(map[i][j]/N+" ");
					}
					System.out.println();
				}
				
				System.out.println(dd);
				for (int[] a : nu) {
					System.out.println(Arrays.toString(a));
				}*/
				/*
				 * System.out.println(); for (int[] a: map) {
				 * System.out.println(Arrays.toString(a)); }
				 */

			}

			System.out.println("#" + t + " " + ans);

		}

	}
}
