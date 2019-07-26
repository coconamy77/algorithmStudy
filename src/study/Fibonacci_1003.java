package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fibonacci_1003 {

	static int[][] number; 

	static int getNum(int n,int oz) {
		if (number[n][oz] != 0) {
			return number[n][oz];
		}
		if (n==0) {
			number[n][0] = 1;
			number[n][1] = 0;
		}else if (n==1) {
			number[n][0] = 0;
			number[n][1] = 1;
		}else {
			number[n][oz] = getNum(n-1,oz)+getNum(n-2,oz);
		}
		return number[n][oz];
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t<=T; t++) {
			st =  new StringTokenizer(br.readLine());
		
			int N = Integer.parseInt(st.nextToken());
		
			number = new int[N+1][2];
			
			System.out.println(getNum(N,0) +" "+getNum(N,1));
		}
		
	}
}
