package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1614_영식이의손가락 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());
		
		int ans  = 0;
		
		if (n==1) {
			ans = t*8;
		}else if(n== 5) {
			ans = t*8+4;
		}else {
			if(t%2==0) {
				ans = (t/2)*8+n-1;
			}else {
				ans = (t/2)*8;
				switch(n) {
				case 2:
					ans+=7;
					break;
				case 3:
					ans+=6;
					break;
				case 4:
					ans+=5;
					break;
				}
			}
		}
		
		System.out.println(ans);
	}
}
