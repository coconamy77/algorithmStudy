package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {
	static int[][] wh;
	static int[] top;
	static void w(int i, int d, char s) {
		int tmp = top[i];
		top[i] = (top[i]+8+d)%8;
		if ((s=='a' || s=='l') && i!=0) {
			if (wh[i-1][(top[i-1]+2)%8]!=wh[i][(tmp+8-2)%8]) {
				w(i-1,-d,'l');
			}
		}
		if ((s=='a' ||s=='r') && i!=3) {
			if (wh[i][(tmp+2)%8]!=wh[i+1][(top[i+1]+8-2)%8]) {
				w(i+1,-d,'r');
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		wh = new int[4][8];
		top = new int[4];
		for (int i = 0; i<4; i++) {
			String s = br.readLine();
			for (int j =0; j<8; j++) {
				wh[i][j] = s.charAt(j)-'0';
			}
		}
		int K = Integer.parseInt(br.readLine());
		for (int k =0; k<K;k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken())*-1;
			w(i,d,'a');
		}
		int sum = 0;
		int[] score = {1,2,4,8};
		for (int i = 0; i<4; i++) {
			sum += wh[i][top[i]]*score[i];
		}
		System.out.println(sum);
	}
}
