package array1;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1204_최빈수구하기_서울8반_정하정 {
	public static void main(String args[]) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d1_1204.txt"));

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] score = new int[101];
		
		
		for (int t = 1; t<=T; t++) {
			for (int i = 0; i<101;i++) {
			score[i]=0;
			}
			
			sc.nextInt();
			for (int i=0; i<1000; i++) {
				score[sc.nextInt()]++;
			}
			
		int maxIdx =0;
		for (int i = 1; i<101; i++) {
			if (score[maxIdx]<=score[i]) maxIdx = i;
			
		}
		
		System.out.println("#"+t+" "+maxIdx);
		
		}
		
		
		

	}
}