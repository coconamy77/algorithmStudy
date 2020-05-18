package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1461_도서관 {
	static int[] map;
	static int N,M,ncnt,pcnt;
	
	static int goP() {
		int n = ncnt;
		int ans = 0;
		int loc = 0;
		//System.out.println("d양수위치: "+loc+"ans: "+ans);
		int i = n;
		for (; i<n+pcnt%M;) {
			ans +=(map[i]-loc);
			loc = map[i++];	
			//System.out.println("처음양수위치: "+loc+"ans: "+ans);
		}
		
		while(loc<map[N-1]) {
			ans += loc;
			loc = 0;
			//System.out.println("양수위치: "+loc+"ans: "+ans);
			n = M;
			while(n>0) {
				ans +=(map[i]-loc);
				loc = map[i++];	
				n--;
				//System.out.println("양수위치: "+loc+"ans: "+ans);
			}
		}
		
		
		return ans;
	}
	
	static int goN() {
		int n = ncnt-1;
		int ans = 0;
		int loc = 0;
		//System.out.println("위치: "+loc+"ans: "+ans);
		int i = n;
		for (; i>n-ncnt%M;) {
			ans +=-1*(map[i]-loc);
			loc = map[i--];			
			//System.out.println("위치: "+loc+"ans: "+ans);
		}
		
		while(loc>map[0]) {
			ans += (-1*loc);
			loc = 0;
			//System.out.println("위치: "+loc+"ans: "+ans);
			n = M;
			while(n>0) {
				ans +=-1*(map[i]-loc);
				loc = map[i--];	
				n--;
				//System.out.println("위치: "+loc+"ans: "+ans);
			}
		}
		
		
		return ans;
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
		//System.out.println(pcnt);
		Arrays.sort(map);
		//System.out.println(Arrays.toString(map));
		int ans = 0;
		if (pcnt==0) {
			//.out.println("음수");
			//음수얘들만 가~
			ans+=goN();
		}else if (ncnt ==0) {
			//System.out.println("양슈");
			//양수 애들만 가~
			ans+=goP();
		}else {
			if (Math.abs(map[0])>Math.abs(map[N-1])) {
				//System.out.println("양슈->음수");
				//양수 먼저 가고
				ans+=goP();
				//0으로 돌아가서
				ans+=map[N-1];
				//음수 가자
				ans+=goN();
			}else {
				//System.out.println("음슈->양수");
				//음수 먼저 가고 
				ans+=goN();
				//0으로 돌아가서 
				ans+=-1*map[0];
				//양수 가자
				ans+=goP();
			}
		}
		System.out.println(ans);
	}

}
