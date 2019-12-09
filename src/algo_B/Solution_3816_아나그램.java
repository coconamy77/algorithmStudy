package algo_B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3816_아나그램 {
	// 굳이 첫번째 맞는거 안구하고 걍 처음부터 해버리면 됨. boolean flag 두고 엣지의 변화를 확인

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int ans=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			int[] a = new int[26];
			for (int i = 0; i < s1.length(); i++) {
				a[s1.charAt(i) - 'A']++;
			}
			
			System.out.println("#" + t + " " + ans);
			
		}
	}
}

/*static int getFirst(int[] a, String s2, int len) {
	
	int tmplen = 0;
	for (int i = 0; i < s2.length(); i++) {
		if (a[s2.charAt(i) - 'A'] <= 0) {
			continue;
		}
		tmplen = 1;
		int[] b = new int[26];
		b[s2.charAt(i) - 'A']++;
		for (int j = i + 1; j < i + len; j++) {
			if (a[s2.charAt(j) - 'A'] - b[s2.charAt(j) - 'A'] <= 0) {
				break;
			}
			tmplen++;
			b[s2.charAt(j) - 'A']++;
		}
		if (tmplen == len) {
			
			return i;
		}
	}
	return -1;
}

public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());
	
	for (int t = 1; t <= T; t++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s1 = st.nextToken();
		String s2 = st.nextToken();
		int len = s1.length();
		int[] a = new int[26];
		
		for (int i = 0; i < s1.length(); i++) {
			a[s1.charAt(i) - 'A']++;
		}
		int ans = 0;
		int f = getFirst(a, s2, len);
		
		while (f != -1) {
			ans++;
			for (int i = f; i < s2.length() - len; i++) {
				if (s2.charAt(i) == s2.charAt(i + len)) {
					ans++;
				}
			}
			
		}
		System.out.println("#" + t + " " + ans);
		
	}
}*/