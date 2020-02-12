package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2309_일곱난쟁이 {
	
	static int[] hobit = new int[9];
	static int[] ans = new int[7];
	static boolean fin = false;
	
	static void getAns(int dep,int start) {
		if (fin) return;
		if (dep==7) {
			int sum = 0;
			for (int i = 0; i<9; i++) {
				if (sum > 100) {
					return;
				}
				if (ans[i]==1) {
					sum+=hobit[i];
				}
			}
			if (sum==100) {
				fin = true;
				return;
			}
			
		}else {
			for (int i = start; i<9; i++) {
				ans[dep] = i;
				getAns(dep+1, i+1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0;i<9; i++) {
			hobit[i] = Integer.parseInt(br.readLine());
			
			
		}
		
		getAns(0,0);
	}
}
