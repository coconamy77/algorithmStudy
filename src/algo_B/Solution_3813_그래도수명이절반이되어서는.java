package algo_B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3813_그래도수명이절반이되어서는 {
	//결정문제!!!!!!!!!
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] block = new int[N];
			int[] set  = new int[K];
			
			int min = 200008;
			int max = 0;
			
			st = new StringTokenizer(br.readLine());
			
			int tmp;
			
			for (int n = 0; n<N; n++) {
				tmp = Integer.parseInt(st.nextToken());
				
				min = tmp>min? min:tmp;
				max = tmp<max? max:tmp;
				
				block[n] = tmp;
			}
			
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m<K; m++) {
				set[m]	 = Integer.parseInt(st.nextToken());
			}
			
			int idx = 0;
			int ans = max;
			int wl = 0,val;
			while(max!=min) {
				idx = 0;
				wl = (max+min)/2;
				val = 0;
				for (int n = 0; n<N; n++) {
					if (block[n]>wl) {
						val = 0;
						continue;
					}else {
						val++;
						if(val==set[idx]) {
							//System.out.println(idx);
							val = 0;
							idx++;
							if (idx==K) {
								//System.out.println("여기..?"+wl);
								break;
							}
						}
					}
				}
				if (idx==K) {
					ans = ans<wl? ans: wl;
					max = wl;
				}else {
					//System.out.println("여기는 오는가 여기가 무한?");
					min = wl+1;
				}
			}
			System.out.println("#"+t+" "+ans);
			
		}
		
		
	}
}
