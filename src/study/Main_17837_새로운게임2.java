package study;

import java.io.*;
import java.util.*;

class Pawn {
	int name;
	int d;
	Pawn top = null;
	int x, y;

	public Pawn(int name, int d, int x, int y) {
		this.name = name;
		this.d = d;
		this.x = x;
		this.y = y;
	}

	public boolean hasTop() {
		if (top == null) {
			return false;
		}
		return true;
	}

	public void move(int x, int y) {
		Pawn tmp = this;
		this.x = x;
		this.y = y;
		while (tmp.hasTop()) {
			tmp = tmp.top;
			tmp.x = x;
			tmp.y = y;
		}
	}
	
	public Pawn uad(int dep, int x, int y) {
		this.x = x;
		this.y = y;
		if (hasTop()) {
			top.uad(dep+1,x,y).top = this;
		}
		if (dep==0) {
			this.top = null;
		}
		return this;
	}

}

class Room {
	int color;
	Pawn bottom;
	int count;
	Pawn top;

	public Room(int color) {
		this.count = 0;
		this.color = color;
	}

	public boolean newTop(Pawn top, int newCount) {
		count += newCount;
		if (count >= 4) {
			return true;
		}
		if (this.count == 0) {
			this.bottom = top;
		} else {
			this.top.top = top;
		}
		this.top = top;
		return false;
	}

	public int moved(int name) {
		int cnt = count;
		if (bottom.name==name) {
			count = 0;
			this.bottom = null;
			this.top = null;
			return cnt;
		}
		Pawn tmp = bottom;
		int c = 1;
		while(tmp.top.name!=name) {
			tmp = tmp.top;
			c++;
		}
		tmp.top = null;
		this.top = tmp;
		cnt = count-c;
		count = c;
		return cnt;
	}
	
	

}

public class Main_17837_새로운게임2 {

	static Room[][] map;
	static Pawn[] pawns;
	static int N, K;
	
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	
	
	static boolean move(Pawn p, boolean isSec) {
		int k = p.name;
		int ox = p.x,oy = p.y;
		int x = ox + dx[p.d];
		int y = oy + dy[p.d];

		if (x >= 0 && x < N && y >= 0 && y < N) {
			if (map[x][y] == null) {
				map[x][y] = new Room(0);
			}
			switch(map[x][y].color) {
			case 0:
				p.move(x, y);
				return map[x][y].newTop(p, map[ox][oy].moved(k));
			case 1:
				p.uad(0,x,y);
				return map[x][y].newTop(p, map[ox][oy].moved(k));
				
			default:
				if (isSec) {
					return false;
				}
				p.d = (p.d+2)%4;
				return move(p,true);
			}
		}else {
			p.d = (p.d+2)%4;
			return move(p,true);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new Room[N][N];
		pawns = new Pawn[K + 1];

		int tmp = 0;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				tmp = Integer.parseInt(st.nextToken());
				if (tmp > 0) {
					// 빨간색:1, 파란색:2
					map[n][m] = new Room(tmp);
				}
			}
		}

		int x, y, d;
		Pawn p;
		for (int k = 1; k <= K; k++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken()) - 1;

			p = new Pawn(k, d, x, y);

			pawns[k] = p;

			if (map[x][y] == null) {
				map[x][y] = new Room(0);
			}
			map[x][y].newTop(p, 1);
		}

		tmp = 0;
		while (tmp <= 1000) {
			tmp++;
			for (int k = 1; k <= K; k++) {
				p = pawns[k];
				if(move(p,false)) {
					break;
				}
			}
		}

		if (tmp > 1000) {
			System.out.println(-1);
		} else {
			System.out.println(tmp);
		}
	}

}
