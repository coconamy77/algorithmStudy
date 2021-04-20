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

class Ball {

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

 

}

 

public class Main_20056_마법사상어와파이어볼 {

	static int N, M, K;

	static Map<Integer, Ball> map;

	static List<Ball> bList;

	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };

	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

 

	public static void move(Ball b) {

		int d = b.d;

		int nx = ((b.x + dx[b.d] * b.s) + N) % N;

		int ny = ((b.y + dy[b.d] * b.s) + N) % N;

 

		b.x = nx;

		b.y = ny;

	}

 

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

 

		N = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(st.nextToken());

		K = Integer.parseInt(st.nextToken());

 

		map = new HashMap<>();

 

		Ball b;

		bList = new ArrayList<>();

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken())-1;

			int y = Integer.parseInt(st.nextToken())-1;

			int m = Integer.parseInt(st.nextToken());

			int s = Integer.parseInt(st.nextToken());

			int d = Integer.parseInt(st.nextToken());

			b = new Ball(x, y, m, s, d);

 

			bList.add(b);

		}

 

		for (int k = 1; k <= K; k++) {

			while (!bList.isEmpty()) {

				b = bList.remove(0);

 

				move(b);

				int key = b.x * 100 + b.y;

				if (!map.containsKey(key)) {

					map.put(key, b);

				}else{

					Ball tmpB = map.get(key);

					tmpB.m += b.m;

					tmpB.s += b.s;

					tmpB.d %= 2;

					if (tmpB.d != b.d % 2) {

						tmpB.d = 3;

					}

					tmpB.count++;

				}

			}

 

			for (int i = 0; i < N; i++) {

				for (int j = 0; j < N; j++) {

					int key = i * 100 + j;

					if (map.containsKey(key)) {

						b = map.remove(key);

						if (b.count == 1) {

							bList.add(b);

						} else {

							b.m /= 5;

							b.s /= b.count;

							b.d = b.d == 3 ? 1 : 0;

							for (int nb = 0; nb < 8; nb = nb + 2) {

								bList.add(new Ball(i, j, b.m, b.s, nb + b.d));

							}

						}

					}

				}

			}

		}

		int answer = 0;

		for(Ball ball: bList){

			//System.out.println(ball.x+" "+ball.y+" "+ball.m+" "+ball.s+" "+ball.d);

			answer+=ball.m;

		}

		

		System.out.println(answer);

	}

}

