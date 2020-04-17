package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2164_카드2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] num = new int[N*2];
		
		for (int i=0;i<N; i++) {
			num[i] = i+1;
		}
		
		int idx = 0;
		int ni = N;
		while(idx<2*N) {
			idx++;
			num[ni++] = num[idx++];
		}
		

		System.out.println(num[idx-2]);
	}
}
