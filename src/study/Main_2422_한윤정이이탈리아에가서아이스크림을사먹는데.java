package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2422_한윤정이이탈리아에가서아이스크림을사먹는데 {
	
	static int N,M;
	static int[][] ice;
	static int ans;
	
	static boolean check(int[] get) {
		if (ice[get[0]][get[1]]==1)
			return false;
		if (ice[get[2]][get[1]]==1)
			return false;
		if (ice[get[0]][get[2]]==1)
			return false;
		
		//System.out.println(Arrays.toString(get));
		return true;
	}
	
	static void getAns(int dep,int start, int[] get) {
		if (dep==3) {
			if (check(get)) {
				ans++;
				return;
			}
		}else {
			for (int i = start; i<N; i++) {
				get[dep] = i;
				getAns(dep+1, i+1,get);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ice = new int[N][N];
		
		int ti, tj;
		
		for (int m = 0; m<M; m++) {
			st =new StringTokenizer(br.readLine());
			
			ti = Integer.parseInt(st.nextToken())-1;
			tj = Integer.parseInt(st.nextToken())-1;
			
			ice[ti][tj] = 1;
			ice[tj][ti] = 1;
			
			
			
		}
		getAns(0,0,new int[3]);
		
		System.out.println(ans);
		
		
	}
}
