package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Box{
	int time;
	int sname;
	Shark shark;
	
	public Box(int time, Shark shark) {
		this.time = time;
		this.shark = shark;
		this.sname = shark.name;
	}
	
	public boolean isGone(int now, int k) {
		if (now-time==k) {
			return true;
		}else {
			return false;
		}
	}
	
	public void sharkGone() {
		this.shark = null;
	}
	
	public boolean isShark() {
		return this.shark==null?false:true;
	}
	
	public void newS(int time, Shark shark) {
		this.time = time;
		this.shark = shark;
	}
}

class Shark{
	int name;
	int d;
	int[][] da = new int[4][4];
	
	public Shark(int name) {
		this.name = name;
	}

	public void setD(int d) {
		this.d = d;
	}

	public void setDa(int i, int j, int d) {
		da[i][j] = d;
	}
	
	public void turn() {
		d++;
		if (d==4) {
			d = 0;
		}
	}
}

public class Main_19237_어른상어 {
	
	static Box[][] map;
	static Shark[] shark;
	static int N,M,K;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new Box[N][N];
		shark = new Shark[M+1];
		
		int tmp = 0;
		for (int n = 0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m<N; m++) {
				tmp  = Integer.parseInt(st.nextToken());
				if (tmp==0) {
					continue;
				}else {
					shark[tmp] = new Shark(tmp);
					map[n][m] = new Box(0, shark[tmp]);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int m = 1; m<=M;m++) {
			shark[m].setD(Integer.parseInt(st.nextToken())-1);
		}
		
		for (int i = 0; i<M; i++) {			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j<4; j++) {
				shark[i+1].setDa(i, j, Integer.parseInt(st.nextToken())-1);
			}
		}
		
		int k = 0;
		while(M>1 || k<=1000) {
			for (int i = 0; i<N; i++) {
				for (int j = 0; j<N; j++) {
					if(map[i][j]==null) {
						continue;
					}
					
				}
			}
			k++;
		}
	}
}










