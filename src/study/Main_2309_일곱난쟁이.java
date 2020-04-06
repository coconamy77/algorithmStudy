package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309_일곱난쟁이 {
	static int[] shorts = new int[9];
	static boolean fin = false;
	
	static void getAns(int dep, int start, int[] ans) {
		if (fin) return;
		if (dep==7) {
			int sum = 0; 
			for (int i = 0; i<7; i++) {
				sum += shorts[ans[i]];
				if (sum >100) return;
			}
			if (sum==100) {
				fin = true;
			}
			return;
		}
		for (int i = start; i<9; i++) {
			if (fin) return;
			ans[dep] = i;
			getAns(dep+1, start+1,ans);
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i =0; i<9; i++) {
			shorts[i] = Integer.parseInt(br.readLine());
		}
		
		int[] ans = new int[7];
		getAns(0,0,ans);
		
		for (int i = 0; i<7; i++) {
			ans[i] = shorts[ans[i]];
		}
		
		Arrays.sort(ans);
		
		for (int i = 0; i<7; i++) {
			System.out.println(ans[i]);
		}
		
	}


}
