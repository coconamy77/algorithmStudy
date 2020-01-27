// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution_naver {
	public static void main(String[] args) {
		System.out.println(solution("?ab??a"));
		System.out.println(solution("bab??a"));
		System.out.println(solution("?a?"));
	}

	static String solution(String S) {
		String ans = "";
		char[] arr = S.toCharArray();
		int t;
		int h = S.length() / 2 - 1;
		if (S.length() % 2 == 0) {
			t = h + 1;
		} else {
			t = h + 2;
		}
		char hc, tc;
		while (h >= 0) {
			hc = arr[h];
			tc = arr[t];

			if (hc != tc) {
				if (hc == '?') {
					arr[h] = tc;

				} else if (tc == '?') {
					arr[t] = hc;

				} else {
					ans = "NO";
					break;
				}
			} else if (hc == '?') {
				arr[h] = 'a';
				arr[t] = 'a';
			}
			h--;
			t++;

		}
		if (ans != "NO") {
			for (char a : arr) {
				ans += a;
			}
		}
		return ans;
	}
}