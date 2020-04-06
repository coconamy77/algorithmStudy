package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2210_숫자판점프 {
	static Set<Integer> set = new HashSet<>();
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] map = new int[5][5];
	
	static void go(int i, int j, int dep, int v) {
		if (dep == -1) {
			set.add(v);
		} else {
			int nx,ny;
			for (int d = 0; d<4; d++) {
				nx = i+dx[d];
				ny = j+dy[d];
				
				if (nx>=0 && nx<5 && ny>=0 && ny<5) {
					go(nx, ny, dep-1, (int)(v+(map[nx][ny]*Math.pow(10, dep))));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j<5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i<5; i++) {
			for (int j = 0; j<5; j++) {
				go(i,j, 4,map[i][j]*100000);
			}
		}
		
		System.out.println(set.size());
	}
}
