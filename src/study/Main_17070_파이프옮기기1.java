package study;

//1:45~
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {

	static int N;
	static int[][] map;
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 0, 1 };
	static int count = 0;

	static void move(int x, int y, int s) {
		// System.out.println(x+" "+y);
		if (x == N - 1 && y == N - 1) {
			count++;
			return;
		}
		boolean[] check = new boolean[3];
		for (int d = 0; d < 3; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < N && ny < N && map[nx][ny] == 0) {
				if (d == 2) {
					if (check[0] && check[1]) {
						check[d] = true;
					}

				}
				// System.out.println(nx+" "+ ny+" "+d+"로 갈수 이쒀");

				else {
					check[d] = true;

				}
				if (check[d] && (d == s || s == 2)) {
					// System.out.println(nx+" "+ ny+" "+d+"로 갈수 이쒀");
					move(nx, ny, d);
				}
			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		move(0, 1, 0);

		System.out.println(count);

	}
}
