package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2812_크게만들기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		
		
		int len = N-K;
		int[] ans = new int[len];
		int idx = 0;//이게 답
		int now = 0;
		ans[idx] = s.charAt(now++)-'0';
		

	}
}
