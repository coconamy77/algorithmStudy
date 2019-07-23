package HW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1989_초심자의회문검사_서울8반_정하정 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int T = Integer.parseInt(st.nextToken());
		
		
		for (int t = 1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			String txt = st.nextToken();
			int ans = 1;
			for (int i =0;i<=txt.length()/2; i++) {
				if (txt.charAt(i)!=txt.charAt(txt.length()-1-i)) {
					ans = 0;
				}
			}
			System.out.println("#"+t+" "+ans);
		}
		
	}
}
