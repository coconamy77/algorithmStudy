package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17136_색종이붙이기 {

	static int[][] map;
	static int min = 26;

	static void paste(int[] paper,int count ) {
		if(count>=min) return;
		boolean fin = true;
		for (int i = 0; i<10; i++) {
			for (int j=0; j<10;j++) {
				if (map[i][j]==1) {
					fin = false;
					if (count>=min-1) return;
					for (int k = 5; k>0;k--) {
						if (paper[k]<5 && getSize(i,j, k)) {
							change(i,j,k,0);
							paper[k]++;
							paste(paper,count+1);
							paper[k]--;
							change(i,j,k,1);
						}
					}					
				}
			}
		}
		if (fin) min = min>count? count: min;
		
	}
	
	static boolean getSize(int x, int y, int size) {
		if (10-x<size || 10-y<size) {
			return false;
		}
		
		for (int i = x; i<x+size;i++) {
			for (int j = y;j<y+size; j++) {
				if (map[i][j]==0) return false;
			}
		}
		return true;
	}
	
	static void change(int x, int y, int size, int v) {
		for (int i = x; i<x+size;i++) {
			for (int j = y;j<y+size; j++) {
				map[i][j]=v;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[10][10];
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] paper = new int[6];
		paste(paper,0);
		if (min==26)System.out.println(-1);
		else System.out.println(min);
	}

}
