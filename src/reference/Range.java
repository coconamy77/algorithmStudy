package reference;

public class Range {
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static int nx, ny;
	static int length;

	public static void DFS(int x, int y) {
		for (int i = 0; i < 4; i++) {
			nx = dx[i] + x;
			ny = dy[i] + y;
			if (nx >= 0 && ny >= 0 && nx < length && ny < length) {
				DFS(nx, ny);
			}
		}
	}
}
