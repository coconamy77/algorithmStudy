package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16234_인구이동_서울8반_정하정 {

	static int[][] map;
	static boolean[][] vst;
	static int L, R, count;

	static void move(int value) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] < 0) {
					map[i][j] = value;
				}
			}
		}
		/*for (int[] a : map) {
			System.out.println(Arrays.toString(a));
		}*/
	}

	static boolean getAve(int i, int j) {
		int num = 1;
		int sum = map[i][j];
		map[i][j] = map[i][j] * (-1);
		vst[i][j] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i * 100 + j);
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		boolean chk = false;
		while (!q.isEmpty()) {
			int t = q.poll();
			int x = t / 100;
			int y = t % 100;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && ny >= 0 && nx < map.length && ny < map.length && !vst[nx][ny]) {
					int df = Math.abs((-1 * (map[x][y]) - map[nx][ny]));
					if (df >= L && df <= R) {
						num++;
						sum += map[nx][ny];
						map[nx][ny] = map[nx][ny] * (-1);
						vst[nx][ny] = true;
						q.add(nx * 100 + ny);
						chk = true;
					}
				}

			}/*
			System.out.println();
		for (int[] a : map) {
			System.out.println(Arrays.toString(a));
		}System.out.println();*/
		}
		if (chk)
			move(sum / num);
		else
			map[i][j] = map[i][j] * (-1);
		//System.out.println(chk);
		
		return chk;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		
		while (true) {
			boolean chk = false;
			vst = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!vst[i][j]) {
						//System.out.println("x = "+ i+", y = "+j);
						chk = getAve(i, j)||chk;

					}

				}
			}
			if (!chk){
				break;
				}
			else {
				count++;
				//System.out.println("여기가,,?"+count);
				
			}
				
		}
		System.out.println(count);
	}
}
