package groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_고장난컴퓨터 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int ans = 1;
		int tmp = Integer.parseInt(st.nextToken());
		int tmp2;
		for (int i = 1; i<N; i++) {
			tmp2 = Integer.parseInt(st.nextToken());
			if (tmp2-tmp>c) {
				ans = 1;
			}else {
				ans++;
			}
			tmp = tmp2;
		}
		System.out.println(ans);
	}
	
}
