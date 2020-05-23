package reference;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	static Queue<Integer> q = new LinkedList<Integer>();
	static int map[][] = { { 0, 1, 1, 0 }, { 1, 0, 1, 0 }, { 1, 1, 0, 0 }, { 1, 0, 0, 1 } };
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static int nx, ny;
	static int length = map.length;

	public static void BFS(int x, int y) {
		q.offer(x);
		q.offer(y);
		while (!q.isEmpty()) {
			int curx = q.poll();
			int cury = q.poll();
			for (int i = 0; i < 4; i++) {
				nx = dx[i] + curx;
				ny = dy[i] + cury;
				if (nx >= 0 && ny >= 0 && nx < length && ny < length) { // 추가 조건 걸어주기
					q.offer(nx);
					q.offer(ny);
					// 들어갔을 때
				}
			}
		}
	}
}
