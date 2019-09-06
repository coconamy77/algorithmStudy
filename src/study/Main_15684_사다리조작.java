package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15684_사다리조작 {
	
	static int N,H,numA;
	static int[][] map;
	static int[] accept;
	
	static boolean check(int dept, int start) {
		boolean ans = false;
		if (dept==0) {
			for (int j = 0; j<N; j++) {
				int flag = j;
				for(int i = 0; i<H;i++) {
					if (flag>0 && map[i][flag-1] ==-1) {
						flag--;
					}
					else if (flag<N-1 && map[i][flag] ==-1) {
						flag++;
					}
					
				}
				if (flag != j) {
					return false;
				}
			}
			return true;
		}else {
			for (int i  = start;i<numA;i++) {
				int t = accept[i];
				int x = t/100;
				int y = t%100;
				if (y != 0 && map[x][y - 1] == -1) {
					continue;
				} 
				map[x][y] = -1;
				ans = check(dept-1,i+1);
				map[x][y] = 0;
				if (ans) break;
			}
			return ans;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][N-1];
		accept = new int[H*(N-1)];
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a][b] = -1;
		}

		for (int j = 0; j < N-1; j++) {
			for (int i = 0; i < H; i++) {
				if (map[i][j] == 0) {
					if (j != 0 && map[i][j - 1] == -1) {
						continue;
					} 
					if (j !=N - 2 && map[i][j + 1] == -1) {
						continue;
					}
					accept[numA++] = i*100+j;
				}
			}
		}
		int ans = -1;
		for (int n =0;n<4;n++) {
			if(check(n,0)) {
				ans = n;
				break;
			}
		}
		System.out.println(ans);
	}
}
