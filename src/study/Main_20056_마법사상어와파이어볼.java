package study;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;

import java.util.Map;

import java.util.StringTokenizer;

/*

4 2 1
1 1 5 2 2
1 4 7 1 6

4 2 2
1 1 5 2 2
1 4 7 1 6
 */
/*class Ball {
	int x;
	int y;
	int m;
	int s;
	int d;
	int count;

	public Ball(int x, int y, int m, int s, int d) {
		this.x = x;
		this.y = y;
		this.m = m;
		this.s = s;
		this.d = d;
		this.count = 1;
	}
}*/

/*
 * static int N, M, K; static Map<Integer, Ball> map; static List<Ball> bList;
 * static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }; static int[] dy = { 0, 1, 1,
 * 1, 0, -1, -1, -1 };
 * 
 * public static void move(Ball b) { int d = b.d; int nx = ((b.x + dx[b.d] *
 * (b.s % N)) + N) % N; int ny = ((b.y + dy[b.d] * (b.s % N)) + N) % N;
 * 
 * b.x = nx; b.y = ny; }
 * 
 * public static void main(String[] args) throws Exception { BufferedReader br =
 * new BufferedReader(new InputStreamReader(System.in)); StringTokenizer st =
 * new StringTokenizer(br.readLine());
 * 
 * N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); K
 * = Integer.parseInt(st.nextToken());
 * 
 * map = new HashMap<>();
 * 
 * Ball b; bList = new ArrayList<>(); for (int i = 0; i < M; i++) { st = new
 * StringTokenizer(br.readLine()); int x = Integer.parseInt(st.nextToken()) - 1;
 * int y = Integer.parseInt(st.nextToken()) - 1; int m =
 * Integer.parseInt(st.nextToken()); int s = Integer.parseInt(st.nextToken());
 * int d = Integer.parseInt(st.nextToken()); b = new Ball(x, y, m, s, d);
 * bList.add(b); }
 * 
 * for (int k = 1; k <= K; k++) { while (!bList.isEmpty()) { b =
 * bList.remove(0); move(b); int key = b.x * 100 + b.y; if
 * (!map.containsKey(key)) { map.put(key, b); } else { Ball tmpB = map.get(key);
 * tmpB.m += b.m; tmpB.s += b.s; tmpB.d %= 2; if (tmpB.d != b.d % 2) { tmpB.d =
 * 3; } tmpB.count++; } }
 * 
 * for (int i = 0; i < N; i++) { for (int j = 0; j < N; j++) { int key = i * 100
 * + j; if (map.containsKey(key)) { b = map.remove(key); if (b.count == 1) {
 * bList.add(b); } else { b.m /= 5; if (b.m == 0) { continue; } b.s /= b.count;
 * b.d = b.d == 3 ? 1 : 0;
 * 
 * for (int nb = 0; nb < 8; nb = nb + 2) { bList.add(new Ball(i, j, b.m, b.s, nb
 * + b.d)); } } } } } System.out.println(map.size()); } int answer = 0; for
 * (Ball ball : bList) { //
 * System.out.println(ball.x+" "+ball.y+" "+ball.m+" "+ball.s+" "+ball.d);
 * answer += ball.m; } System.out.println(answer); }
 */

class Ball {
	int x;
	int y;
	int m;
	int s;
	int d;
	int c;

	public Ball(int x, int y, int m, int s, int d) {
		super();
		this.x = x;
		this.y = y;
		this.m = m;
		this.s = s;
		this.d = d;
		this.c = 1;
	}

}

public class Main_20056_마법사상어와파이어볼 {
	static Ball[][] map;
	static int N, K, M;
	static List<Ball> list;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void move(Ball b) {
		int nx = b.x + dx[b.d] * (b.s % N);
		nx = (nx + N) % N;
		int ny = b.y + dy[b.d] * (b.s % N);
		ny = (ny + N) % N;

		b.x = nx;
		b.y = ny;

	}

	public static String getD(int d) {
		switch(d) {
		case 0:
			return "↑";
		case 1:
			return "↗";
		case 2:
			return "→";
		case 3:
			return "↘";
		case 4:
			return "↓";
		case 5:
			return "↙";
		case 6:
			return "←";
		case 7:
			return "↖";
			
		}
		return "";
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		list = new ArrayList<Ball>();
		map = new Ball[N][N];
		
		Ball b;

		int x, y, m, s, d;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			m = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			b = new Ball(x, y, m, s, d);

			list.add(b);
		}

		Ball tmpB;
		while (K > 0) {
			K--;
			while (!list.isEmpty()) {
				b = list.remove(0);
				move(b);
				if (map[b.x][b.y] != null) {
					tmpB = map[b.x][b.y];
					tmpB.m += b.m;
					tmpB.s += b.s;
					if (tmpB.d != 3) {
						if (tmpB.d % 2 != b.d % 2) {
							tmpB.d = 3;
						}
					}
					tmpB.c++;
				} else {
					map[b.x][b.y] = b;
				}
			}
//			System.out.println("k번째");
//			for(int i = 0; i<N; i++) {
//				System.out.println();
//				for(int j = 0; j<N; j++) {
//					if(map[i][j]==null) {
//						System.out.print("[0 0 0] ");
//					}else {
//						b = map[i][j];
//						System.out.print("["+b.m+" "+b.s+" "+getD(b.d)+"] ");
//					}
//				}
//			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(map[i][j]!=null) {
						b = map[i][j];
						if(b.c>1) {
							m = b.m/5;
							if(m==0) {
								continue;
							}
							s = b.s/b.c;
							d = b.d==3?1:0;
							for(int nd = 0; nd<8; nd = nd+2) {
								tmpB = new Ball(i,j,m, s, nd+d);
								list.add(tmpB);
							}
						}else {
							list.add(b);
						}
						map[i][j] = null;
					}
				}
			}
//			System.out.println(list.size());
//			
//			for(int i = 0 ;i <list.size(); i++) {
//				b = list.get(i);
//				System.out.println();
//				System.out.print("["+b.m+" "+b.s+" "+getD(b.d)+"] ");
//			}
		}
		
		m = 0;
		for(int i = 0; i<list.size();i++) {
			m+=list.get(i).m;
		}
		System.out.println(m);
	}

}
