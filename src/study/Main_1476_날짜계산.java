package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1476_날짜계산 {
	static int E = 15, S = 28, M = 19;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int i = 0;
		
		int tmp = s;
		
		while(true) {
			if (tmp%E==e && tmp%M==m) {
				break;
			}
			tmp +=S;
			//i++;
			//System.out.println(tmp);
		}
		System.out.println(tmp);
		
	}
}
