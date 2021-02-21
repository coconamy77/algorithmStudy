package programmers;

public class Solution_소수만들기 {
	public boolean isP(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public int getNums(int start, int dept, int[] sel, int[] nums) {
		if (dept == 3) {
			int sum = 0;
			for (int n : sel) {
				sum += nums[n];
			}
			if (isP(sum)) {
				return 1;
			} else {
				return 0;
			}
		} else {
			int count = 0;
			for (int i = start; i < nums.length; i++) {
				sel[dept] = i;
				count += getNums(i + 1, dept + 1, sel, nums);
			}
			return count;
		}
	}

	public int solution(int[] nums) {
		return getNums(0, 0, new int[3], nums);
	}
}
