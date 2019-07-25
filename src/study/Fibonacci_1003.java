package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fibonacci_1003 {
	
	static int[][] number; 
	static boolean[][] numCheck;

	static int getNum(int n,int oz) {
		if (numCheck[n][oz]) {
			return number[n][oz];
		}
		if (n==0) {
			number[n][0] = 1;
			number[n][1] = 0;
			numCheck[n][oz] = true;
		}else if (n==1) {
			number[n][0] = 0;
			number[n][1] = 1;
			numCheck[n][oz] = true;
		}else {
			number[n][oz] = getNum(n-1,oz)+getNum(n-2,oz);
			numCheck[n][oz] = true;
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
			numCheck = new boolean[N+1][2];
			
			for (int i = 0; i<N+1; i++) {
				numCheck[i][0] = false;
				numCheck[i][1] = false;
			}
			
			System.out.println(getNum(N,0) +" "+getNum(N,1));
		}
		
	}
}
