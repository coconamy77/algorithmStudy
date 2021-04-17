package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1052_물병 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[] n = Integer.toBinaryString(N).toCharArray();
		
		int count = 0;
		for(char c: n) {
			if(c=='1') {
				count++;
			}
		}
		int answer = 0;
		while(count>K) {
			answer++;
			count++;
			for(int i = n.length-1; i>=0; i--) {
				if(n[i]=='0') {
					n[i]= '1';
					break;
				}else {
					count--;
					n[i] = '0';
				}
			}
		}
		System.out.println(answer);
	}
}
