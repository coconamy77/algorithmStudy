package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Shark {
	int spd;
	int d;
	int size;
	int name;
	
	public Shark(int spd, int d, int size, int name) {
		super();
		this.spd = spd;
		this.d = d-1;
		this.size = size;
		this.name = name;
	}
/*
	@Override
	public String toString() {
		return String.valueOf((char)('A'+name));
	}*/

}

public class KingofFishing_17143 {

	static Shark[][] map;
	static int S;

	static void moveShark(int i, int j, boolean[] vst) {
		Shark s = map[i][j];
		map[i][j] = null;
		vst[s.name] = true;

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		int nx = i;
		int ny = j;
		switch (s.d) {
		case 0:
		case 1:
		
			for (int go = 0; go<s.spd; go++) {
				nx = nx+dx[s.d];
				if (nx==-1) {
					nx = 0;
					s.d = 1;
					go--;
				}else if (nx == map.length) {
					nx = map.length-1;
					s.d = 0;
					go--;
				}
			}
			
			break;
		case 2:
		case 3:
			for (int go = 0; go<s.spd; go++) {
				ny = ny+dy[s.d];
				if (ny==-1) {
					ny = 0;
					s.d = 2;
					go--;
				}else if (ny == map[0].length) {
					ny = map[0].length-1;
					s.d = 3;
					go--;
				}
			}
		}
		if (map[nx][ny] != null) {
			if (!vst[map[nx][ny].name]) {
				moveShark(nx, ny, vst);
			} 
			if (map[nx][ny] != null) {
				Shark tmp = map[nx][ny];
				if (tmp.size < s.size) {
					map[nx][ny] = s;
				}
			}
			else map[nx][ny] = s;

		}
		else map[nx][ny] = s;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		map = new Shark[N][M];
		int sum = 0;
		for (int s = 0; s < S; s++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = new Shark(
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), s);

		}
		/*for (Shark[] a : map) {
			System.out.println(Arrays.toString(a));
		}*/
		for (int m = 0; m < M; m++) {
			//System.out.println(m);
			for (int n = 0; n < N; n++) {
				if (map[n][m] != null) {
					//System.out.println(map[n][m].name+" 잡음");
					sum += map[n][m].size;
					map[n][m] = null;
					break;
				}
			}
			
			boolean[] vst = new boolean[S];
			//System.out.println(Arrays.toString(vst));
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != null && !vst[map[i][j].name])
						moveShark(i, j, vst);
				}
			}
			/*System.out.println();
			for (Shark[] a : map) {
				System.out.println(Arrays.toString(a));
			}
			*/
		}

		System.out.println(sum);
	}
}
