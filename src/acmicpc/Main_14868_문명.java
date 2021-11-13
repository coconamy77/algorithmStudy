package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14868_문명 {
	static int[][] map;
	static int[] uf;
	static int N, K;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static void check(Queue<int[]> list, Queue<int[]> q) {
		int x =0, y = 0, nx = 0, ny = 0;
		while(!list.isEmpty()) {
			int[] tmp = list.poll();
			x = tmp[0];
			y = tmp[1];
			for(int d = 0; d<4; d++) {
				nx = x+dx[d];
				ny = y+dy[d];
				if(nx>0 && ny>0 && nx<=N && ny<=N && map[nx][ny]>0) {
					union(x,y,nx,ny);
				}
			}
			q.add(tmp);
		}
	}

	static int union(int x,int y,int nx, int ny) {
		int ok = find(map[x][y]);
		int nk = find(map[nx][ny]);
		
		if(ok<nk) {
			uf[nk] = ok;
			K--;
		}else if(ok>nk) {
			uf[ok] = nk;
			K--;
		}
		map[x][y] = uf[nk];
		map[nx][ny] = uf[nk];
		return uf[nk];
	}
	
	static int find(int k) {
		if(uf[k]==k) {
			return k;
		}
		if(uf[k]==0) {
			uf[k] = k;
			return k;
		}
		uf[k] = find(uf[k]);
		return uf[k];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		uf = new int[K + 1];
		Queue<int[]> q = new LinkedList<int[]>();
		Queue<int[]> list = new LinkedList<int[]>();;

		int x = 0, y = 0;
		for (int k = 1; k <= K; k++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			map[x][y] = k;
			list.add(new int[] {x,y});
		}
		
		int answer = 0, nx = 0, ny = 0,k = 0;
		int tmp[];
		while(K>1) {
//			System.out.println();
//			for (int i = 1; i < N + 1; i++) {
//				System.out.println();
//				for (int j = 1; j < N + 1; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//			}
			check(list,q);
			if(K<=1) {
				break;
			}
			answer++;
			while(!q.isEmpty()) {
				tmp = q.poll();
				x = tmp[0];
				y = tmp[1];
				k = find(map[x][y]);
				map[x][y] = k;
				for(int d = 0; d<4; d++) {
					nx = x+dx[d];
					ny = y+dy[d];
					if(nx>0 && ny>0 && nx<=N && ny<=N && map[nx][ny]!=k) {
						if(map[nx][ny]==0) {
							map[nx][ny] = k;
							list.add(new int[] {nx,ny});
						}else {
							k = union(x,y,nx,ny);
							if(K==1) {
								System.out.println(answer);
								return;
							}
						}
					}
				}
			}
		}
		
		System.out.println(answer);
		
		
	}
}
