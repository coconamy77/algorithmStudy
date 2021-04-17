package programmers;

import java.util.Arrays;

public class Solution_쿼드압축후개수세기 {
	static int[] answer = new int[2];
	static int[][] array;

	public void isOne(int sx, int sy, int n) {
		int now = array[sx][sy];
		if (n == 1) {
			answer[now]++;
			return;
		}
		for (int i = sx; i < sx + n; i++) {
			for (int j = sy; j < sy + n; j++) {
				if (now != array[i][j]) {
					int mid = n / 2;
					isOne(sx, sy, mid);
					isOne(sx + mid, sy, mid);
					isOne(sx, sy + mid, mid);
					isOne(sx + mid, sy + mid, mid);

					return;
				}
			}
		}
		answer[now]++;
		return;
	}

	public int[] solution(int[][] arr) {
		array = arr;
		isOne(0, 0, arr.length);
		System.out.println(array[0][0]);
		return answer;
	}
	public static void main(String[] args) {
		Solution_쿼드압축후개수세기 s = new Solution_쿼드압축후개수세기();
		System.out.println(Arrays.toString(s.solution(new int[][] {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}})));
	}
}
