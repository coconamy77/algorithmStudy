package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Box {
	int time;
	int sname;
	Shark shark;

	public Box(int time, Shark shark) {
		this.time = time;
		this.shark = shark;
		this.sname = shark.name;
	}

	public boolean isGone(int now, int k) {
		if (now - time == k) {
			return true;
		} else {
			return false;
		}
	}

	public void sharkGone() {
		this.shark = null;
	}

	public boolean isShark() {
		return this.shark == null ? false : true;
	}

	public void newS(int time, Shark shark) {
		this.time = time;
		this.shark = shark;
	}
}

class Shark {
	int name;
	int d;
	int x, y;
	int[][] da = new int[4][4];

	public Shark(int name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public void setD(int d) {
		this.d = d;
	}

	public void setDa(int i, int j, int d) {
		da[i][j] = d;
	}

	public int getD(int j) {
		return da[this.d][j];
	}
}

public class Main_19237_어른상어 {

	static Box[][] map;
	static Shark[] shark;
	static int N, M, K;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new Box[N][N];
		shark = new Shark[M + 1];
		int left = M;

		int tmp = 0;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				tmp = Integer.parseInt(st.nextToken());
				if (tmp == 0) {
					continue;
				} else {
					shark[tmp] = new Shark(tmp, n, m);
					map[n][m] = new Box(0, shark[tmp]);
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int m = 1; m <= M; m++) {
			shark[m].setD(Integer.parseInt(st.nextToken()) - 1);
		}
		for (int k = 1; k < M + 1; k++) {
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					shark[k].setDa(i, j, Integer.parseInt(st.nextToken()) - 1);
				}
			}
		}
		for (int i = 1; i < M + 1; i++) {
			System.out.println("상어 " + i);
			for (int j = 0; j < 4; j++) {
				System.out.print(j + " : ");
				for (int k = 0; k < 4; k++) {
					System.out.print(shark[i].da[j][k] + " ");
				}
				System.out.println();
			}
		}

		int k = 0;
		int sx, sy, nx, ny, nd;
		Shark tmps;
		int check = 0;
		while (left > 1 && k <= 1000) {
			for (int s = 1; s <= M; s++) {
				if (shark[s] == null) {
					continue;
				}
				check = 0;
				tmps = shark[s];
				sx = tmps.x;
				sy = tmps.y;
				map[sx][sy].sharkGone();
				for (int d = 0; d < 4; d++) {
					nd = tmps.getD(d);
					nx = sx + dx[nd];
					ny = sy + dy[nd];

					if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
						if (map[nx][ny] == null) {
							tmps.x = nx;
							tmps.y = ny;
							tmps.setD(nd);
							check = -1;
							break;
						} else if (check == 0 && map[nx][ny].sname == s) {
							check = nd;
						}
					}
				}

				if (check != -1) {
					nd = check;
					tmps.setD(nd);
					tmps.x = sx + dx[nd];
					tmps.y = sy + dy[nd];
				}
			}

			k++;
			for (int s = 1; s <= M; s++) {
				if (shark[s] == null) {
					continue;
				}
				tmps = shark[s];
				sx = tmps.x;
				sy = tmps.y;
				if (map[sx][sy] == null) {
					map[sx][sy] = new Box(k, tmps);
				} else {
					if (map[sx][sy].isShark()) {
						shark[s] = null;
						left--;
					} else {
						map[sx][sy].newS(k, tmps);
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == null) {
						continue;
					}
					if (k - map[i][j].time == K) {
						map[i][j] = null;
					}
				}
			}

//			System.out.println("현재시간: " + k+", 마리수: "+M);
//			for (int i = 0; i < N; i++) {
//				System.out.println();
//				for (int j = 0; j < N; j++) {
//					if (map[i][j] == null) {
//						System.out.print("[00, 0] ");
//					} else if (map[i][j].isShark()) {
//						System.out.print("[+" + map[i][j].sname + ", "+map[i][j].time+"] ");
//					} else {
//						System.out.print("[-" + map[i][j].sname + ", "+map[i][j].time+"] ");
//						
//					}
//				}
//			}
//			 System.out.println(k);
		}
		// System.out.println(M);
		if (k > 1000)
			k = -1;
		System.out.println(k);
	}
}
