package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_13460_구슬탈출2 {

	class State{
		int[][] loc = new int[2][2];
		int move;
		int d;
		int fin;
		
		public State(int rx, int ry, int bx, int by,int d, int move) {
			this.loc[0][0] = rx;
			this.loc[0][1] = ry;
			this.loc[1][0] = bx;
			this.loc[1][1] = by;
			this.d = d;
			this.move = move;
			this.fin = 0;
		}
		
		public int move() {
			move++;
			switch(d) {
			case 0:
				if (loc[0][0]==loc[1][0]) {
					if (loc[0][1]>loc[1][1]) {
						if (moveBall(0,0,1)) {
							fin = move;
						}
						if (moveBall(1,0,1)) {
							fin = -1;
							return fin;
						}
					}else {
						if (moveBall(1,0,1)) {
							fin = -1;
							return  fin;
						}
						if(moveBall(0,0,1)) {
							fin = move;
						}
					}
				}else {
					if (moveBall(1,0,1)) {
						fin = -1;
						return  fin;
					}
					if(moveBall(0,0,1)) {
						fin = move;
					}
				}
				break;
			case 1:
				if (loc[0][1]==loc[1][1]) {
					if (loc[0][0]>loc[1][0]) {
						if (moveBall(0,1,0)) {
							fin = move;
						}
						if (moveBall(1,1,0)) {
							fin = -1;
							return fin;
						}
					}else {
						if (moveBall(1,1,0)) {
							fin = -1;
							return fin;
						}
						if(moveBall(0,1,0)) {
							fin = move;
						}
					}
				}else {
					if (moveBall(1,1,0)) {
						fin = -1;
						return fin;
					}
					if(moveBall(0,1,0)) {
						fin = move;
					}
				}
				break;
			case 2:
				if (loc[0][0]==loc[1][0]) {
					if (loc[0][1]<loc[1][1]) {
						if (moveBall(0,0,-1)) {
							fin = move;
						}
						if (moveBall(1,0,-1)) {
							fin = -1;
							return fin;
						}
					}else {
						if (moveBall(1,0,-1)) {
							fin = -1;
							return fin;
						}
						if(moveBall(0,0,-1)) {
							fin = move;
						}
					}
				}else {
					if (moveBall(1,0,-1)) {
						fin = -1;
						return fin;
					}
					if(moveBall(0,0,-1)) {
						fin = move;
					}
				}
				break;
			case 3:
				if (loc[0][1]==loc[1][1]) {
					if (loc[0][0]<loc[1][0]) {
						if (moveBall(0,-1,0)) {
							fin = move;
						}
						if (moveBall(1,-1,0)) {
							fin = -1;
							return fin;
						}
					}else {
						if (moveBall(1,-1,0)) {
							fin = -1;
							return fin;
						}
						if(moveBall(0,-1,0)) {
							fin = move;
						}
					}
				}else {
					if (moveBall(1,-1,0)) {
						fin = -1;
						return fin;
					}
					if(moveBall(0,-1,0)) {
						fin = move;
					}
				}
				break;
			}

			if (map[loc[0][0]][loc[0][1]]==-2) {
				return -1;
			}
			return fin;
			
		}
		
		public boolean moveBall(int ball,int dx,int dy) {
			int nx = loc[ball][0]+dx;
			int ny = loc[ball][1]+dy;
			
			while(map[nx][ny]==0) {
				nx = nx+dx;
				ny = ny+dy;
			}
			if (map[nx][ny] == 2) {
				return true;
			
			}else {
				loc[ball][0] = nx-dx;
				loc[ball][1] = ny-dy;
			}
			return false;
		}
		
		public State(int[][] loc, int d, int move) {
			this.loc[0][0] = loc[0][0];
			this.loc[0][1] = loc[0][1];
			this.loc[1][0] = loc[1][0];
			this.loc[1][1] = loc[1][1];
			this.d = d;
			this.move = move;
		}
		public State makeNew(int d) {
			return new State(loc,d,this.move);
		}
	}
	static int[][] map;
	static int N,M;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int hx,hy;
	
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		String s;
		int rx = 0,ry = 0,bx = 0,by = 0;
		//구멍-2, 빨강-3, 파랑-4
		for (int n = 0; n<N; n++) {
			s = br.readLine();
			for (int m = 0; m<M; m++) {
				switch(s.charAt(m)) {
				case '#':
					map[n][m] = -1;
					break;
				case 'O':
					map[n][m] = 2;
					hx = n;
					hy = m;
					break;
				case 'R':
					map[n][m] = 3;
					rx = n;
					ry = m;
					break;
				case 'B':
					map[n][m] = 4;
					bx = n;
					by = m;
					break;
				}
			}
		}
		
//		for (int i = 0; i<N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		Queue<State> q = new LinkedList<State>();
		Main_13460_구슬탈출2 m = new Main_13460_구슬탈출2();
		for (int d = 0; d<4; d++) {
			q.add(m.new State(rx,ry,bx,by,d,0));
		}
		
		boolean fin = false;
		
		State tmp;
		int r;
		while(!q.isEmpty()) {
			tmp = q.poll();
			if (tmp.move>10) {
				break;
			}
			r = tmp.move();
			if (r==0) {
				map[tmp.loc[0][0]][tmp.loc[0][1]]=-2;
				System.out.println(tmp.move+" "+tmp.d);
				q.add(tmp.makeNew((tmp.d-1+4)%4));
				q.add(tmp.makeNew(tmp.d+1%4));
			}
			else if (r>0) {
				fin = true;
				System.out.println(r);
				break;
			}
			
		}
		if (!fin) {
			System.out.println(-1);
		}
		
		
	}
}
