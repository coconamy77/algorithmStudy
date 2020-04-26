package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17779_게리멘더링2 {

	static int[][] map;
	static int N;
	
	static int check(int x, int y, int p1, int p2) {
		
		boolean[][] vst = new boolean[N][N];
		int max = 0;
		int min = 0;
		int sum =0;

		//1구역
		for (int i = 0; i<x+p1;i++) {
			if (i<x) {
				for (int j = 0; j<=y;j++) {
					sum += map[i][j];
					vst[i][j] = true;
				}
			}else {
				for (int j = 0; j<=y-(i-x+1);j++) {
					sum += map[i][j];
					vst[i][j] = true;
				}
			}
		}
		min = sum;
		max = sum;
		
		//2구역
		sum = 0;
		for (int j = y+1; j<N; j++) {
			if (j<=y+p2) {
				for (int i = 0; i<x+(j-y);i++) {
					sum += map[i][j];
					vst[i][j] = true;
				}
			}else {
				for (int i = 0; i<=x+p2;i++) {
					sum += map[i][j];
					vst[i][j] = true;
				}
			}
		}
		if (min>sum) {
			min = sum;
			//System.out.println("min은 2구역");
		}
		if (max<sum) {
			max = sum;
			//System.out.println("max은 2구역");
		}
		
		//3구역
		sum = 0;
		int tx = x+p1;
		int ty = y-p1;
		for (int i = tx;i<N; i++) {
			if (i<tx+p2) {
				for (int j = 0; j<ty+(i-tx);j++) {
					sum += map[i][j];
					vst[i][j] = true;
				}
			}else {
				for (int j = 0; j<ty+p2;j++) {
					sum += map[i][j];
					vst[i][j] = true;
				}
			}
		}
		if (min>sum) {
			min = sum;
			//System.out.println("min은 3구역");
		}
		if (max<sum) {
			max = sum;
			//System.out.println("max은 3구역");
		}
		
		
		//4구역
		sum = 0;
		tx = x+p1+p2;
		ty = (y-p1)+p2;
		for (int i = N-1; i>tx-p1;i--) {
			if (i>tx) {
				for (int j = N-1;j>=ty;j-- ) {
					sum += map[i][j];
					vst[i][j] = true;
				}
			}else {
				for (int j = N-1; j>ty+(tx-i);j--) {
					sum += map[i][j];
					vst[i][j] = true;
				}
			}
		}
		if (min>sum) {
			min = sum;
			//System.out.println("min은 4구역");
		}
		if (max<sum) {
			max = sum;
			//System.out.println("max은 4구역");
		}
		
		
		//5구역
		sum = 0; 
		for (int i =0 ; i<N; i++) {
			for (int j = 0; j<N; j++) {
				if (!vst[i][j]) {
					sum += map[i][j];
				}
			}
		}
		if (min>sum) {
			min = sum;
			//System.out.println("min은 5구역");
		}
		if (max<sum) {
			max = sum;
			//System.out.println("max은 5구역");
		}
		//System.out.println(max + ", "+min);
		
//		for (int i = 0; i<N; i++) {
//			System.out.println(Arrays.toString(vst[i]));
//		}
		
		return max-min;
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		int ans = Integer.MAX_VALUE;
		int tmp = 0;
		for (int i =0; i<N-1; i++) {
			for (int j = 1; j<N-1; j++) {
				int x = 1, y = 1;
				for (; i+x+y<N;x++) {
					
					if (j-x<0) {
						break;
					}
					for (;i+x+y<N;y++) {
						if (j+y>=N) {
							break;
						}
						tmp = check(i,j, x, y);
						//System.out.println("i="+i+", j="+j+", x="+x+", y="+y+", tmp = "+tmp);
						if (tmp<ans) {
							ans = tmp;
						}
					}
					y = 1;
				}
			}
		}
		
		System.out.println(ans);
		
	}
}
