package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin0_11047 {
/*	준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.

	동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 
	이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
*/
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[N];
		
		for (int n = 0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			//coin[n] = 
		}
		
		
		
	}

}
