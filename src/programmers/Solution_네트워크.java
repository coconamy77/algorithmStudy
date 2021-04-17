package programmers;

public class Solution_네트워크 {
	public void conn(int i, int j, int[][] com) {
		com[i][j] = 0;
		if (i == j) {
			return;
		}
		for (int nj = 0; nj < com.length; nj++) {
			if (com[j][nj] == 1) {
				conn(j, nj, com);
			}
		}
	}

	public int solution(int n, int[][] computers) {
		int answer = 0;

		for (int i = 0; i < n; i++) {
			boolean isNew = false;
			for (int j = i; j < n; j++) {
				if (computers[i][j] == 1) {
					isNew = true;
					conn(i, j, computers);
				}
			}
			if (isNew) {
				answer++;
			}
		}
		return answer;
	}
}
