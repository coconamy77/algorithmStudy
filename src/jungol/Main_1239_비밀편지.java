package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1239_비밀편지 {
	
	public static void main(String[] args) throws Exception{
		String[] alpha = {"000000","001111","010011","011100","100110","101001","110101","111010"};
		int[] alpha_num = new int[8];
		String[] real = {"A","B","C","D","E","F","G","H"};
		
		for (int i = 0; i<8; i++) {
			alpha_num[i] = Integer.parseInt(alpha[i],2);
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String ans = "";
		String letter = br.readLine();
		String tmp = "";
		for (int i = 0; i<n; i++) {
			tmp = letter.substring(i*6,i*6+6);
			
			for (int j = 0; j<8; j++) {
				if (alpha_num[j]==Integer.parseInt(tmp,2)) {
					ans+=real[j];
					break;
				}
			}
			
			
		}
		
	}
}
