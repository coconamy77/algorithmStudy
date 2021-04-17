package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1254_팰린드롬만들기 {
	static String str;
	static int length;
	
	public static boolean isPal(int len) {
		int b= 0, f = 0;
		if(len%2==0) {
			b = len/2;
			f = b-1;
		}else {
			b = (len+1)/2;
			f = b-2;
		}
		
		while(b<length) {
			if(str.charAt(f)!=str.charAt(b)) {
				return false;
			}
			f--;
			b++;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		length = str.length();
		
		if(length<=1) {
			System.out.println(length);
			return;
		}
		
		int answer = length;
		while(answer<length*2-1) {
			if(isPal(answer)) {
				break;
			}
			answer++;
		}
		
		System.out.println(answer);
	}
}
