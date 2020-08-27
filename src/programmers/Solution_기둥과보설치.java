package programmers;


class Solution_기둥과보설치 {
	static boolean[][][] map;

	public void rm(int x, int y, int w) {
		map[x][y][w] = false;

		for (int i = 0; i < 4; i++) {
			if (map[x][y][i]) {
				return;
			}
		}
		map[x][y][4] = false;
	}

	public boolean check(int x, int y, int w) {
		// w==1->보, 0->기둥

		if (w == 0) {
			if (x != 0 && !map[x][y][4]) {
				return false;
			}
			return true;
		} else {
			if (map[x][y][3]) {
				return true;
			}
			if (!map[x][y + 1][4]) {
				return false;
			}
			if (map[x][y + 1][3]) {
				return true;
			}
			if (map[x][y][1] && map[x][y + 1][0]) {
				return true;
			}
		}
		return false;
	}

	public int[][] solution(int n, int[][] build_frame) {
		map = new boolean[n + 1][n + 1][5];
		int x, y, a, b;
		boolean rmb;
		int cnt = 0;
		for (int[] arr : build_frame) {
			x = arr[1];
			y = arr[0];
			a = arr[2];// 0==기둥, 1==보
			b = arr[3];// 0==삭제, 1==설치

			// 왼보, 오보, 위기, 아기
			if (b == 1) {
				if (check(x, y, a)) {
					cnt++;
					map[x][y][4] = true;
					if (a == 0) {
						map[x][y][2] = true;
						map[x + 1][y][4] = true;
						map[x + 1][y][3] = true;
					} else {
						map[x][y][0] = true;
						map[x][y + 1][4] = true;
						map[x][y + 1][1] = true;
					}
				}
			} else {
				if (a == 0) {
					cnt--;
					rm(x, y, 2);
					rm(x + 1, y, 3);
					rmb = true;
					for (int i = 0; i < 3; i++) {
						if (map[x+1][y][i]) {
							if (i == 0) {
								if (!check(x+1, y, 1)) {
									rmb = false;
									
									break;
								}
							}else if (i==1) {
								if (!check(x+1, y-1, i)) {
									rmb = false;
									break;
								}
							}else if(i==2) {
								if (!check(x+1,y,i)) {
									rmb = false;
									break;
								}
							}
						}
					}
					if (!rmb) {
						cnt++;
						map[x][y][4] = true;
						map[x][y][2] = true;
						map[x + 1][y][4] = true;
						map[x + 1][y][3] = true;
					}
				}else {
					//보를 삭제!
					cnt--;
					rm(x, y, 0);
					rm(x, y+1, 1);
					rmb = true;
					
					//0체크!
					for (int i = 1; i < 3; i++) {
						if (map[x][y][i]) {
							if (i == 1) {
								if (!check(x+1, y, i)) {
									rmb = false;
									break;
								}
							}else if (i==1) {
								if (!check(x+1, y-1, i)) {
									rmb = false;
									break;
								}
							}else if(i==2) {
								if (!check(x+1,y,i)) {
									rmb = false;
									break;
								}
							}
						}
					}
					if (!rmb) {
						cnt++;
						map[x][y][4] = true;
						map[x][y][2] = true;
						map[x + 1][y][4] = true;
						map[x + 1][y][3] = true;
					}
				}
			}

		}
		
		int[][] answer = new int[cnt][3];
		int idx = 0;
		for (int i = 0; i<n+1; i++) {
			for (int j = 0; j<n+1; j++) {
				if (map[j][i][4]) {
					if (map[j][i][2]) {
						answer[idx][0] = i;
						answer[idx][1] = j;
						answer[idx++][2] = 0;
						//System.out.print(0);
					}
					if (map[j][i][0]) {
						answer[idx][0] = i;
						answer[idx][1] = j;
						answer[idx++][2] = 1;
						//System.out.print(1);
					}
				}
//				else {
//					System.out.print("-");
//				}
				if(cnt==idx) {
					return answer;
				}
			}
			//System.out.println();
		}
//		System.out.print("[");
//		for (int i = 0; i<cnt; i++) {
//			System.out.print("["+answer[i][0]+", "+answer[i][1]+", "+answer[i][2]+"], ");
//		}
//		System.out.println("]");

		return answer;
	}
	
	public static void main(String[] args) {
		Solution_기둥과보설치 s = new Solution_기둥과보설치();
		s.solution(5,new int[][] {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}});
		
		
	}
}
