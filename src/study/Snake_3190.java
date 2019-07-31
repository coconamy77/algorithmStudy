package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//뱀클래스 생성????
class Snake {
	int x;
	int y;

	public Snake(int y, int x) {
		this.x = x;
		this.y = y;
	}
}

public class Snake_3190 {
	// 게임보드 생성
	static int[][] b;
	// 뱀의 좌표 저장할 큐(배열) 생성
	static Snake[] q;
	// index(뱀의 머리, 꼬리)
	static int tail = -1;
	static int head = -1;

	static int time = 0;
	// 뱀의 방향변환 정보
	static int[][] c;

	// 현재 방향
	static int look = 4;

	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	static int go(int way, int sec) {
		Snake s = peek();
		look = (look + 4 + way) % 4;
		int ny = s.y + dy[look];
		int nx = s.x + dx[look];
		if (ny < 0 || nx < 0 || ny >= b.length || nx >= b.length || b[ny][nx] == 1) {
			time = sec;
			return -1;
		} else {
			add(new Snake(ny, nx));
			leave(b[ny][nx]);
			b[ny][nx] = 1;
		}
		System.out.println(sec + "초");
		for (int[] w : b) {

			System.out.println(Arrays.toString(w));
		}

		return sec;

	}

	static void add(Snake s) {
		if (head == q.length - 1)
			head = -1;
		q[++head] = s;
	}

	static void leave(int n) {

		tail = tail + n + 1;
		System.out.println("tail " + tail);
		if (tail >= q.length + 1)
			tail = 0;
		if (tail ==-1) {return;}
		
		Snake ss = q[tail];
		
		System.out.println("꼬리좌표 " + ss.y + ", " + ss.x);
		b[ss.y][ss.x] = 0;
	}

	static Snake peek() {
		return q[head];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 초기화
		int N = Integer.parseInt(st.nextToken());
		b = new int[N][N];
		q = new Snake[N * N + 1];
		st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			// 사과 위치
			b[y - 1][x - 1] = -1;
		}
		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());

		c = new int[L][2];
		for (int l = 0; l < L; l++) {
			st = new StringTokenizer(br.readLine());

			c[l][0] = Integer.parseInt(st.nextToken());
			c[l][1] = st.nextToken().equals("D") ? 1 : -1;

		}
		int i = 0;
		add(new Snake(0, 0));
		b[0][0] = 1;
		for (int[] w : b) {

			System.out.println(Arrays.toString(w));
		}
		for (int sec = 1; sec > 0; sec++) {
			if (i < c.length && c[i][0] == sec - 1) {
				System.out.println("방향전환");
				sec = go(c[i++][1], sec);
			} else
				sec = go(0, sec);
		}

		System.out.println(time);

	}
}
