package programmers;

import java.util.Stack;

class Solution_문자열압축 {

	public int solution(String s) {
		int answer = 0;

		String tmp = "", before = "";
		int start, length, cnt;
		boolean first = true;
		for (int i = 1; i < s.length(); i++) {
			
			if (answer<i) {
				break;
			}
			
			start = 0;
			length = 0;
			cnt = 1;
			
			before = s.substring(start, start + i);
			start += i;
			
			while (start + i < s.length()) {
				tmp = s.substring(start, start + i);
				start += i;
				if (tmp.equals(before)) {
					cnt++;
				} else {
					if (cnt > 1) {
						length += 1;
					}
					length += i;
					before = tmp;
					cnt = 1;
				}
			}
			if (cnt > 1) {
				length += 1;
			}
			length += i;
			before = tmp;
			cnt = 1;
			
			length += s.length() - start;
			if (answer<length) {
				answer = length;
			}
		}

		return answer;
	}
}