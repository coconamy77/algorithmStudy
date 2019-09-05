
package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_미세먼지안녕_17144 {

	static int[][] map;
	static int upx = 0;
	static int upy = 0;
	static int downx = 0;
	static int downy = 0;
	static int[] dx = {  -1, 0, 1,0 };
	static int[] dy = {  0, 1, 0,-1 };

	static void upMove() { // 공기청정기 위에 이동
		
		int d = 0;
		int x = upx + dx[d];
		int y = upy + dy[d];

		while (true) {// 이동
			int tmpx = x + dx[d]; // 뒤에부터 채워넣기, 전에 값이 있으면 그거 그냥 넣으면 됨
			int tmpy = y + dy[d];

			if (tmpx >= 0 && tmpy >= 0 && tmpx <= upx && tmpy < map[0].length) {
				if (tmpx == upx && tmpy == upy) {
					map[x][y] = 0;
					break;
				} else {
					map[x][y] = map[tmpx][tmpy];
					x = tmpx;
					y = tmpy;
				}
			} else {// 방향바꿔주기
				d++;
			}
		}
	}

	static void downMove() {// 청정기 아랫부분(똑같)
	
		int d = 0;
		int x = downx - dx[d];
		int y = downy + dy[d];

		while (true) {
			int tmpx = x - dx[d];
			int tmpy = y + dy[d];
			if (tmpx >= downx && tmpy >= 0 && tmpx < map.length && tmpy < map[0].length) {
				if (tmpx == downx && tmpy == downy) {
					map[x][y] = 0;
					break;
				} else {
					map[x][y] = map[tmpx][tmpy];
					x = tmpx;
					y = tmpy;
				}
			} else {
				d++;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");

		int R = Integer.parseInt(st[0]);
		int C = Integer.parseInt(st[1]);
		int T = Integer.parseInt(st[2]);

		map = new int[R][C];

		Queue<int[]> q = new LinkedList<>();

		for (int r = 0; r < R; r++) {
			st = br.readLine().split(" ");
			for (int c = 0; c < C; c++) {
				int t = Integer.parseInt(st[c]);
				if (t == -1) {// 공기청정기 위치 저장....
					if (map[r - 1][c] == -1) {// 윗부분이 있었으면 아래저장 아님 위저장
						downx = r;
						downy = c;
					} else {
						upx = r;
						upy = c;
					}
				}
				map[r][c] = t;
			}
		}
		for (int t = 1; t <= T; t++) {// 횟수만큼 반복
			for (int r = 0; r < R; r++) {// 먼저 미세먼지 위치를 다 큐에 저장한다.
				for (int c = 0; c < C; c++) {
					if (map[r][c] > 0) {
						q.add(new int[] { r, c, map[r][c] });
					}
				}
			}
			while (!q.isEmpty()) {// 저장된 미세먼지들 이동 코드
				int[] tmp = q.poll();
				int x = tmp[0];// 좌표
				int y = tmp[1];
				int v = tmp[2];// 원래 미세먼지 농도값
				for (int d = 0; d < 4; d++) {// 주위 탐색~ 더하고 빼기~
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != -1) {
						map[nx][ny] += v / 5;
						map[x][y] -= v / 5;
					}
				}
			}
			// 미세먼지 이동 후 공기청정기 시작!
			upMove();
			downMove();
		}

		int count = 0;
		for (int[] a : map) {
			for (int aa : a) {
				if (aa > 0) {
					count += aa;
				}
			}
		}
		System.out.println(count);
	}
}
