package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NumToKor {

	public static void main(String[] args) throws Exception{
		String[][] kor = {{"","일","이","삼","사","오","육","칠","팔","구"},{"","십","백","천","만"}};//0,1,2,3,4
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		String answer = "";
		int div = 4;
		int now = 0;
		int tmp;
		
		while(div>=0) {
			tmp=(int) Math.pow(10, div);
			
			now = num/tmp;
			num %=tmp;
			
			if (now==0) {
				div--;
				continue;
			}
			if (now==1) {
				if (div==0) {
					answer += kor[0][1];
				}
			}else {
				answer +=kor[0][now];
			}
			
			answer += kor[1][div--];
			System.out.println(answer);
			
			
		}
		System.out.println(answer);
		
	}
}
