package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1461_도서관 {
	static int[] map;
	static int N,M,ncnt,pcnt;
	
	static int goP() {
		int n = N-ncnt-1;
		int ans = 0;
		int loc = 0;
		for (int i = n; i<n+pcnt%M;i++) {
			ans +=(map[i]-loc);
			loc = map[i];			
		}
		ans += loc;
		loc = 0;
		
		while(loc<map[N-1]) {
			n = M;
			while(n>0) {
				
			}
		}
		
		
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N];

		st = new StringTokenizer(br.readLine());

		ncnt = 0;
		pcnt = 0;
		for (int n = 0; n < N; n++) {
			map[n] = Integer.parseInt(st.nextToken());
			if (map[n] < 0)
				ncnt++;
		}
		pcnt = N-ncnt;
		
		Arrays.sort(map);

		if (pcnt==0) {
			//음수얘들만 가~
		}else if (ncnt ==0) {
			//양수 애들만 가~
		}else {
			if (Math.abs(map[0])>Math.abs(map[N-1])) {
				//양수 먼저 가고 
				//0으로 돌아가서
				//음수 가자
				
			}else {
				//음수 먼저 가고 
				//0으로 돌아가서 
				//양수 가자
			}
		}
		
		

		

	}

}
