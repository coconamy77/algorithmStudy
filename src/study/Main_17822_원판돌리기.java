package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17822_원판돌리기 {

	static int[][] map;
	static int N,M,T,total,num;
	
	static boolean check(int[] m) {
		int i = 0;
		int n = m[i];
		int idx,val,tmp;
		boolean[][] same= new boolean[N+1][M];
		while(n>0) {
			for (int j = 0; j<M; j++) {
				val = map[n][j];
				//System.out.println(val);
				if (val==0) {
					continue;
				}
				idx = map[n][M];
				
				tmp = map[n][(j-1+M)%M];
				if (tmp==val) {
					//System.out.println(j+" 1");
					same[n][(j-1+M)%M] = true;
					same[n][j] = true;
				}
				
				tmp = map[n][(j+1)%M];
				if (tmp==val) {
					//System.out.println(j+" 2");
					same[n][(j+1)%M] = true;
					same[n][j] = true;
				}
				
				tmp = (((j-idx)+M)%M+map[n-1][M])%M;
				if (map[n-1][tmp]==val) {
					//System.out.println(j+" 3");
					same[n-1][tmp] = true;
					same[n][j] = true;
				}
				tmp = (((j-idx)+M)%M+map[n+1][M])%M;
				if (map[n+1][tmp]==val) {
					//System.out.println(j+" 4");
					same[n+1][tmp] = true;
					same[n][j] = true;
				}
			}
			n = m[i++];
		}
		boolean ch = false;
		for (int x =1;x<=N;x++) {
			for (int y = 0; y<M; y++) {
				if (same[x][y]) {
					total -= map[x][y];
					num--;
					map[x][y] = 0;
					ch = true;
				}
			}
		}
		
		return ch;
	}
	
	static void go() {
		double ave = (double)total/num;
		//System.out.println(ave);
		for (int i = 1; i<=N;i++) {
			for (int j = 0; j<M; j++) {
				if (map[i][j]==0) {
					continue;
				}else if (map[i][j]>ave) {
					map[i][j]--;
					total --;
				}else if (map[i][j]<ave) {
					map[i][j]++;
					total++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N+2][M+1];
		
		total = 0;
		num = N*M;
		for (int n = 1; n<=N;n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m<M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				total += map[n][m];
			}
		}
		
		int x,d,k;
		int[] moved = new int[N+1];
		boolean ch = false;
		for (int t = 0; t<T; t++) {
			
//			System.out.println();
//			for (int i = 0; i<N+2; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			int n = 1;
			for(;N>=n*x;n++) {
				if (d==0) {
					map[n*x][M] = (map[n*x][M]-k+M)%M;
					moved[n-1] = n*x;
				}else {
					map[n*x][M] = (map[n*x][M]+k)%M;
					moved[n-1] = n*x;
				}
			}
			moved[n-1] = 0;
			
			if (t==0||!ch) {
				for (int m=0; m<N;m++) {
					moved[m] = m+1;
				}
			}
//			System.out.println();
//			System.out.println(Arrays.toString(moved));
//			System.out.println();
//			for (int i = 0; i<N+2; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
			ch = check(moved);
			if (!ch) {
				go();
			}
//			System.out.println();
//			for (int i = 0; i<N+2; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
		}
		System.out.println(total);
	}
}
