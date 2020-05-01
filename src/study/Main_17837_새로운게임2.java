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
			(top.uad(dep+1,x,y)).top = this;
			//System.out.println(top.name+" "+ (top.top).name);
		}
		if (dep==0) {
			this.top = null;
		}
		//System.out.println(this.name);
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

	public boolean newTop(Pawn bottom,Pawn top, int newCount) {
		if (count+newCount >= 4) {
			return true;
		}
		
		if (count == 0) {
			this.bottom = bottom;
		} else {
			this.top.top = bottom;
		}
		this.top = top;
		count += newCount;
		return false;
	}

	public int moved(int name) {
		//System.out.println("여기 moved: "+name);
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
	
	public String toString() {
		if (bottom==null) {
			return "[0 0 0 0] ";
		}else {
			return "["+bottom.name+" "+bottom.d+" "+top.name+" "+top.d+"] ";
		}
				
	}
	

}

public class Main_17837_새로운게임2 {

	static Room[][] map;
	static Pawn[] pawns;
	static int N, K;
	
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	
	
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
				return map[x][y].newTop(p,map[ox][oy].top, map[ox][oy].moved(k));
			case 1:
				p.uad(0,x,y);
				return map[x][y].newTop(map[ox][oy].top,p, map[ox][oy].moved(k));
				
			default:
				if (isSec) {
					return false;
				}
				if (p.d==0) {
					p.d = 1;
				}else if(p.d == 1) {
					p.d  = 0;
				}else if (p.d ==2) {
					p.d = 3;
				}else {
					p.d = 2;
				}
				return move(p,true);
			}
		}else {
			if (isSec) {
				return false;
			}
			if (p.d==0) {
				p.d = 1;
			}else if(p.d == 1) {
				p.d  = 0;
			}else if (p.d ==2) {
				p.d = 3;
			}else {
				p.d = 2;
			}
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
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			d = Integer.parseInt(st.nextToken()) - 1;

			p = new Pawn(k, d, x, y);

			pawns[k] = p;

			if (map[x][y] == null) {
				map[x][y] = new Room(0);
			}
			map[x][y].newTop(p,p, 1);
		}

		tmp = 0;
		while (tmp <= 1000) {
			tmp++;
			//System.out.println(tmp+"번째");
			
			
			for (int k = 1; k <= K; k++) {
				p = pawns[k];
//				System.out.println(k+"말이 움직");
//				for (int n = 0; n<N; n++) {
//					for (int m = 0; m<N; m++) {
//						if (map[n][m]==null) {
//							System.out.print("[0 0 0 0] ");
//						}
//						else {
//							System.out.print(map[n][m].toString());
//						}
//					}
//					System.out.println();
//				}
				if(move(p,false)) {
					System.out.println(tmp);
					return;
				}
			}
		}

			System.out.println(-1);
		
	}

}

//
//0 1 2 0 1 1
//1 2 0 1 1 0
//2 1 0 1 1 0
//1 0 1 1 0 2
//2 0 1 2 0 1
//0 2 1 0 2 1
//
//→, ←, ↑, ↓


















