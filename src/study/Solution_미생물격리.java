package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class MicOr {
	int n, d;
	int his;

	public MicOr(int n, int d) {
		super();
		this.n = n;
		this.his = n;
		this.d = d;
	}

	void changeD() {
		switch (d) {
		case 0:
			d = 1;
			break;
		case 1:
			d = 0;
			break;
		case 2:
			d = 3;
			break;
		case 3:
			d = 2;
			break;
		}
	}

	void makeH() {
		n /= 2;
	}

	void sumN(int sum) {
		this.n += sum;
	}
}

public class Solution_미생물격리 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static MicOr[][][] map;
	static int T, N, M, K;

	static void move(int x, int y, int m) {
		MicOr tmp = map[m][x][y];
		int nx = x + dx[tmp.d];
		int ny = y + dy[tmp.d];
		int nm = (m + 1) % 2;

		if (nx == 0 || ny == 0 || nx == N - 1 || ny == N - 1) {
			tmp.makeH();
			tmp.changeD();
			if (tmp.n==0) {
				map[m][x][y] = null;
				return;
			}
		}

		if (map[nm][nx][ny] == null) {
			map[nm][nx][ny] = tmp;
			map[nm][nx][ny].his = tmp.n;
		} else {
			if (map[nm][nx][ny].his > tmp.n) {
				map[nm][nx][ny].sumN(tmp.n);
			} else {
				tmp.sumN(map[nm][nx][ny].n);
				map[nm][nx][ny] = tmp;
			}
		}
		map[m][x][y] = null;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <=T; t++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new MicOr[2][N][N];

			int x, y, n, d;
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());

				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				n = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken()) - 1;

				map[0][x][y] = new MicOr(n, d);
			}
			
			
			//System.out.println(K);
			for (int m = 0; m < M; m++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[m % 2][i][j] != null) {
							move(i, j, m % 2);
						}
					}

				}
//				System.out.println("여기는 말이죠오오ㅗ오오오오오옹 "+m);
//				for (int h = 0;h<N; h++) {
//					System.out.println();
//					for (int w = 0; w<N; w++) {
//						if (map[(m+1)%2][h][w]==null) {
//							System.out.print(0+","+0+" ");
//						}else {
//							System.out.print(map[(m+1)%2][h][w].n+","+map[(m+1)%2][h][w].d+" ");
//						}
//					}
//				}

			}

			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[M % 2][i][j] != null) {
						sum += map[M % 2][i][j].n;
					}
				}
			}

			System.out.println("#" + t + " " + sum);

		}

	}
}



/*
 * 
1
10 17 46
7 5 724 2
7 7 464 3
2 2 827 2
2 4 942 4
4 5 604 4
7 2 382 1
6 5 895 3
8 7 538 4
6 1 299 4
4 7 811 4
3 6 664 2
6 8 868 2
7 6 859 2
4 6 778 2
5 4 842 3
1 3 942 1
1 1 805 3
3 2 350 3
2 5 623 2
5 3 840 1
7 1 308 4
1 8 323 3
2 3 82 3
2 6 115 2
8 3 930 1
6 2 72 1
2 1 290 3
4 8 574 4
8 5 150 3
8 2 287 2
2 8 909 2
2 7 588 2
7 3 30 3
5 8 655 3
3 8 537 1
4 2 350 3
5 6 199 1
5 5 734 2
3 3 788 1
8 4 893 1
1 4 421 4
6 3 616 2
1 2 556 4
7 8 8 1
5 2 702 2
4 4 503 3
 * 
 * 
 * */
