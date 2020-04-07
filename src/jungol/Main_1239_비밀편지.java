package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1239_비밀편지 {
	
	public static void main(String[] args) throws Exception{
		String[] alpha_num = {"000000","001111","010011","011100","100110","101001","110101","111010"};
		
		String[] real = {"A","B","C","D","E","F","G","H"};
		
		String[] alpha = new String[64];
		String tmp = "";
		for (int i = 0; i<8; i++) {
			alpha[Integer.parseInt(alpha_num[i],2)] = real[i];
			//System.out.println(alpha_num[i]);
			for (int j = 0;j<6;j++) {
				tmp = alpha_num[i].substring(0,j);
				switch(alpha_num[i].charAt(j)) {
				case '0':
					tmp += "1";
					break;
				case '1':
					tmp += "0";
					break;
				}
				tmp += alpha_num[i].substring(j+1);
				//System.out.println(tmp);
				alpha[Integer.parseInt(tmp,2)] = real[i];
			}
			//System.out.println();
		}
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String ans = "";
		String letter = br.readLine();

		for (int i = 0; i<n; i++) {
			tmp = letter.substring(i*6,i*6+6);
			
			if (alpha[Integer.parseInt(tmp,2)]==null) {
				ans = String.valueOf(i+1);
				break;
			}else {
				ans += alpha[Integer.parseInt(tmp,2)];
			}
			
			
		}
		
		System.out.println(ans);
		
	}
}
