package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15684_사다리조작 {
	
	static int N,H,numA;
	static int[][] map;
	static int[] accept;
	
	static boolean check(int dept, int start) {
		if (dept==-1) {
			for (int j = 0; j<N; j++) {
				int flag = j;
				for(int i = 0; i<N-1;i++) {
					if (flag!=0 && map[i][flag-1] ==-1) {
						flag--;
					}
					else if (flag!=N-1 && map[i][flag+1] ==-1) {
						flag++;
					}
					
				}
				if (flag != j) {
					break;
				}
			}
			return true;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[N - 1][H];
		accept = new int[(N-1)*H];
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = -1;
		}

		for (int j = 0; j < H; j++) {
			for (int i = 0; i < N - 1; i++) {
				if (map[i][j] == 0) {
					if (j != 0 && map[i][j - 1] == 1) {
						continue;
					} 
					if (j != N - 2 && map[i][j + 1] == 1) {
						continue;
					}
					accept[numA++] = i*100+j;
				}
			}
		}
		
		for (int n =0;n<3;n++) {
			check(n,0);
		}

	}
}
