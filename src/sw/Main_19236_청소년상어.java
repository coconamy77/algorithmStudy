package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Fish {
	int name;
	int dir;
	int x;
	int y;

	public Fish(int name, int dir, int x, int y) {
		this.name = name;
		this.dir = dir;
		this.x = x;
		this.y = y;
	}

	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void turn() {
		dir++;
		if (dir == 8) {
			dir = 0;
		}
	}
}

public class Main_19236_청소년상어 {

	static Fish[][] map = new Fish[4][4];
	static Fish[] fish = new Fish[17];
	static int sx = 0, sy = 0, sd = 0;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int answer = 0;

	static boolean range(int x, int y) {
		if (x >= 0 && y >= 0 && x < 4 && y < 4) {
			return true;
		}
		return false;
	}

	static void getNew(Fish f) {
		int nx, ny;
		nx = f.x + dx[f.dir];
		ny = f.y + dy[f.dir];

		while (!range(nx, ny) || map[nx][ny] == fish[0]) {
			f.turn();
			nx = f.x + dx[f.dir];
			ny = f.y + dy[f.dir];
		}
		f.move(nx, ny);
	}

	static void moveFish() {
		System.out.println("물고기 움직여");
		Fish f;
		int ox, oy, nx, ny;
		for (int i = 1; i < 17; i++) {
			if (fish[i] == null) {
				continue;
			}
			f = fish[i];
			ox = f.x;
			oy = f.y;
			getNew(f);
			nx = f.x;
			ny = f.y;
			if (map[nx][ny] != null) {
				map[ox][oy] = map[nx][ny];
				map[ox][oy].move(ox, oy);
			}
			map[nx][ny] = f;
		}
	}

	public static int movable() {
		int m = 0;
		int nx, ny;
		for (int i = 1; i < 4; i++) {
			nx = sx + dx[sd] * i;
			ny = sy + dy[sd] * i;
			if (!range(nx, ny)) {
				return m;
			}
			m++;
		}
		return m;
	}

	public static void copymap(Fish[][] ori, Fish[][] tmp) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				tmp[i][j] = ori[i][j];
			}
		}
	}

	public static void copyFish(Fish[] ori, Fish[] tmp) {
		for (int i = 0; i < 17; i++) {
			tmp[i] = ori[i];
		}
	}

	public static void getAnswer(int sum) {
		int movable = movable();
		if (movable == 0) {
			if (sum > answer)
				answer = sum;
			return;
		}
		Fish[][] tmp = new Fish[4][4];
		copymap(map, tmp);
		Fish[] tmpfish = new Fish[17];
		copyFish(fish, tmpfish);
		int ox = sx, oy = sy, od = sd;
		int tmpval = 0;
		for (int m = 1; m <= 3; m++) {
			if (map[sx+dx[sd]*m][sy+dy[sd]*m]==null) {
				continue;
			}
			tmpval = moveShark(sx+dx[sd]*m,sy+dy[sd]*m);
			moveFish();
			getAnswer(sum + tmpval);
			sx = ox;
			sy = oy;
			sd = od;
			copymap(tmp, map);
			copyFish(tmpfish, fish);
		}
	}

	public static int moveShark(int nx, int ny) {
		int val = 0;

		map[sx][sy] = null;
		
		sx = nx; 
		sy = ny;

		val = map[sx][sy].name;
		map[sx][sy] = fish[0];
		sd = fish[val].dir;
		fish[0].dir = sd;
		fish[val] = null;
		fish[0].move(sx, sy);

		return val;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n, d;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				n = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken())-1;
				fish[n] = new Fish(n, d, i, j);
				map[i][j] = fish[n];
			}
		}
		sd = map[0][0].dir;
		answer = map[0][0].name;
		fish[0] = new Fish(0, sd, 0, 0);// 상어는 0번!!
		map[0][0] = fish[0];
		fish[answer] = null;

		moveFish();

		getAnswer(answer);

	}
}
