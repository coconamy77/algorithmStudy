package programmers;

public class Solution_광고삽입 {
	public int changeNum(String time) {
		String[] t = time.split(":");
		return Integer.parseInt(t[0]) * 3600 + Integer.parseInt(t[1]) * 60 + Integer.parseInt(t[2]);
	}

	public String solution(String play_time, String adv_time, String[] logs) {
		if (play_time.equals(adv_time)) {
			return "00:00:00";
		}

		int playTime = changeNum(play_time);
		int[] plays = new int[playTime + 1];

		for (String log : logs) {
			String[] logTime = log.split("-");
			for (int i = changeNum(logTime[0]); i <= changeNum(logTime[1]); i++) {
				plays[i]++;
			}
		}

		int sum = 0;
		int adv = changeNum(adv_time);
		int time = 0;
		int ansTime = 0;
		for (; time <= adv; time++) {
			sum += plays[time];
		}
		int max = sum;

		for (time = 1; time <= playTime - adv; time++) {
			sum -= plays[time - 1];
			sum += plays[time + adv];
			if (max < sum) {
				max = sum;
				ansTime = time;
			}
		}

		int h = ansTime / 3600;
		ansTime %= 3600;
		int m = ansTime / 60;
		int s = ansTime % 60;

		return makeAns(h) + ":" + makeAns(m) + ":" + makeAns(s);
	}

	public String makeAns(int t) {
		if (t == 0) {
			return "00";
		}
		if (t < 10) {
			return "0" + t;
		}
		return t + "";
	}
}
