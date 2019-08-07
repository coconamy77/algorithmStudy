package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chicken_1765 {

	static boolean[] chk;
	static int[][] s;
	static int count = 0;

	static void getCount(int me, int friend,int rs) {
		
		if (rs ==1) {
			if (chk[friend])return;
			chk[friend] = true;
		 }
		for (int i = 0; i < s.length; i++) {
			if (i == me)
				continue;
			if (s[friend][i] == rs) {
				getCount(friend, i,1);
			}
			
		}/*
		System.out.println("i = "+me+", j = "+friend+", count = "+count);
		System.out.println(Arrays.toString(chk));*/
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		s = new int[n][n];
		chk = new boolean[n];

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			char r = String.valueOf(st.nextToken()).charAt(0);

			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());

			s[s1 - 1][s2 - 1] = r == 'E' ? -1 : 1;
			s[s2 - 1][s1 - 1] = s[s1 - 1][s2 - 1];
		}

		for (int i = 0; i < n; i++) {
			if (chk[i])
				continue;
			chk[i] = true;
			count++;
			for (int j = 0; j < n; j++) {
				if (s[i][j] != 0) {
					
					getCount(i, j,s[i][j]);
				}
			}

		}
		System.out.println(count);
	}

}
