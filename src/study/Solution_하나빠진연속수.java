package study;

public class Solution_하나빠진연속수 {
	public int solution(int N, int[] array) {
		int answer = 0;

		int len = array.length;
		int[] cntNum = new int[len];

		int idx = 0;
		int count = 1;

		for (int i = 1; i < len; i++) {
			if (array[i] > array[i - 1]) {
				count++;
			} else {
				if (answer < count) {
					answer = count;
				}
				cntNum[idx] = count;
				idx = i;
				count = 1;
			}
		}
		if (answer < count) {
			answer = count;
		}
		cntNum[idx] = count;

		idx = 0;
		for (int i = 2; i < len - 1; i++) {
			if (cntNum[i] == 0) {
				continue;
			}
			if (array[i] > array[i - 2] || array[i + 1] > array[i - 1]) {
				count = cntNum[idx] + cntNum[i] - 1;
				if (answer < count) {
					answer = count;
				}
			}
			idx = i;
		}

		return answer;
	}

}
