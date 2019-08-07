package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dice_14499 {

	static int[][] map;
	static int x, y;
	static int ix = 0, iy = 0;
	static int[] diceX = { 0, 0, 0, 0 };
	static int[] diceY = { 0, 0, 0, 0 };

	static void move(int order) {
		//System.out.println("x = "+x+", y = "+y+", order = "+order);
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };

		int nx = x + dx[order - 1];
		int ny = y + dy[order - 1];

		if (nx > map.length - 1 || nx < 0 || ny > map[0].length - 1 || ny < 0) {
			return;
		}

		x = nx;
		y = ny;
		boolean isX = false;
		switch (order) {
		case 1:
			if (iy == 3)
				iy = 0;
			else
				iy++;

			isX = false;
			break;
		case 2:
			if (iy == 0)
				iy = 3;
			else
				iy--;
			isX = false;

			break;
		case 3:
			if (ix == 0)
				ix = 3;
			else
				ix--;
			isX = true;
			break;
		case 4:
			if (ix == 3)
				ix = 0;
			else
				ix++;
			isX = true;
		}

		if (map[x][y] == 0) {
			if (isX) {
				map[x][y] = diceX[ix];
				diceY[iy] = diceX[ix];
				
			} else {
				map[x][y] = diceY[iy];
				diceX[ix] = diceY[iy];
				
			}
		} else {
			diceX[ix] = map[x][y];
			diceY[iy] = map[x][y];
			map[x][y] = 0;
		}
		if (isX) {
			diceY[(iy + 2) % 4] = diceX[(ix + 2) % 4];
		}else {
			diceX[(ix + 2) % 4] = diceY[(iy + 2) % 4];
		}
		
		
		/*for (int[] a : map) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println("diceX,index = "+ix+", "+ Arrays.toString(diceX));
		System.out.println("diceY,index = "+iy+", "+ Arrays.toString(diceY));*/
		
		System.out.println(diceX[(ix + 2) % 4]);

	}

	public static void main(String[] args) throws Exception {

		// map 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());

			}
		}
		st = new StringTokenizer(br.readLine());

		// int[] order = new int[K];
		for (int i = 0; i < K; i++) {
			move(Integer.parseInt(st.nextToken()));
		}

	}
}
