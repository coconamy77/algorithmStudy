
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String n = st.nextToken();
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			boolean d = false;

			String ans = "";

			for (int i = 0; i < n.length(); i++) {

				int digit = n.charAt(i) - '0';
				if (!d) {
					if (i == 0) {
						if (n.length() == 1) {
							if (digit < x) {
								ans = "-1";
								break;
							}
							if (x == 0 && digit < y) {
								ans = "-1";
								break;
							}
						}
						if (digit < x) {
							d = true;
							continue;
						}
						if (x == 0 && digit < y) {
							d = true;
							continue;
						}
					}
					if (digit < x) {
						ans = "";
						// System.out.println("여기를 안온다고?"+i);
						if (i == 1) {
							ans+=x;
							
						}else if(i==n.length()-1) {
							ans = "-1";
							break;
						}
						else {
							for (int j = 0; j < i; j++) {
								ans += y;
							}
						}
						d = true;
						continue;
					}
					if (digit > y) {
						ans += y;
						d = true;
					} else if (digit == y) {
						ans += y;
					} else if (digit == x) {
						ans += x;
					} else {
						ans += x;
						d = true;
					}

				} else {
					ans += y;
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}

		br.close(); // 사용이 끝난 스캐너 객체를 닫습니다.
	}
}
