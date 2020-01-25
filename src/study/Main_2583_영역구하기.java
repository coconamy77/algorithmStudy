package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2583_영역구하기 {
	
	static void fill(int[][] map, int x, int y, int xx, int yy) {
		
		for (int i = x; i<xx; i++) {
			for (int j = y; j<yy; j++) {
				map[i][j] = 1;
			}
			
		}
		
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		boolean[][] vst = new boolean[N][M];
		
		int sx,sy,ex,ey;
		for (int k = 0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			sx= Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			
			fill(map, sx,sy,ex,ey);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		int count = 0,area = 0;
		List<Integer> list = new ArrayList<Integer>();
		int tx,ty,nx, ny;
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<M; j++) {
				if (map[i][j]==0 && !vst[i][j]) {
					area = 0;
					count++;
					vst[i][j] = true;
					q.add(i*100+j);
					//System.out.println(i+" "+j);
					while(!q.isEmpty()) {
						tx = q.poll();
						ty = tx%100;
						tx = tx/100;
						area++;
						
						for (int d = 0; d<4; d++) {
							nx = tx+dx[d];
							ny = ty+dy[d];
							if (nx>=0 && ny>=0 &&nx<N && ny<M &&map[nx][ny]==0 && !vst[nx][ny]) {
								q.add(nx*100+ny);
								vst[nx][ny] = true;
							}
						}
						
					}
					list.add(area);
				}
			}
		}
		for (int[] a: map) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println(count);
		Collections.sort(list);
		for (int i: list) {
			System.out.print(i+" ");
		}
		
	}
}
