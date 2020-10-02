package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumToKor {

	public static void main(String[] args) throws Exception{
		String[][] kor = {{"","일","이","삼","사","오","육","칠","팔","구"},{"","십","백","천"},{"","만","억","조"}};//0,1,2,3,4
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long num = Long.parseLong(br.readLine());
		String answer = "";
		int[] div = {0,0};//십백천, 만억조
		int now = 0;
		long tmp = num;
		int loc = 1;
		
		while(tmp>1) {
			tmp/=10;
			div[0]++;
			loc++;
			if (div[0]==4) {
				div[1]++;
				div[0]=0;
			}
		}
		
		while(loc>0) {
			tmp= (long) Math.pow(10, --loc);
			now = (int) (num/tmp);
			num %=tmp;
			
			if (now==0) {
				div[0]--;
				if (div[1]!=0 && div[0]==-1) {
					answer+=kor[2][div[1]];
					div[1]--;
					div[0]=3;
				}
				continue;
			}
			answer +=kor[0][now];
			
			answer += kor[1][div[0]];
			
			div[0]--;
			if (div[1]!=0 && div[0]==-1) {
				answer+=kor[2][div[1]];
				div[1]--;
				div[0]=3;
			}
			System.out.println(answer);
			
		}
		System.out.println(answer);
		
	}
}
