package programmers;

import java.util.Arrays;

public class Solution_셔틀버스 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_셔틀버스 s = new Solution_셔틀버스();
		System.out.println(s.solution(2, 10, 2, new String[] { "09:10", "09:09", "08:00" }));

	}

	public String solution(int n, int t, int m, String[] timetable) {
		String answer = "";
		Arrays.sort(timetable);
		String busTime[] = new String[n];
		busTime[0] = "09:00";
		int tempT = 0;
		int H;
		int M;
		String hStr;
		String mStr;
		for (int i = 1; i < n; i++) {
			tempT += t;
			H = 9 + tempT / 60;
			M = tempT % 60;
			hStr = "0" + H;
			mStr = "0" + M;
			busTime[i] = hStr.substring(hStr.length() - 2) + ":" + mStr.substring(mStr.length() - 2);
		}
		int busIdx = 0;
		int cnt = 0;
		String memory;
		for (int i = 0; i < timetable.length; i++) {
			memory = timetable[i];
			if (busTime[busIdx].compareTo(timetable[i]) >= 0) {
				if (cnt < m) {
					cnt++;
					if (cnt == m) {
						cnt = 0;
						busIdx++;
						if (busIdx == n) {
							hStr = memory.split(":")[0];
							mStr = memory.split(":")[1];
							if (mStr.equals("00")) {
								mStr = "59";
								hStr = "0" + (Integer.parseInt(hStr) - 1);
							} else {
								mStr = "0" + (Integer.parseInt(mStr) - 1);
							}
							answer = hStr.substring(hStr.length() - 2) + ":" + mStr.substring(mStr.length() - 2);
							return answer;
						}
					}
				}
			} else {
				i--;
				busIdx++;
				cnt = 0;
				if (busIdx ==n) {
					break;
				}
			}
		}
		answer = busTime[busTime.length - 1];
		return answer;
	}

}
