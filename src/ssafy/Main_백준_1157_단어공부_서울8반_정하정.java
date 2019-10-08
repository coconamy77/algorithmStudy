package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_1157_단어공부_서울8반_정하정 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().toUpperCase();
		int[] alpha = new int[26];
		
		for(int i = 0; i < s.length(); i++) {
			alpha[s.charAt(i)-'A']++;
		}
		
		int max = -1;
		boolean check = false;
		int result = '0';
		
		for(int i = 0; i < alpha.length; i++) {
			if(max < alpha[i]) {
				max = alpha[i];
				result = i;
				check = false;
			}
			else if(max == alpha[i]) {
				check = true;
			}
		}
		
		if(check == true) System.out.println("?");
		else System.out.println((char)(result+'A'));
	}
}