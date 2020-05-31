package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class State{
	int[][] loc = new int[2][2];
	int move;
	int d;
	int fin;
	
	public State(int rx, int ry, int bx, int by,int d) {
		this.loc[0][0] = rx;
		this.loc[0][1] = ry;
		this.loc[1][0] = bx;
		this.loc[1][1] = by;
		this.d = d;
		this.move = 0;
		this.fin = 0;
	}
	
	public void chD(int d) {
		this.d = d;
	}
	
	public void move() {
		move++;
		switch(d) {
		case 0:
			if (loc[0][0]==loc[1][0]) {
				if (loc[0][1]>loc[1][1]) {
					if (moveBall(0)) {
						fin = move;
					}
					if (moveBall(1)) {
						fin = -1;
						return;
					}
				}else {
					if (moveBall(1)) {
						fin = -1;
						return;
					}
					if(moveBall(0)) {
						fin = move;
					}
				}
			}else {
				if (moveBall(1)) {
					fin = -1;
					return;
				}
				if(moveBall(0)) {
					fin = move;
				}
			}
			break;
		case 1:
			if (loc[0][1]==loc[1][1]) {
				if (loc[0][0]>loc[1][0]) {
					if (moveBall(0)) {
						fin = move;
					}
					if (moveBall(1)) {
						fin = -1;
						return;
					}
				}else {
					if (moveBall(1)) {
						fin = -1;
						return;
					}
					if(moveBall(0)) {
						fin = move;
					}
				}
			}else {
				if (moveBall(1)) {
					fin = -1;
					return;
				}
				if(moveBall(0)) {
					fin = move;
				}
			}
			break;
		case 2:
			if (loc[0][0]==loc[1][0]) {
				if (loc[0][1]<loc[1][1]) {
					if (moveBall(0)) {
						fin = move;
					}
					if (moveBall(1)) {
						fin = -1;
						return;
					}
				}else {
					if (moveBall(1)) {
						fin = -1;
						return;
					}
					if(moveBall(0)) {
						fin = move;
					}
				}
			}else {
				if (moveBall(1)) {
					fin = -1;
					return;
				}
				if(moveBall(0)) {
					fin = move;
				}
			}
			break;
		case 3:
			if (loc[0][1]==loc[1][1]) {
				if (loc[0][0]<loc[1][0]) {
					if (moveBall(0)) {
						fin = move;
					}
					if (moveBall(1)) {
						fin = -1;
						return;
					}
				}else {
					if (moveBall(1)) {
						fin = -1;
						return;
					}
					if(moveBall(0)) {
						fin = move;
					}
				}
			}else {
				if (moveBall(1)) {
					fin = -1;
					return;
				}
				if(moveBall(0)) {
					fin = move;
				}
			}
			break;
		}
		
	}
	
	public boolean moveBall(int ball) {
		
		
		
		return false;
	}
}

public class Main_13460_구슬탈출2 {

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
				case '0':
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
		
		Queue<State> q = new LinkedList<State>();
		
		for (int d = 0; d<4; d++) {
			q.add(new State(rx,ry,bx,by,d));
		}
		
		boolean fin = false;
		
		State tmp;
		while(!q.isEmpty() && !fin) {
			tmp = q.poll();
			
			tmp.move();
			
			
			
		}
		
		
	}
}
