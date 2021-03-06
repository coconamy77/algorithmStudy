package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1057_토너먼트 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int round = 0;
		
		while(true) {
			if (N<=Math.pow(2, round++)) {
				break;
			}
		}
		
		int mid =1;
		while(round>0) {
			mid = (int) (Math.pow(2, round)/2);
			
			if ((a>mid && b<=mid) || b>mid && a<=mid) {
				break;
			}
			else if(a>mid) {
				a -=mid;
				b -=mid;
			}
			round--;
		}
		
		System.out.println(round);
		
	}
}
