package programmers;

class Solution_자물쇠와열쇠 {
	
	static int minx = 20, maxx = 0, miny = 20, maxy = 0;
	
	public boolean check(int sx, int sy) {
		
		
		return true;
	}
	
	public boolean solution(int[][] key, int[][] lock) {
		boolean answer = true;
		int M = key.length;
		int N = lock.length;
		minx = N;
		miny = N;
		
		int cnt = 0;

		// 0,2
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (lock[i][j] == 0) {
					cnt++;
					if (minx > i) {
						minx = i;
					}
					if (maxx < i) {
						maxx = i;
					}
					if (miny > j) {
						miny = j;
					}
					if (maxy < j) {
						maxy = j;
					}
				}
			}
		}

		if (maxx - minx >= M || maxy - miny >= M) {
			return false;
		}

		int keycnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if (key[i][j] == 1) {
					keycnt++;
				}
			}
		}

		if (keycnt < cnt) {
			return false;
		}

		for (int sx = N - maxx - 1; sx >= 0; sx--) {

			
		}

		return answer;
	}
}
