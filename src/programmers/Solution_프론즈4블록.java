package programmers;

public class Solution_프론즈4블록 {

	public int check(int i, int j, String[] board, boolean[][] vst) {
		char tmp = board[i].charAt(j);
		int cnt = 0;
		if (board[i].charAt(j + 1) == tmp) {
			if (board[i + 1].charAt(j) == tmp) {
				if (board[i + 1].charAt(j + 1) == tmp) {
					if (!vst[i][j]) {
						vst[i++][j] = true;
						cnt++;
					}

					if (!vst[i][j]) {
						vst[i][j++] = true;
						cnt++;
					}
					if (!vst[i][j]) {
						vst[i--][j] = true;
						cnt++;
					}
					if (!vst[i][j]) {
						vst[i][j] = true;
						cnt++;
					}
				}
			}
		}

		return cnt;
	}

	public void remove(int m, int n, String[] board, boolean[][] vst) {
		char[][] b = new char[m][n];

		for (int i = 0; i < m; i++) {
			b[i] = board[i].toCharArray();
		}

		int bottom = 0;

		for (int j = 0; j < n; j++) {
			int i = m-1;
			for (; i >= 0; i--) {
				if (b[i][j] != '-') {
					if (vst[i][j]) {
						bottom = bottom < i ? i : bottom;
					} else {
						b[bottom][j] = b[i][j];
						bottom++;
					}
				} else {
					break;
				}
			}
			while(bottom<i) {
				b[bottom][j] = '-';
			}
		}
		
		for (int i = 0;i<m; i++) {
			board[i] = b[i].toString();
		}
	}

	public int solution(int m, int n, String[] board) {
		int answer = 0;
		int removed = 10;
		boolean[][] vst;

		while (removed > 0) {
			removed = 0;
			vst = new boolean[m][n];
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (board[i].charAt(j) == '-') {
						continue;
					}
					removed += check(i, j, board, vst);

				}
			}
			remove(m, n, board, vst);
			answer += removed;
		}

		return answer;
	}

}
