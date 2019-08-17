package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LngstSeq_11053 {
	public static void main(String[] args) throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int[] ans = new int[A];
		int[] num = new int[A];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = 0;
		for(int i = 0; i<A; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			int max = 0;
			for (int j = i-1; j>=0; j--) {
				if (num[j]<num[i]) {
					max = max>ans[j]? max: ans[j];
				}
			}
			ans[i] = max+1;
			a = a>ans[i]? a: ans[i];
		}
		
		System.out.println(a);
	}
}
