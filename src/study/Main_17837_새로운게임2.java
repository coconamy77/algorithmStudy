package study;

import java.io.*;
import java.util.*;

class Pawn{
	int name;
	int d;
	Pawn top = null;
	public Pawn(int name,int d) {
		this.name = name;
		this.d = d;
	}
	
	public boolean hasTop() {
		if (top==null) {
			return false;
		}
		return true;
	}
	
	
}

class Room{
	int color;
	Pawn bottom;
	int count;
	Pawn top;
	
	public Room(int color) {
		this.count = 0;
		this.color= color;
	}
	
	public void newTop(Pawn top) {
		this.top.top = top;
		this.top = top;
		count++;
	}
	
	public int getMoveCount(int name) {
		int c = 0;
		Pawn tmp = bottom;
		
		while(tmp.name!=name) {
			c++;
			tmp = tmp.top;
		}
		
		int move = count-c;
		count = c;
		return move;
	}
	
}

public class Main_17837_새로운게임2 {

	static Room[][] map;
	static Pawn[] pawns;
	static int N,K;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new Room[N][N];
		pawns = new Pawn[K+1];
		
		int tmp= 0;
		for (int n = 0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m<N; m++) {
				tmp = Integer.parseInt(st.nextToken());
				if (tmp>0) {
					//빨간색:1, 파란색:2
					map[n][m] = new Room(tmp);
				}
			}
		}
		
		int x, y, d;
		for(int k = 1; k<=K; k++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			Pawn p = new Pawn(k,d);
			
			pawns[k] = p;
			
			if (map[x][y]==null) {
				map[x][y] = new Room(0);
			}
			if (map[x][y])
			
		}
	}
	
}
